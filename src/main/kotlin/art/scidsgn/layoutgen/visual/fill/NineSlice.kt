package art.scidsgn.layoutgen.visual.fill

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Margins
import java.awt.Paint
import java.awt.TexturePaint
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import kotlin.math.max

class NineSlice(val image: BufferedImage, val margins: Margins) : Fill() {
    override fun toAwtPaint(target: Component): Paint {
        val imageWidth = image.width
        val imageHeight = image.height

        val textureWidth = max(target.size.targetSize.width.toInt(), margins.horizontal.toInt())
        val textureHeight = max(target.size.targetSize.height.toInt(), margins.vertical.toInt())

        val textureImage = BufferedImage(textureWidth + 1, textureHeight + 1, BufferedImage.TYPE_INT_ARGB)
        val textureGfx = textureImage.createGraphics()

        // Top-left corner
        textureGfx.drawImage(
            image,
            0, 0, margins.left.toInt(), margins.top.toInt(),
            0, 0, margins.left.toInt(), margins.top.toInt(),
            null
        )

        // Top edge
        textureGfx.drawImage(
            image,
            margins.left.toInt(), 0, textureWidth - margins.right.toInt(), margins.top.toInt(),
            margins.left.toInt(), 0, imageWidth - margins.right.toInt(), margins.top.toInt(),
            null
        )

        // Top-right corner
        textureGfx.drawImage(
            image,
            textureWidth - margins.right.toInt(), 0, textureWidth, margins.top.toInt(),
            imageWidth - margins.right.toInt(), 0, imageWidth, margins.top.toInt(),
            null
        )

        // Left edge
        textureGfx.drawImage(
            image,
            0, margins.top.toInt(), margins.left.toInt(), textureHeight - margins.bottom.toInt(),
            0, margins.top.toInt(), margins.left.toInt(), imageHeight - margins.bottom.toInt(),
            null
        )

        // Middle
        textureGfx.drawImage(
            image,
            margins.left.toInt(),
            margins.top.toInt(),
            textureWidth - margins.right.toInt(),
            textureHeight - margins.bottom.toInt(),
            margins.left.toInt(),
            margins.top.toInt(),
            imageWidth - margins.right.toInt(),
            imageHeight - margins.bottom.toInt(),
            null
        )

        // Right edge
        textureGfx.drawImage(
            image,
            textureWidth - margins.right.toInt(),
            margins.top.toInt(),
            textureWidth,
            textureHeight - margins.bottom.toInt(),
            imageWidth - margins.right.toInt(),
            margins.top.toInt(),
            imageWidth,
            imageHeight - margins.bottom.toInt(),
            null
        )

        // Bottom-left corner
        textureGfx.drawImage(
            image,
            0, textureHeight - margins.bottom.toInt(), margins.left.toInt(), textureHeight,
            0, imageHeight - margins.bottom.toInt(), margins.left.toInt(), imageHeight,
            null
        )

        // Bottom edge
        textureGfx.drawImage(
            image,
            margins.left.toInt(),
            textureHeight - margins.bottom.toInt(),
            textureWidth - margins.right.toInt(),
            textureHeight,
            margins.left.toInt(),
            imageHeight - margins.bottom.toInt(),
            imageWidth - margins.right.toInt(),
            imageHeight,
            null
        )

        // Bottom-right corner
        textureGfx.drawImage(
            image,
            textureWidth - margins.right.toInt(), textureHeight - margins.bottom.toInt(), textureWidth, textureHeight,
            imageWidth - margins.right.toInt(), imageHeight - margins.bottom.toInt(), imageWidth, imageHeight,
            null
        )

        val anchorRect = Rectangle2D.Double(0.0, 0.0, textureWidth + 1.0, textureHeight + 1.0)

        return TexturePaint(textureImage, anchorRect)
    }
}