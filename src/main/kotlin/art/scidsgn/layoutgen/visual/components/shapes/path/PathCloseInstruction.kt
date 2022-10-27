package art.scidsgn.layoutgen.visual.components.shapes.path

import java.awt.geom.Path2D

class PathCloseInstruction : PathInstruction {
    override fun perform(path: Path2D.Double) {
        path.closePath()
    }
}