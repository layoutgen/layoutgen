package art.scidsgn.layoutgen.visual.components.shapes.path

import art.scidsgn.layoutgen.visual.types.Point
import java.awt.geom.Path2D

class PathQuadraticInstruction(val through: Point, val to: Point) : PathInstruction {
    override fun perform(path: Path2D.Double) {
        path.quadTo(through.x, through.y, to.x, to.y)
    }
}