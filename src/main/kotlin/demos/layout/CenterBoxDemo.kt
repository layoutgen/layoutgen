package demos.layout

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.components.layout.utils.CenterBox
import art.scidsgn.layoutgen.components.layout.utils.MarginBox
import art.scidsgn.layoutgen.components.withSize
import art.scidsgn.layoutgen.components.sizing.Margins

fun main() {
    LayoutDemoBase.runDemoOf(
        CenterBox(
            listOf(
                MarginBox(
                    Margins(8.0, 16.0, 24.0, 32.0),
                    listOf(Box().withSize(300.0, 300.0))
                )
            )
        ),
        "CenterBox test"
    )
}