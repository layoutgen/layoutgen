package art.scidsgn.layoutgen.visual.components.shapes

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.Component
import java.awt.Shape
import java.awt.geom.Ellipse2D

class Circle(children: List<Component>) : Box(children) {
    override fun createShape(): Shape {
        return Ellipse2D.Double(0.0, 0.0, size.targetSize.width, size.targetSize.height)
    }
}