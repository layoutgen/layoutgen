package art.scidsgn.layoutgen.interpreter.stdlib.string

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class ConcatenateFunction : BuiltinFunction("Concatenate") {
    override fun execute(context: FunctionContext): String {
        var separator = ""
        if (context.hasArgument("separator")) {
            separator = context.argumentSingleValue("separator", TypeName.STRING)
        }

        return context.body<Any>(TypeName.BASE).joinToString(separator)
    }
}