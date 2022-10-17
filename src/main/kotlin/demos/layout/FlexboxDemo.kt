package demos.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.flexbox.Flexbox
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexDirection
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexItemAlignment
import art.scidsgn.layoutgen.layout.withSize

fun createFlexbox(): Component {
    return Flexbox(
        listOf(
            Box().withSize(140.0, 140.0),
            Box().withSize(80.0, 80.0),
            Box().withSize(20.0, 20.0),
            Box().withSize(100.0, 100.0),
            Box().withSize(200.0, 200.0),
            Box().withSize(90.0, 90.0)
        )
    ).withGap(8.0)
        .withJustifyContent(FlexContentAlignment.CENTER)
        .withAlignContent(FlexContentAlignment.CENTER)
        .withAlignItems(FlexItemAlignment.FLEX_END)
        .withFlexWrap(true)
        .withFlexDirection(FlexDirection.ROW)
}

fun main() {
    LayoutDemoBase.runDemoOf(createFlexbox(), "Flexbox test")
}