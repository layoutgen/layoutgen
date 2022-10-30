package art.scidsgn.layoutgen.interpreter.stdlib.math.comparison

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class LessFunction : BuiltinFunction("Less") {
    override fun execute(context: FunctionContext): Boolean {
        val x = context.argumentSingleValue<Double>("x", TypeName.NUMBER)
        val than = context.argumentSingleValue<Double>("than", TypeName.NUMBER)

        return x < than
    }
}