package art.scidsgn.layoutgen.ruletree.parsers.antlr

import art.scidsgn.layoutgen.rulecode.RulecodeBaseListener
import art.scidsgn.layoutgen.rulecode.RulecodeLexer
import art.scidsgn.layoutgen.rulecode.RulecodeParser
import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition
import art.scidsgn.layoutgen.ruletree.RuletreeGenerator
import art.scidsgn.layoutgen.ruletree.ast.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ParseTreeWalker

class AntlrRuletreeGenerator : RulecodeBaseListener(), RuletreeGenerator {
    lateinit var ruleTree: Ruletree

    private fun codePosition(token: Token): RuletreeCodePosition {
        return RuletreeCodePosition(token.line, token.charPositionInLine)
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
            return RuleName(moduleRuleNameCtx.ID(0).text, null, codePosition(moduleRuleNameCtx.start))
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

    override fun enterRewriteRule(ctx: RulecodeParser.RewriteRuleContext) {
        val rewriteRule = RewriteRule(ruleName(ctx.ruleName()), codePosition(ctx.start))

        // TODO: annotations

        parseRewriteRuleBranches(rewriteRule, ctx.rewriteBranch())

        ruleTree.rules += rewriteRule
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
        // TODO: trim start and end quote
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
        val builtinCall = BuiltinCall(builtinName(builtinFnCtx.builtinName()), codePosition(builtinFnCtx.start))

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
        val ruleCall = RuleCall(moduleRuleName(ruleCallCtx.moduleRuleName()), codePosition(ruleCallCtx.start))

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

            else -> TODO("uwu")
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

    override fun enterIsRule(ctx: RulecodeParser.IsRuleContext) {
        var isRule = IsRule(ruleName(ctx.ruleName()), codePosition(ctx.start))

        // TODO: annotations

        if (ctx.isVars != null) {
            parseIsRuleVariables(isRule, ctx.isVars)
        }

        parseIsRuleBranches(isRule, ctx.isBranch)

        ruleTree.rules += isRule
    }

    override fun enterImportStatement(ctx: RulecodeParser.ImportStatementContext) {
        ruleTree.import(ctx.ruleName().text, string(ctx.string()).string)
    }

    override fun parse(ruleTree: Ruletree, code: String) {
        val lexer = RulecodeLexer(CharStreams.fromString(code))
        val tokens = CommonTokenStream(lexer)
        val parser = RulecodeParser(tokens)
        val walker = ParseTreeWalker()

        this.ruleTree = ruleTree

        walker.walk(this, parser.program())
    }
}