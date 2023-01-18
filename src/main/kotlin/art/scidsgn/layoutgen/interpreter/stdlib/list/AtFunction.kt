package art.scidsgn.layoutgen.interpreter.stdlib.list

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class AtFunction : BuiltinFunction("At") {
    override fun execute(context: FunctionContext): Any {
        val list = context.body<Any>(TypeName.BASE)

        return list[
                context.argumentSingleValue<Double>("index", TypeName.NUMBER) {
                    if (it < 0 || it >= list.size) {
                        throw GeneralError(Errors.LIST_INDEX_MUST_BE_WITHIN_RANGE, emptyArray())
                    } else if (it.rem(1) != 0.0) {
                        throw GeneralError(Errors.LIST_REPEAT_COUNT_MUST_BE_AN_INTEGER, emptyArray())
                    }
                }.toInt()
        ]
    }
}