package art.scidsgn.layoutgen.interpreter.stdlib.math.statistics

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class MaxFunction : BuiltinFunction("Max") {
    override fun execute(context: FunctionContext): Double {
        return context.body<Double>(TypeName.NUMBER).max()
    }
}