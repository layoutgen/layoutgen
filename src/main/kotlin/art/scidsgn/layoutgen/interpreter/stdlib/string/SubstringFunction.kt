package art.scidsgn.layoutgen.interpreter.stdlib.string

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class SubstringFunction : BuiltinFunction("Substring") {
    override fun execute(context: FunctionContext): String {
        return context.argumentSingleValue<String>("string", TypeName.STRING)
            .substring(
                context.argumentSingleValue<Double>("from", TypeName.NUMBER) {
                    if (it.rem(1) != 0.0) {
                        throw GeneralError(Errors.STRING_SUBSTRING_RANGE_NOT_INTEGER)
                    }
                }.toInt(),
                context.argumentSingleValue<Double>("to", TypeName.NUMBER) {
                    if (it.rem(1) != 0.0) {
                        throw GeneralError(Errors.STRING_SUBSTRING_RANGE_NOT_INTEGER)
                    }
                }.toInt()
            )
    }
}
