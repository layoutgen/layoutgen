package art.scidsgn.layoutgen.components.shapes

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.visual.path.PathInstruction
import art.scidsgn.layoutgen.visual.path.PathShapeBuilder
import java.awt.Shape
import java.awt.geom.AffineTransform

class Path(val instructions: List<PathInstruction>, val fillContainer: Boolean = false) : Box() {
    override fun createShape(): Shape {
        val path = PathShapeBuilder.build(instructions)

        if (fillContainer) {
            val bounds = path.bounds2D
            val xform = AffineTransform()
            xform.scale(
                size.targetSize.width / bounds.width,
                size.targetSize.height / bounds.height
            )
            xform.translate(-bounds.x, -bounds.y)

            return path.createTransformedShape(xform)
        } else {
            return path
        }
    }
}