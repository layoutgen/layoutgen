package art.scidsgn.layoutgen.visual.components.shapes

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.Component
import java.awt.Shape
import java.awt.geom.RoundRectangle2D

class RoundRect(var radius: Double, children: List<Component>) : Box(children) {
    override fun createShape(): Shape {
        return RoundRectangle2D.Double(
            0.0, 0.0, size.targetSize.width, size.targetSize.height,
            radius, radius
        )
    }
}
