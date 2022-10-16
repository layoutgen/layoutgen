package art.scidsgn.layoutgen.debug.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import kotlin.random.Random

object LayoutDebugGenerator {
    private fun drawComponent(gfx: Graphics2D, component: Component, x: Int, y: Int, random: Random) {
        gfx.paint = Color(random.nextInt())

        val componentX = x + component.position.x.toInt()
        val componentY = y + component.position.y.toInt()

        gfx.fillRect(
            componentX, componentY,
            component.size.targetSize.width.toInt(),
            component.size.targetSize.height.toInt()
        )

        gfx.paint = Color.BLACK
        gfx.drawString(
            component.javaClass.simpleName,
            componentX + 4, componentY + 16
        )

        if (component is ContainerComponent) {
            component.childComponents.forEach {
                drawComponent(gfx, it, componentX, componentY, random)
            }
        }
    }

    fun createImage(component: Component, random: Random = Random): BufferedImage {
        val image = BufferedImage(
            component.size.targetSize.width.toInt(),
            component.size.targetSize.height.toInt(),
            BufferedImage.TYPE_INT_RGB
        )

        drawComponent(image.createGraphics(), component, 0, 0, random)

        return image
    }
}