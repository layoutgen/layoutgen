package art.scidsgn.layoutgen.components.shapes

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.components.Component
import java.awt.Shape
import java.awt.geom.Ellipse2D

class Circle(children: List<Component>) : Box(children) {
    override fun createShape(): Shape {
        return Ellipse2D.Double(0.0, 0.0, size.targetSize.width, size.targetSize.height)
    }
}