package art.scidsgn.layoutgen.components.text

import java.awt.font.FontRenderContext
import java.awt.font.LineBreakMeasurer
import java.awt.font.TextAttribute
import java.awt.font.TextLayout
import java.awt.geom.AffineTransform
import java.text.AttributedString
import kotlin.math.max

class TextBoxAlgorithm(val text: String, val initialWidth: Double, val font: Font) {
    val textLayouts = mutableListOf<TextLayout>()

    var targetWidth = 0.0
    var targetHeight = 0.0

    fun layOut() {
        val attributedString = AttributedString(text)
        attributedString.addAttribute(TextAttribute.FONT, font.toAwtFont())

        val paragraph = attributedString.iterator
        val lineBreakMeasurer =
            LineBreakMeasurer(paragraph, FontRenderContext(AffineTransform(), true, true))

        var maxWidth = 0.0
        var height = 0.0

        while (lineBreakMeasurer.position < paragraph.endIndex) {
            val layout = lineBreakMeasurer.nextLayout(initialWidth.toFloat())
            textLayouts += layout

            maxWidth = max(maxWidth, layout.advance.toDouble())
            height += layout.ascent + layout.descent + layout.leading
        }

        if (initialWidth == Double.POSITIVE_INFINITY) {
            targetWidth = maxWidth
        } else {
            targetWidth = initialWidth
        }
        targetHeight = height
    }
}