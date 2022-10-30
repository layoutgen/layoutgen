package art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry

import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import kotlin.math.PI

object TrigFunctionUtils {
    fun getValue(context: FunctionContext): Double {
        if (context.hasArgument("x")) {
            return context.argumentSingleValue("x", TypeName.NUMBER)
        } else if (context.hasArgument("deg")) {
            return context.argumentSingleValue<Double>("deg", TypeName.NUMBER) * PI / 180
        }

        TODO("trig arg error")
    }
}