package demos.layout

import art.scidsgn.layoutgen.debug.layout.LayoutDebugGenerator
import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import java.awt.Dimension
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants
import kotlin.random.Random

object LayoutDemoBase {
    private fun paintOnPanel(root: Component, panel: JPanel) {
        LayoutEngine.resetLayout(root)
        LayoutEngine.layOut(root, Dimensions(panel.width.toDouble(), panel.height.toDouble()))

        val image = LayoutDebugGenerator.createImage(root, Random(2))
        panel.graphics.drawImage(image, 0, 0, null)
    }

    fun runDemoOf(component: Component, title: String) {
        SwingUtilities.invokeLater {
            val frame = JFrame(title)

            val panel = JPanel()
            panel.preferredSize = Dimension(600, 600)
            panel.addComponentListener(object : ComponentAdapter() {
                override fun componentResized(e: ComponentEvent?) {
                    paintOnPanel(component, panel)
                }
            })

            frame.contentPane = panel
            frame.pack()
            frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame.isVisible = true

            paintOnPanel(component, panel)
        }
    }
}