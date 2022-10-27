package art.scidsgn.layoutgen.visual.components.shapes.path

import art.scidsgn.layoutgen.visual.types.Point
import java.awt.geom.Path2D

class PathLineInstruction(val to: Point) : PathInstruction {
    override fun perform(path: Path2D.Double) {
        path.lineTo(to.x, to.y)
    }
}