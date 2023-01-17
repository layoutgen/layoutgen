package art.scidsgn.layoutgen.visual.fill

import art.scidsgn.layoutgen.components.Component
import java.awt.Color
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

data class HSLColor(val hue: Double, val saturation: Double, val lightness: Double, val alpha: Double) :
    Fill() {
    override fun toAwtPaint(target: Component): Color {
        val h = hue % 360
        val sl = saturation / 100.0
        val l = lightness / 100.0

        val c = (1 - abs(2 * l - 1)) * sl
        val hp = h / 60.0
        val x = c * (1 - abs((hp % 2) - 1))

        val offset = l - c / 2

        var red = 0.0
        var green = 0.0
        var blue = 0.0

        if (hp < 1) {
            red = c + offset
            green = x + offset
            blue = offset
        } else if (hp < 2) {
            red = x + offset
            green = c + offset
            blue = offset
        } else if (hp < 3) {
            red = offset
            green = c + offset
            blue = x + offset
        } else if (hp < 4) {
            red = offset
            green = x + offset
            blue = c + offset
        } else if (hp < 5) {
            red = x + offset
            green = offset
            blue = c + offset
        } else {
            red = c + offset
            green = offset
            blue = x + offset
        }

        return Color(
            min(255.0, max(0.0, red * 255)).toInt(),
            min(255.0, max(0.0, green * 255)).toInt(),
            min(255.0, max(0.0, blue * 255)).toInt(),
            min(255.0, max(0.0, alpha)).toInt()
        )
    }
}
