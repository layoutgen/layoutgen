package art.scidsgn.layoutgen.visual.fill

import art.scidsgn.layoutgen.components.Component
import java.awt.Paint
import java.awt.TexturePaint
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage

class Texture(val image: BufferedImage, val width: Double?, val height: Double?, val stretch: TextureStretch) : Fill() {
    override fun toAwtPaint(target: Component): Paint {
        var textureWidth = image.getWidth(null).toDouble()
        var textureHeight = image.getHeight(null).toDouble()
        val aspectRatio = textureWidth / textureHeight

        if (width != null && height != null) {
            textureWidth = width
            textureHeight = height
        } else if (height != null) {
            textureHeight = height
            textureWidth = textureHeight * aspectRatio
        } else if (width != null) {
            textureWidth = width
            textureHeight = textureWidth / aspectRatio
        }

        when (stretch) {
            TextureStretch.WIDTH -> textureWidth = target.size.targetSize.width
            TextureStretch.HEIGHT -> textureHeight = target.size.targetSize.height
            TextureStretch.BOTH -> {
                textureWidth = target.size.targetSize.width
                textureHeight = target.size.targetSize.height
            }

            else -> {}
        }

        val anchorRect = Rectangle2D.Double(0.0, 0.0, textureWidth, textureHeight)

        return TexturePaint(image, anchorRect)
    }
}