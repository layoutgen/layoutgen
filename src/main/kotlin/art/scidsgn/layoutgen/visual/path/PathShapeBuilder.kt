package art.scidsgn.layoutgen.visual.path

import java.awt.geom.Path2D

object PathShapeBuilder {
    fun build(instructions: List<PathInstruction>): Path2D {
        val path = Path2D.Double()
        instructions.forEach { it.perform(path) }

        return path
    }
}