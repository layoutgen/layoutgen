package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.stdlib.utils.TrigFunctionUtils
import kotlin.math.cos

class CosFunction : BuiltinFunction("Cos") {
    override fun execute(context: FunctionContext): Double {
        return cos(TrigFunctionUtils.getValue(context))
    }
}