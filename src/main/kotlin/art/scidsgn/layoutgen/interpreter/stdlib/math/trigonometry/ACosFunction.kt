package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import kotlin.math.acos

class ACosFunction : BuiltinFunction("ACos") {
    override fun execute(context: FunctionContext): Double {
        return TrigFunctionUtils.getInverseValue(context) { acos(it) }
    }
}