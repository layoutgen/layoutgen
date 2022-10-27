package art.scidsgn.layoutgen.visual.stroke

import art.scidsgn.layoutgen.visual.fill.Fill
import java.awt.BasicStroke
import java.awt.Stroke

data class Stroke(
    val fill: Fill,
    val width: Double,
    val lineCap: LineCap = LineCap.BUTT,
    val lineJoin: LineJoin = LineJoin.MITER
) {
    fun toAwtStroke(): Stroke {
        val lineCapMapping = mapOf(
            Pair(LineCap.ROUND, BasicStroke.CAP_ROUND),
            Pair(LineCap.SQUARE, BasicStroke.CAP_SQUARE),
            Pair(LineCap.BUTT, BasicStroke.CAP_BUTT)
        )
        val lineJoinMapping = mapOf(
            Pair(LineJoin.BEVEL, BasicStroke.JOIN_BEVEL),
            Pair(LineJoin.MITER, BasicStroke.JOIN_MITER),
            Pair(LineJoin.ROUND, BasicStroke.JOIN_ROUND)
        )

        return BasicStroke(width.toFloat(), lineCapMapping[lineCap]!!, lineJoinMapping[lineJoin]!!)
    }
}
