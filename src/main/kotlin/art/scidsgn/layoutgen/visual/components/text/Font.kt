package art.scidsgn.layoutgen.visual.components.text

import java.awt.Font

data class Font(val familyName: String, val size: Double, val style: FontStyle) {
    fun toAwtFont(): Font {
        return Font(familyName, style.style, size.toInt())
    }
}
