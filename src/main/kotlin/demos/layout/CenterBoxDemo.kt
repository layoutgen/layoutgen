package demos.layout

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.utils.CenterBox
import art.scidsgn.layoutgen.layout.components.withSize

fun main() {
    LayoutDemoBase.runDemoOf(
        CenterBox(
            Box().withSize(300.0, 300.0)
        ),
        "CenterBox test"
    )
}