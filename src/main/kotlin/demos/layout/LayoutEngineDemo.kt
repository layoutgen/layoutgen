package demos

import art.scidsgn.layoutgen.components.*
import art.scidsgn.layoutgen.components.layout.alignment.HorizontalAlignment
import art.scidsgn.layoutgen.components.layout.alignment.VerticalAlignment
import art.scidsgn.layoutgen.components.layout.grid.Grid
import art.scidsgn.layoutgen.components.layout.stack.HStack
import art.scidsgn.layoutgen.components.layout.stack.OverlapHStack
import art.scidsgn.layoutgen.components.layout.stack.OverlapVStack
import art.scidsgn.layoutgen.components.layout.stack.VStack
import art.scidsgn.layoutgen.components.layout.tiling.HTiling
import art.scidsgn.layoutgen.components.layout.tiling.VTiling
import art.scidsgn.layoutgen.components.layout.withGap
import demos.layout.LayoutDemoBase

fun createRootComponent(): Component {
    return HTiling(
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
                            Box().withSize(50.0, 15.0),
                            Box(),
                            Box(),
                            Box().withSize(30.0, 30.0)
                        )
                    ).withGap(8.0)
                        .withCellHorizontalAlignment(HorizontalAlignment.MIDDLE)
                        .withCellVerticalAlignment(VerticalAlignment.CENTER),
                    HStack(
                        listOf(
                            Box().withSize(50.0, 30.0),
                            Box().withWidth(30.0)
                        )
                    ).withGap(8.0).withVerticalAlignment(VerticalAlignment.CENTER)
                        .withVerticalStretch(true),
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
            ).withHorizontalAlignment(HorizontalAlignment.MIDDLE).withVerticalAlignment(
                VerticalAlignment.CENTER
            )
                .withHeight(250.0)
                .withGap(8.0),
            OverlapVStack(
                listOf(
                    Box().withSize(60.0, 60.0),
                    Box().withSize(60.0, 60.0),
                    Box().withHeight(90.0)
                )
            ).withGap(16.0).withHorizontalAlignment(HorizontalAlignment.MIDDLE)
                .withVerticalAlignment(VerticalAlignment.CENTER)
                .withSize(80.0, 150.0)
                .withHorizontalStretch(true)
        )
    ).withVerticalAlignment(VerticalAlignment.CENTER).withGap(8.0)
}

fun main() {
    LayoutDemoBase.runDemoOf(createRootComponent(), "Layout Engine test")
}