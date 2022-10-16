import art.scidsgn.layoutgen.debug.layout.LayoutDebugGenerator
import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.*
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.withDefinedSize
import java.awt.Dimension
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants
import kotlin.random.Random

fun createRootComponent(): Component {
    return Box(
        HTiling(
            listOf(
                VTiling(
                    listOf(
                        Box(),
                        Box().withDefinedSize(Dimensions(40.0, 100.0)),
                        Grid(
                            2, 2,
                            listOf(
                                Box(),
                                Box(),
                                Box(),
                                Box().withDefinedSize(Dimensions(30.0, 30.0))
                            )
                        ).withGap(8.0),
                        Box()
                    )
                ).withHorizontalAlignment(HorizontalAlignment.RIGHT),
                VStack(
                    listOf(
                        Grid(
                            2, 2,
                            listOf(
                                Box(),
                                Box(),
                                Box(),
                                Box().withDefinedSize(Dimensions(30.0, 30.0))
                            )
                        ).withGap(8.0).withDefinedSize(Dimensions(100.0, 100.0))
                            .withCellHorizontalAlignment(HorizontalAlignment.MIDDLE)
                            .withCellVerticalAlignment(VerticalAlignment.CENTER),
                        HStack(
                            listOf(
                                Box().withDefinedSize(Dimensions(50.0, 30.0)),
                                Box().withDefinedSize(Dimensions(20.0, 80.0))
                            )
                        ).withGap(8.0).withVerticalAlignment(VerticalAlignment.CENTER),
                        OverlapHStack(
                            listOf(
                                Box().withDefinedSize(Dimensions(48.0, 48.0)),
                                Box().withDefinedSize(Dimensions(48.0, 48.0)),
                                Grid(
                                    2, 2,
                                    listOf(
                                        Box().withDefinedSize(Dimensions(16.0, 16.0)),
                                        Box().withDefinedSize(Dimensions(16.0, 16.0)),
                                        Box().withDefinedSize(Dimensions(16.0, 16.0)),
                                        Box().withDefinedSize(Dimensions(16.0, 16.0)),
                                    )
                                ).withGap(4.0)
                            )
                        ).withGap(16.0).withVerticalAlignment(VerticalAlignment.CENTER)
                    )
                ).withHorizontalAlignment(HorizontalAlignment.MIDDLE).withVerticalAlignment(VerticalAlignment.CENTER)
                    .withGap(8.0),
                OverlapVStack(
                    listOf(
                        Box().withDefinedSize(Dimensions(60.0, 60.0)),
                        Box().withDefinedSize(Dimensions(60.0, 60.0)),
                        Box().withDefinedSize(Dimensions(60.0, 60.0))
                    )
                ).withGap(16.0).withHorizontalAlignment(HorizontalAlignment.MIDDLE)
                    .withVerticalAlignment(VerticalAlignment.CENTER)
                    .withDefinedSize(Dimensions(80.0, 150.0))
            )
        ).withVerticalAlignment(VerticalAlignment.CENTER).withGap(8.0)
    )
}

fun paintOnPanel(panel: JPanel) {
    val root = createRootComponent()
    LayoutEngine.layOut(root, Dimensions(panel.width.toDouble(), panel.height.toDouble()))

    val image = LayoutDebugGenerator.createImage(root, Random(1))
    panel.graphics.drawImage(image, 0, 0, null)
}

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Layout Engine test")

        val panel = JPanel()
        panel.preferredSize = Dimension(600, 600)
        panel.addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                paintOnPanel(panel)
            }
        })

        frame.contentPane = panel
        frame.pack()
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.isVisible = true

        paintOnPanel(panel)
    }
}