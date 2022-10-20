package art.scidsgn.layoutgen.interpreter.stdlib.math.statistics

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class MinFunction : BuiltinFunction("Min") {
    override fun execute(context: FunctionContext): Double {
        return context.body<Double>().min()
    }
}