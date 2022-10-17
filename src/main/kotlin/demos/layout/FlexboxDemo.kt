package demos.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.layout.flexbox.Flexbox
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexDirection
import art.scidsgn.layoutgen.layout.withSize

fun createFlexbox(): Component {
    return Flexbox(
        listOf(
            Box().withSize(140.0, 140.0),
            Box().withSize(140.0, 140.0),
            Box().withSize(140.0, 140.0),
            Box().withSize(140.0, 140.0),
            Box().withSize(140.0, 140.0),
            Box().withSize(140.0, 140.0)
        )
    ).withGap(8.0)
        .withJustifyContent(FlexContentAlignment.SPACE_BETWEEN)
        .withAlignContent(FlexContentAlignment.CENTER)
        .withFlexWrap(true)
        .withFlexDirection(FlexDirection.COLUMN)
}

fun main() {
    LayoutDemoBase.runDemoOf(createFlexbox(), "Flexbox test")
}