package art.scidsgn.layoutgen.components.image

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import java.awt.Graphics2D
import java.awt.Image

class ImageBox(val image: Image) : Box() {
    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        val imageWidth = image.getWidth(null).toDouble()
        val imageHeight = image.getHeight(null).toDouble()
        val aspectRatio = imageWidth / imageHeight

        if (!hasDefinedWidth() && !hasDefinedHeight()) {
            size.definedSize.width = imageWidth
            size.definedSize.height = imageHeight
        } else if (!hasDefinedWidth()) {
            size.definedSize.width = size.definedSize.height!! * aspectRatio
        } else if (!hasDefinedHeight()) {
            size.definedSize.height = size.definedSize.width!! / aspectRatio
        }

        super.propagateRequestedSize(parentRequestedSize)
    }

    override fun renderSelf(gfx: Graphics2D) {
        gfx.drawImage(
            image,
            0,
            0,
            size.targetSize.width.toInt(),
            size.targetSize.height.toInt(),
            null
        )
    }
}