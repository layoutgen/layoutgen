package art.scidsgn.layoutgen.visual.components.text

import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions
import java.awt.Graphics2D

class TextBox(val text: String, val font: Font) : Component() {
    override var parent: Component? = null
    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    lateinit var algorithm: TextBoxAlgorithm

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = parentRequestedSize
    }

    override fun calculateTargetSize() {
        algorithm =
            TextBoxAlgorithm(text, size.definedSize.width ?: size.requestedSize.width ?: Double.POSITIVE_INFINITY, font)
        algorithm.layOut()

        size.targetSize = Dimensions(algorithm.targetWidth, algorithm.targetHeight)
    }

    override fun render(gfx: Graphics2D) {
        gfx.translate(position.x, position.y)

        gfx.paint = fill.toAwtPaint(this)

        var offsetY = 0.0f
        for (layout in algorithm.textLayouts) {
            offsetY += layout.ascent

            layout.draw(gfx, 0.0f, offsetY)

            offsetY += layout.descent + layout.leading
        }

        gfx.translate(-position.x, -position.y)
    }
}