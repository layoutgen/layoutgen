package demos.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.VTiling
import art.scidsgn.layoutgen.layout.components.flexbox.Flexbox
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexDirection
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexItemAlignment
import art.scidsgn.layoutgen.layout.withFlexGrow
import art.scidsgn.layoutgen.layout.withHeight
import art.scidsgn.layoutgen.layout.withSize

fun createFlexbox(): Component {
    return VTiling(
        listOf(
            Flexbox(
                listOf(
                    Box().withHeight(40.0).withFlexGrow(1.0),
                    Box().withSize(40.0, 40.0),
                    Box().withSize(40.0, 40.0),
                    Box().withSize(40.0, 40.0),
                    Box(
                        Box().withSize(20.0, 20.0)
                    ).withFlexGrow(2.0),
                    Box().withSize(40.0, 40.0)
                )
            ).withGap(32.0)
                .withJustifyContent(FlexContentAlignment.SPACE_BETWEEN)
                .withAlignContent(FlexContentAlignment.SPACE_BETWEEN)
                .withAlignItems(FlexItemAlignment.FLEX_END)
                .withFlexWrap(true)
                .withFlexDirection(FlexDirection.ROW)
                .withHeight(300.0),
            Flexbox(
                listOf(
                    Box().withSize(120.0, 120.0),
                    Box().withHeight(80.0).withFlexGrow(1.5),
                    Box().withSize(20.0, 20.0),
                    Box().withHeight(100.0).withFlexGrow(1.0),
                    Box().withSize(50.0, 50.0),
                    Box().withSize(90.0, 90.0)
                )
            ).withGap(8.0)
                .withJustifyContent(FlexContentAlignment.CENTER)
                .withAlignContent(FlexContentAlignment.CENTER)
                .withAlignItems(FlexItemAlignment.FLEX_END)
                .withFlexWrap(true)
                .withFlexDirection(FlexDirection.ROW)
        )
    )
}

fun main() {
    LayoutDemoBase.runDemoOf(createFlexbox(), "Flexbox test")
}