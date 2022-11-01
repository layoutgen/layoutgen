package art.scidsgn.layoutgen.interpreter.stdlib.string

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class LengthFunction : BuiltinFunction("Length") {
    override fun execute(context: FunctionContext): Double {
        return context.argumentSingleValue<String>("of", TypeName.STRING).length.toDouble()
    }
}