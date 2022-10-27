package art.scidsgn.layoutgen.interpreter.stdlib.visual.render

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.fill.Fill
import art.scidsgn.layoutgen.visual.stroke.LineCap
import art.scidsgn.layoutgen.visual.stroke.LineJoin
import art.scidsgn.layoutgen.visual.stroke.Stroke

class StrokeFunction : BuiltinFunction("Stroke") {
    private val lineCapMap = mapOf(
        Pair("butt", LineCap.BUTT),
        Pair("round", LineCap.ROUND),
        Pair("square", LineCap.SQUARE),
    )

    private val lineJoinMap = mapOf(
        Pair("bevel", LineJoin.BEVEL),
        Pair("miter", LineJoin.MITER),
        Pair("round", LineJoin.ROUND),
    )

    override fun execute(context: FunctionContext): Stroke {
        val fill = context.argumentSingleValue<Fill>("fill", TypeName.FILL)

        var width = 1.0
        if (context.hasArgument("width")) {
            width = context.argumentSingleValue("width", TypeName.NUMBER)
        }

        var lineCap = LineCap.BUTT
        if (context.hasArgument("lineCap")) {
            lineCap = context.argumentEnumValue("lineCap", lineCapMap)
        }

        var lineJoin = LineJoin.MITER
        if (context.hasArgument("lineJoin")) {
            lineJoin = context.argumentEnumValue("lineJoin", lineJoinMap)
        }

        return Stroke(fill, width, lineCap, lineJoin)
    }
}