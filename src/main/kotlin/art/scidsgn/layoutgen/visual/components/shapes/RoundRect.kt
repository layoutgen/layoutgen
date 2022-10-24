package art.scidsgn.layoutgen.visual.components.shapes

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.Component
import java.awt.Graphics2D

class RoundRect(var radius: Double, children: List<Component>) : Box(children) {
    override fun renderItself(gfx: Graphics2D) {
        gfx.fillRoundRect(
            0,
            0,
            size.targetSize.width.toInt(),
            size.targetSize.height.toInt(),
            radius.toInt(),
            radius.toInt()
        )
    }
}
