package art.scidsgn.layoutgen.interpreter.stdlib.list

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.flat

class RepeatFunction : BuiltinFunction("Repeat") {
    override fun execute(context: FunctionContext): List<Any> {
        val targetList = mutableListOf<Any>()
        val n = context.argumentSingleValue<Double>("count", TypeName.NUMBER) {
            if (it < 0) {
                throw GeneralError(Errors.LIST_REPEAT_COUNT_CANNOT_BE_NEGATIVE, emptyArray())
            } else if (it.rem(1) != 0.0) {
                throw GeneralError(Errors.LIST_REPEAT_COUNT_MUST_BE_AN_INTEGER, emptyArray())
            }
        }.toInt()

        for (i in 0 until n) {
            context.builtinCall.body.forEach {
                targetList += context.interpreter.interpretElement(
                    context.ruleTree,
                    it,
                    context.ruleArguments,
                    context.depth
                )
            }
        }

        return targetList.flat()
    }
}
