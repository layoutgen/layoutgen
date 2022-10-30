package art.scidsgn.layoutgen.interpreter.stdlib.random

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class RandomFunction : BuiltinFunction("Random") {
    override fun execute(context: FunctionContext): Double {
        val from = context.argumentSingleValue<Double>("from", TypeName.NUMBER)
        val to = context.argumentSingleValue<Double>("to", TypeName.NUMBER)

        return context.interpreter.random.nextDouble(from, to)
    }
}