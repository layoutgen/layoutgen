package art.scidsgn.layoutgen.interpreter.stdlib.lsystem

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.flat
import art.scidsgn.layoutgen.ruletree.ast.RuleCall
import art.scidsgn.layoutgen.ruletree.ast.RuleName

class LSystemFunction : BuiltinFunction("LSystem") {
    override fun execute(context: FunctionContext): Any {
        val depth = context.argumentSingleValue<Double>("depth", TypeName.NUMBER) {
            if (it < 0) {
                throw GeneralError(Errors.LSYSTEM_DEPTH_CANNOT_BE_NEGATIVE)
            } else if (it.rem(1.0) != 0.0) {
                throw GeneralError(Errors.LSYSTEM_DEPTH_MUST_BE_AN_INTEGER)
            }
        }.toInt()

        var ruleNames = collectInitialState(context)

        for (i in 1..depth) {
            ruleNames = next(context, ruleNames)
        }

        val output = mutableListOf<Any>()

        ruleNames.forEach {
            val isRule = context.ruleTree.getIsRule(it)
            output.addAll(context.interpreter.execute(isRule, emptyMap()))
        }

        return output.flat()
    }

    private fun collectInitialState(context: FunctionContext): List<RuleName> {
        val ruleNames = mutableListOf<RuleName>()

        context.builtinCall.body.forEach {
            if (it !is RuleCall) {
                throw InFileError(Errors.LSYSTEM_MUST_BE_A_RULENAME, emptyArray(), it.codePosition)
            } else if (it.arguments.isNotEmpty()) {
                throw InFileError(Errors.LSYSTEM_CANNOT_BE_PARAMETRIZED, emptyArray(), it.codePosition)
            } else if (it.name.moduleName != null) {
                throw InFileError(Errors.LSYSTEM_CANNOT_BE_A_MODULENAME, emptyArray(), it.codePosition)
            }
            ruleNames.add(it.name)
        }

        return ruleNames
    }

    private fun next(context: FunctionContext, state: List<RuleName>): List<RuleName> {
        val newRuleNames = mutableListOf<RuleName>()

        state.forEach {
            if (context.ruleTree.hasRewriteRule(it.name)) {
                newRuleNames.addAll(context.interpreter.evaluateRewrite(context.ruleTree.getRewriteRule(it.name)))
            } else {
                newRuleNames.add(it)
            }
        }

        return newRuleNames
    }
}