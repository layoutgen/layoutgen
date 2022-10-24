package demos.visual

import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.visual.VisualTreeRenderer
import java.awt.Dimension
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

object VisualDemoBase {
    private fun paintOnPanel(root: Component, panel: JPanel) {
        LayoutEngine.resetLayout(root)
        LayoutEngine.layOut(root, Dimensions(panel.width.toDouble(), panel.height.toDouble()))

        val image = VisualTreeRenderer(root).render()
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