package art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class MulFunction : BuiltinFunction("Mul") {
    override fun execute(context: FunctionContext): Double {
        return context.body<Double>().reduce { acc, x -> acc * x }
    }
}