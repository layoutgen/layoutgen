import art.scidsgn.layoutgen.debug.layout.LayoutDebugGenerator
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.HTiling
import art.scidsgn.layoutgen.layout.components.layout.VTiling
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import java.io.File
import javax.imageio.ImageIO

fun main() {
    val componentTree = Box(
        HTiling(
            listOf(
                VTiling(
                    listOf(
                        Box(),
                        Box().withDefinedSize(Dimensions(40.0, 100.0)),
                        Box(),
                        Box()
                    )
                ).withHorizontalAlignment(HorizontalAlignment.RIGHT),
                Box(),
                Box().withDefinedSize(Dimensions(80.0, 80.0)),
                Box()
            )
        ).withVerticalAlignment(VerticalAlignment.CENTER).withGap(8.0)
    )
    LayoutEngine.layOut(componentTree, Dimensions(400.0, 400.0))

    val debugImage = LayoutDebugGenerator.createImage(componentTree)
    ImageIO.write(debugImage, "png", File("images/test.png"))
}