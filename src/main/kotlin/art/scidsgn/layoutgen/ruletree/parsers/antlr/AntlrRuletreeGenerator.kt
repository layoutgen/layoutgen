package art.scidsgn.layoutgen.ruletree.parsers.antlr

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.rulecode.RulecodeBaseListener
import art.scidsgn.layoutgen.rulecode.RulecodeLexer
import art.scidsgn.layoutgen.rulecode.RulecodeParser
import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.RuletreeGenerator
import art.scidsgn.layoutgen.ruletree.ast.*
import art.scidsgn.layoutgen.ruletree.io.CodePosition
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTreeWalker

class AntlrRuletreeGenerator(val ruleTree: Ruletree) : RulecodeBaseListener() {
    companion object : RuletreeGenerator {
        override fun parse(ruleTree: Ruletree, code: String): Ruletree {
            val lexer = RulecodeLexer(CharStreams.fromString(code))
            val tokens = CommonTokenStream(lexer)
            val parser = RulecodeParser(tokens)
            val walker = ParseTreeWalker()

            parser.addErrorListener(AntlrRuletreeErrorListener(ruleTree))

            walker.walk(AntlrRuletreeGenerator(ruleTree), parser.program())

            return ruleTree
        }
    }

    override fun visitErrorNode(node: ErrorNode?) {
        println("uh")
    }

    override fun enterImportStatement(ctx: RulecodeParser.ImportStatementContext) {
        try {
            ruleTree.import(ctx.ruleName().text, string(ctx.string()).string)
        } catch (e: GeneralError) {
            throw InFileError(e, codePosition(ctx.start))
        }
    }

    override fun enterUseStatement(ctx: RulecodeParser.UseStatementContext) {
        try {
            ruleTree.importStd(ctx.ruleName().text)
        } catch (e: GeneralError) {
            throw InFileError(e, codePosition(ctx.start))
        }
    }

    override fun enterIsRule(ctx: RulecodeParser.IsRuleContext) {
        val isRule = IsRule(ruleTree, ruleName(ctx.ruleName()), codePosition(ctx.start))
        if (ruleTree.hasIsRule(isRule.name.name)) {
            throw InFileError(Errors.IS_RULE_ALREADY_DEFINED, arrayOf(isRule.name.name), isRule.name.codePosition)
        }

        if (ctx.annotationName() != null) {
            ctx.annotationName().forEach {
                isRule.annotations += it.ANNOTATION_ID().text
            }
        }

        if (ctx.isVars != null) {
            parseIsRuleVariables(isRule, ctx.isVars)
        }

        parseIsRuleBranches(isRule, ctx.isBranch)

        ruleTree.isRules += isRule
    }

    override fun enterRewriteRule(ctx: RulecodeParser.RewriteRuleContext) {
        val rewriteRule = RewriteRule(ruleTree, ruleName(ctx.ruleName()), codePosition(ctx.start))
        if (ruleTree.hasRewriteRule(rewriteRule.name.name))
            throw InFileError(
                Errors.REWRITE_RULE_ALREADY_DEFINED,
                arrayOf(rewriteRule.name.name),
                rewriteRule.name.codePosition
            )

        if (ctx.annotationName() != null) {
            ctx.annotationName().forEach {
                rewriteRule.annotations += it.ANNOTATION_ID().text
            }
        }

        parseRewriteRuleBranches(rewriteRule, ctx.rewriteBranch())

        ruleTree.rewriteRules += rewriteRule
    }

    private fun codePosition(token: Token): CodePosition {
        return CodePosition(ruleTree.sourceFile, token.line, token.charPositionInLine)
    }

    private fun ruleName(ruleNameCtx: RulecodeParser.RuleNameContext): RuleName {
        return RuleName(ruleNameCtx.text, null, codePosition(ruleNameCtx.start))
    }

    private fun moduleRuleName(moduleRuleNameCtx: RulecodeParser.ModuleRuleNameContext): RuleName {
        if (moduleRuleNameCtx.ID().size == 2) {
            return RuleName(
                moduleRuleNameCtx.ID(1).text,
                moduleRuleNameCtx.ID(0).text,
                codePosition(moduleRuleNameCtx.start)
            )
        } else {
            return RuleName(
                moduleRuleNameCtx.ID(0).text,
                null,
                codePosition(moduleRuleNameCtx.start)
            )
        }
    }

