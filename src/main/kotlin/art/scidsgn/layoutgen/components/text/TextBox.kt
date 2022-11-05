package art.scidsgn.layoutgen.components.text

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import java.awt.Graphics2D

class TextBox(val text: String, val font: Font, val alignment: TextAlignment) : Component() {
    override val childComponents: List<Component> = emptyList()

    override var parent: Component? = null
    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    lateinit var algorithm: TextBoxAlgorithm

    init {
        require(text.length > 0) { "Text must be non-empty" }
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = parentRequestedSize
    }

    override fun calculateTargetSize() {
        algorithm =
            TextBoxAlgorithm(
                text,
                size.definedSize.width ?: size.requestedSize.width ?: Double.POSITIVE_INFINITY,
                font
            )
        algorithm.layOut()

        size.targetSize = Dimensions(algorithm.targetWidth, algorithm.targetHeight)
    }

    override fun determineChildrenPositions() {}

    override fun renderSelf(gfx: Graphics2D) {
        gfx.paint = fill.toAwtPaint(this)

        var offsetY = 0.0f
        for (layout in algorithm.textLayouts) {
            offsetY += layout.ascent

            val offsetX = when (alignment) {
                TextAlignment.LEFT -> 0.0
                TextAlignment.CENTER -> (size.targetSize.width - layout.advance) / 2
                TextAlignment.RIGHT -> size.targetSize.width - layout.advance
            }

            layout.draw(gfx, offsetX.toFloat(), offsetY)

            offsetY += layout.descent + layout.leading
        }
    }
}