package art.scidsgn.layoutgen.components.shapes.path

import art.scidsgn.layoutgen.components.Box
import java.awt.Shape
import java.awt.geom.AffineTransform
import java.awt.geom.Path2D

class Path(val instructions: List<PathInstruction>, val fillContainer: Boolean = false) : Box() {
    override fun createShape(): Shape {
        val path = Path2D.Double()

        instructions.forEach { it.perform(path) }

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