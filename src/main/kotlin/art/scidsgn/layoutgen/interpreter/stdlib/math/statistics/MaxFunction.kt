package art.scidsgn.layoutgen.interpreter.stdlib.math.statistics

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class MaxFunction : BuiltinFunction("Max") {
    override fun execute(context: FunctionContext): Double {
        return context.body<Double>().max()
    }
}