package demos

import java.awt.*
import java.awt.font.FontRenderContext
import java.awt.font.LineBreakMeasurer
import java.awt.font.TextAttribute
import java.awt.geom.AffineTransform
import java.text.AttributedString
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

class LineBreakPanel : JPanel() {
    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        background = Color.WHITE

        val gfx = g as Graphics2D
        gfx.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

        val string = AttributedString(
            "Many people believe that Vincent van Gogh painted his best works " +
                    "during the two-year period he spent in Provence. Here is where he " +
                    "painted The Starry Night--which some consider to be his greatest " +
                    "work of all. However, as his artistic brilliance reached new " +
                    "heights in Provence, his physical and mental health plummeted. "
        )
        string.addAttribute(TextAttribute.FONT, Font("General Sans Regular", Font.BOLD, 20))
        string.addAttribute(TextAttribute.FOREGROUND, Color.RED, 0, 10)

        val paragraph = string.iterator
        val frc = FontRenderContext(AffineTransform(), true, true)
        val lineBreakMeasurer = LineBreakMeasurer(paragraph, frc)

        val breakWidth = Float.POSITIVE_INFINITY
        var offsetY = 0.toFloat()

        lineBreakMeasurer.position = paragraph.beginIndex

        while (lineBreakMeasurer.position < paragraph.endIndex) {
            val layout = lineBreakMeasurer.nextLayout(breakWidth)

            offsetY += layout.ascent

            layout.draw(gfx, 0.toFloat(), offsetY)

            offsetY += layout.descent + layout.leading
        }
    }
}

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Line breaks")

        frame.contentPane.add(LineBreakPanel())
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.isVisible = true
    }
}