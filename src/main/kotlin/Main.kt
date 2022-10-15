import art.scidsgn.layoutgen.debug.layout.LayoutDebugGenerator
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.*
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.withDefinedSize
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