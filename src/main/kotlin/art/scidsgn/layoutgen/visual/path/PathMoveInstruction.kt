package art.scidsgn.layoutgen.visual.path

import art.scidsgn.layoutgen.visual.types.Point
import java.awt.geom.Path2D

class PathMoveInstruction(val to: Point) : PathInstruction {
    override fun perform(path: Path2D.Double) {
        path.moveTo(to.x, to.y)
    }
}