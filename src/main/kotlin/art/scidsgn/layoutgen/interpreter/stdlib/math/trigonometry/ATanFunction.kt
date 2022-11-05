package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.stdlib.utils.TrigFunctionUtils
import kotlin.math.atan

class ATanFunction : BuiltinFunction("ATan") {
    override fun execute(context: FunctionContext): Double {
        return TrigFunctionUtils.getInverseValue(context) { atan(it) }
    }
}