package art.scidsgn.layoutgen.interpreter.stdlib.visual.fill

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry.TrigFunctionUtils
import art.scidsgn.layoutgen.visual.fill.LinearGradient
import kotlin.math.PI

class LinearGradientFunction : BuiltinFunction("LinearGradient") {
    private val directionMap = mapOf(
        Pair("right", 0.0),
        Pair("bottom", PI * 0.5),
        Pair("left", PI),
        Pair("top", PI * 1.5),
    )

    override fun execute(context: FunctionContext): Any {
        val angle = if (context.hasArgument("angle")) {
            TrigFunctionUtils.getValue(context, "angle")
        } else if (context.hasArgument("direction")) {
            context.argumentEnumValue("direction", directionMap)
        } else {
            TODO("dsfsd")
        }

        return LinearGradient(angle, context.body(TypeName.GRADIENT_STOP))
    }
}