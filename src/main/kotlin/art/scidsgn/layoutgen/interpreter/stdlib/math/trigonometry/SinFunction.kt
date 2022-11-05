package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.stdlib.utils.TrigFunctionUtils
import kotlin.math.sin

class SinFunction : BuiltinFunction("Sin") {
    override fun execute(context: FunctionContext): Double {
        return sin(TrigFunctionUtils.getValue(context))
    }
}