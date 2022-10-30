package art.scidsgn.layoutgen.visual.components

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions
import java.awt.Graphics2D
import java.awt.Image

class ImageBox(val image: Image) : Box() {
    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        val imageWidth = image.getWidth(null).toDouble()
        val imageHeight = image.getHeight(null).toDouble()
        if (!hasDefinedWidth() && !hasDefinedHeight()) {
            size.definedSize.width = imageWidth
            size.definedSize.height = imageHeight
        }
        // TODO: more...

        super.propagateRequestedSize(parentRequestedSize)
    }

    override fun render(gfx: Graphics2D) {
        gfx.translate(position.x, position.y)

        gfx.drawImage(
            image,
            0,
            0,
            size.targetSize.width.toInt(),
            size.targetSize.height.toInt(),
            null
        )

        gfx.translate(-position.x, -position.y)
    }
}