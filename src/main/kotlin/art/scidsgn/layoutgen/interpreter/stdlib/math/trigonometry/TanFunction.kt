package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import kotlin.math.tan

class TanFunction : BuiltinFunction("Tan") {
    override fun execute(context: FunctionContext): Double {
        return tan(TrigFunctionUtils.getValue(context))
    }
}