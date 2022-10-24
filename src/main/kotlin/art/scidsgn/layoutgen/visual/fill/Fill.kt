package art.scidsgn.layoutgen.visual.fill

import art.scidsgn.layoutgen.layout.components.Component
import java.awt.Paint

abstract class Fill {
    abstract fun toAwtPaint(target: Component): Paint
}