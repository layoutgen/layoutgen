package art.scidsgn.layoutgen.interpreter.stdlib.utils

import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import kotlin.math.PI

object TrigFunctionUtils {
    private val unitConversionMap = mapOf(
        Pair("rad") { x: Double -> x },
        Pair("deg") { x: Double -> x * PI / 180 },
    )

    fun getValue(context: FunctionContext, argName: String = "x"): Double {
        var x = context.argumentSingleValue<Double>(argName, TypeName.NUMBER)

        if (context.hasArgument("unit")) {
            val converter = context.argumentEnumValue("unit", unitConversionMap)
            x = converter(x)
        }

        return x
    }

    fun getInverseValue(context: FunctionContext, function: (x: Double) -> Double): Double {
        var y = function(context.argumentSingleValue("x", TypeName.NUMBER))

        if (context.hasArgument("unit")) {
            val converter = context.argumentEnumValue("unit", unitConversionMap)
            y = converter(y)
        }

        return y
    }

    fun getInverseValue(context: FunctionContext, value: Double): Double {
        var y = value

        if (context.hasArgument("unit")) {
            val converter = context.argumentEnumValue("unit", unitConversionMap)
            y = converter(y)
        }

        return y
    }
}