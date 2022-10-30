package art.scidsgn.layoutgen.visual

import art.scidsgn.layoutgen.components.Component
import java.awt.RenderingHints
import java.awt.image.BufferedImage

class VisualTreeRenderer(private val root: Component) {
    init {
        require(root.isLaidOut()) { "Root component needs to be laid out" }
    }

    fun render(): BufferedImage {
        val image = BufferedImage(
            root.size.targetSize.width.toInt(),
            root.size.targetSize.height.toInt(),
            BufferedImage.TYPE_INT_ARGB
        )

        val gfx = image.createGraphics()

        gfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        gfx.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        )

        root.render(gfx)

        return image
    }
}