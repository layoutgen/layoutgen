package art.scidsgn.layoutgen.visual.components.shapes.path

import art.scidsgn.layoutgen.layout.components.Box
import java.awt.Shape
import java.awt.geom.Path2D

class Path(val instructions: List<PathInstruction>) : Box() {
    override fun createShape(): Shape {
        val path = Path2D.Double()

        // TODO: should the coordinate system be dependent on the component
        // TODO: maybe introduce relative units?
        instructions.forEach { it.perform(path) }

        return path
    }
}