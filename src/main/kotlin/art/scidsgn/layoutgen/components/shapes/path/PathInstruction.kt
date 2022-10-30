package art.scidsgn.layoutgen.components.shapes.path

import java.awt.geom.Path2D

interface PathInstruction {
    fun perform(path: Path2D.Double)
}