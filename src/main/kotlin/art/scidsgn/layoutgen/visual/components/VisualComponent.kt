package art.scidsgn.layoutgen.visual.components

import art.scidsgn.layoutgen.visual.fill.Fill
import art.scidsgn.layoutgen.visual.fill.RGBColor
import art.scidsgn.layoutgen.visual.stroke.Stroke
import java.awt.Graphics2D

abstract class VisualComponent {
    var fill: Fill = RGBColor(0.0, 0.0, 0.0, 0.0)
    var stroke: Stroke? = null

    abstract fun render(gfx: Graphics2D)
}

fun <T : VisualComponent> T.withFill(fill: Fill): T {
    this.fill = fill
    return this
}

fun <T : VisualComponent> T.withStroke(stroke: Stroke): T {
    this.stroke = stroke
    return this
}