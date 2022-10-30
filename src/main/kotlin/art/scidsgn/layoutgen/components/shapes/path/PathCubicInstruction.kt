package art.scidsgn.layoutgen.components.shapes.path

import art.scidsgn.layoutgen.visual.types.Point
import java.awt.geom.Path2D

class PathCubicInstruction(val through1: Point, val through2: Point, val to: Point) :
    PathInstruction {
    override fun perform(path: Path2D.Double) {
        path.curveTo(through1.x, through1.y, through2.x, through2.y, to.x, to.y)
    }
}