    private fun parseRewriteRuleBranches(
        rewriteRule: RewriteRule,
        branches: List<RulecodeParser.RewriteBranchContext>
    ) {
        branches.forEach {
            val branch = RuleBranch<RuleName>()

            if (it.branchWeight() != null) {
                branch.weight = it.branchWeight().NUMBER().text.toDouble()
            }

            it.ruleName().forEach { ruleNameCtx ->
                branch.items += ruleName(ruleNameCtx)
            }

            rewriteRule.branches += branch
        }
    }

    private fun boolean(booleanCtx: RulecodeParser.BooleanContext): BooleanElement {
        return BooleanElement(booleanCtx.text == "true", codePosition(booleanCtx.start))
    }

    private fun color(colorCtx: RulecodeParser.ColorContext): ColorElement {
        return ColorElement(colorCtx.text, codePosition(colorCtx.start))
    }

    private fun number(numberCtx: RulecodeParser.NumberContext): NumberElement {
        return NumberElement(numberCtx.NUMBER().text.toDouble(), codePosition(numberCtx.start))
    }

    private fun string(stringCtx: RulecodeParser.StringContext): StringElement {
        val text = stringCtx.text
        return StringElement(text.substring(1, text.length - 1), codePosition(stringCtx.start))
    }

    private fun variable(variableCtx: RulecodeParser.VariableNameContext): Variable {
        return Variable(variableCtx.text, codePosition(variableCtx.start))
    }

    private fun builtinName(builtinNameCtx: RulecodeParser.BuiltinNameContext): BuiltinName {
        return BuiltinName(builtinNameCtx.BUILTIN_ID().text, codePosition(builtinNameCtx.start))
    }

    private fun builtinCall(builtinFnCtx: RulecodeParser.BuiltinFnContext): BuiltinCall {
        val builtinCall =
            BuiltinCall(builtinName(builtinFnCtx.builtinName()), codePosition(builtinFnCtx.start))

        if (builtinFnCtx.fnCallArgs() != null) {
            builtinFnCtx.fnCallArgs().fnCallArg().forEach {
                builtinCall.arguments[it.ID().text] = parseElement(it.element())
            }
        }

        if (builtinFnCtx.fnCallBody() != null) {
            builtinCall.body += builtinFnCtx.fnCallBody().element().map { parseElement(it) }
        }

        return builtinCall
    }

    private fun ruleCall(ruleCallCtx: RulecodeParser.RuleFnContext): RuleCall {
        val ruleCall =
            RuleCall(moduleRuleName(ruleCallCtx.moduleRuleName()), codePosition(ruleCallCtx.start))

        if (ruleCallCtx.ruleCallArgs() != null) {
            ruleCallCtx.ruleCallArgs().ruleCallArg().forEach {
                ruleCall.arguments[it.variableName().text] = parseElement(it.element())
            }
        }

        return ruleCall
    }

    private fun parseElement(elementCtx: RulecodeParser.ElementContext): Element {
        return when {
            elementCtx.boolean_() != null -> boolean(elementCtx.boolean_())
            elementCtx.number() != null -> number(elementCtx.number())
            elementCtx.string() != null -> string(elementCtx.string())
            elementCtx.variableName() != null -> variable(elementCtx.variableName())
            elementCtx.color() != null -> color(elementCtx.color())
            elementCtx.builtinFn() != null -> builtinCall(elementCtx.builtinFn())
            elementCtx.ruleFn() != null -> ruleCall(elementCtx.ruleFn())

            else -> TODO("unknown element error")
        }
    }

    private fun parseIsRuleBranches(
        isRule: IsRule,
        branches: List<RulecodeParser.IsBranchContext>
    ) {
        branches.forEach {
            val branch = RuleBranch<Element>()

            if (it.branchWeight() != null) {
                branch.weight = it.branchWeight().NUMBER().text.toDouble()
            }

            it.element().forEach { elementCtx ->
                branch.items += parseElement(elementCtx)
            }

            isRule.branches += branch
        }
    }

    private fun parseIsRuleVariables(
        isRule: IsRule,
        variables: RulecodeParser.IsVarsContext
    ) {
        variables.variableName().forEach {
            isRule.variables += variable(it)
        }
    }
}