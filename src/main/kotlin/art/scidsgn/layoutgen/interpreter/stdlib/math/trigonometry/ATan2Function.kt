package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.TrigFunctionUtils
import kotlin.math.atan2

class ATan2Function : BuiltinFunction("ATan2") {
    override fun execute(context: FunctionContext): Double {
        val value = atan2(
            context.argumentSingleValue("y", TypeName.NUMBER),
            context.argumentSingleValue("x", TypeName.NUMBER)
        )

        return TrigFunctionUtils.getInverseValue(context, value)
    }
}