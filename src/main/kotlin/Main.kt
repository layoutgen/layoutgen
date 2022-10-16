import art.scidsgn.layoutgen.debug.layout.LayoutDebugGenerator
import art.scidsgn.layoutgen.layout.*
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.*
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
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
                        Box().withWidth(150.0),
                        Box().withSize(40.0, 100.0),
                        Grid(
                            2, 2,
                            listOf(
                                Box(),
                                Box(),
                                Box().withHeight(20.0),
                                Box().withSize(30.0, 30.0)
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
                                Box().withSize(30.0, 30.0)
                            )
                        ).withGap(8.0).withSize(100.0, 100.0)
                            .withCellHorizontalAlignment(HorizontalAlignment.MIDDLE)
                            .withCellVerticalAlignment(VerticalAlignment.CENTER),
                        HStack(
                            listOf(
                                Box().withSize(50.0, 30.0),
                                Box().withSize(20.0, 80.0)
                            )
                        ).withGap(8.0).withVerticalAlignment(VerticalAlignment.CENTER),
                        OverlapHStack(
                            listOf(
                                Box().withSize(48.0, 48.0),
                                Box().withSize(48.0, 48.0),
                                Grid(
                                    2, 2,
                                    listOf(
                                        Box().withSize(16.0, 16.0),
                                        Box().withSize(16.0, 16.0),
                                        Box().withSize(16.0, 16.0),
                                        Box().withSize(16.0, 16.0),
                                    )
                                ).withGap(4.0)
                            )
                        ).withGap(16.0).withVerticalAlignment(VerticalAlignment.CENTER)
                    )
                ).withHorizontalAlignment(HorizontalAlignment.MIDDLE).withVerticalAlignment(VerticalAlignment.CENTER)
                    .withHeight(250.0)
                    .withGap(8.0),
                OverlapVStack(
                    listOf(
                        Box().withSize(60.0, 60.0),
                        Box().withSize(60.0, 60.0),
                        Box().withSize(60.0, 60.0)
                    )
                ).withGap(16.0).withHorizontalAlignment(HorizontalAlignment.MIDDLE)
                    .withVerticalAlignment(VerticalAlignment.CENTER)
                    .withSize(80.0, 150.0)
            )
        ).withVerticalAlignment(VerticalAlignment.CENTER).withGap(8.0)
    )
}

fun paintOnPanel(panel: JPanel) {
    val root = createRootComponent()
    LayoutEngine.layOut(root, Dimensions(panel.width.toDouble(), panel.height.toDouble()))

    val image = LayoutDebugGenerator.createImage(root, Random(2))
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