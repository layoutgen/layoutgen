import art.scidsgn.layoutgen.debug.layout.LayoutDebugGenerator
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.*
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
                HStack(
                    listOf(
                        HStack(
                            listOf(
                                Box().withDefinedSize(Dimensions(20.0, 20.0)),
                                Box().withDefinedSize(Dimensions(40.0, 20.0))
                            )
                        ),
                        VStack(
                            listOf(
                                Box().withDefinedSize(Dimensions(50.0, 30.0)),
                                Box().withDefinedSize(Dimensions(20.0, 80.0))
                            )
                        ).withGap(8.0)
                    )
                ).withHorizontalAlignment(HorizontalAlignment.MIDDLE).withVerticalAlignment(VerticalAlignment.CENTER)
                    .withGap(8.0),
                Box().withDefinedSize(Dimensions(80.0, 80.0)),
            )
        ).withVerticalAlignment(VerticalAlignment.CENTER).withGap(8.0)
    )
    LayoutEngine.layOut(componentTree, Dimensions(400.0, 400.0))

    val debugImage = LayoutDebugGenerator.createImage(componentTree)
    ImageIO.write(debugImage, "png", File("images/test.png"))
}