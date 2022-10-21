package demos.layout

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.CenterBox
import art.scidsgn.layoutgen.layout.withSize

fun main() {
    LayoutDemoBase.runDemoOf(
        CenterBox(
            Box().withSize(300.0, 300.0)
        ),
        "CenterBox test"
    )
}