package art.scidsgn.layoutgen.visual.fill

import art.scidsgn.layoutgen.components.Component
import java.awt.LinearGradientPaint
import java.awt.geom.Point2D
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

data class LinearGradient(val angle: Double, val stops: List<GradientStop>) : Fill() {
    override fun toAwtPaint(target: Component): LinearGradientPaint {
        val aspectRatio = target.size.targetSize.width / target.size.targetSize.height
        val scaledHalfLineLength = target.size.targetSize.height * halfLineLength(aspectRatio) / 2

        val halfX = target.size.targetSize.width / 2
        val halfY = target.size.targetSize.height / 2

        return LinearGradientPaint(
            Point2D.Double(
                halfX - cos(angle) * scaledHalfLineLength,
                halfY - sin(angle) * scaledHalfLineLength
            ),
            Point2D.Double(
                halfX + cos(angle) * scaledHalfLineLength,
                halfY + sin(angle) * scaledHalfLineLength
            ),
            stops.map { it.position.toFloat() }.toFloatArray(),
            stops.map { it.color.toAwtPaint(target) }.toTypedArray()
        )
    }

    private fun firstQuadrantHalfLineLength(angle: Double, aspectRatio: Double): Double {
        return cos(angle) * (aspectRatio + tan(angle))
    }

    private fun halfLineLength(aspectRatio: Double): Double {
        val a = angle % PI

        if (a > PI / 2) {
            return firstQuadrantHalfLineLength(PI - a, aspectRatio)
        } else {
            return firstQuadrantHalfLineLength(a, aspectRatio)
        }
    }
}