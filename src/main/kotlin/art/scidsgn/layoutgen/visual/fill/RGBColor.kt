package art.scidsgn.layoutgen.visual.fill

import art.scidsgn.layoutgen.components.Component
import java.awt.Color
import kotlin.math.max
import kotlin.math.min

data class RGBColor(val red: Double, val green: Double, val blue: Double, val alpha: Double) :
    Fill() {
    override fun toAwtPaint(target: Component): Color {
        return Color(
            min(255.0, max(0.0, red)).toInt(),
            min(255.0, max(0.0, green)).toInt(),
            min(255.0, max(0.0, blue)).toInt(),
            min(255.0, max(0.0, alpha)).toInt()
        )
    }
}
