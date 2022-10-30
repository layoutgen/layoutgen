package art.scidsgn.layoutgen.components.shapes.path

import java.awt.geom.Path2D

class PathCloseInstruction : PathInstruction {
    override fun perform(path: Path2D.Double) {
        path.closePath()
    }
}