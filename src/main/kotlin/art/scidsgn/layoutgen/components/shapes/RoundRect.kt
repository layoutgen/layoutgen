package art.scidsgn.layoutgen.components.shapes

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.components.Component
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
