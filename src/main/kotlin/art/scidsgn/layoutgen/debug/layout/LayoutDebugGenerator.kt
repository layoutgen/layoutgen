package art.scidsgn.layoutgen.debug.layout

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.ContainerComponent
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import kotlin.math.round
import kotlin.random.Random

object LayoutDebugGenerator {
    private fun drawComponent(
        gfx: Graphics2D,
        component: Component,
        x: Double,
        y: Double,
        random: Random
    ) {
        val componentX = round(x + component.position.x).toInt()
        val componentY = round(y + component.position.y).toInt()
        val componentWidth = round(component.size.targetSize.width).toInt()
        val componentHeight = round(component.size.targetSize.height).toInt()

        gfx.paint = Color.BLACK
        gfx.fillRect(componentX, componentY, componentWidth, componentHeight)

        gfx.paint = Color(
            210 + random.nextInt(-45, 45),
            210 + random.nextInt(-45, 45),
            210 + random.nextInt(-45, 45)
        )
        gfx.fillRect(componentX + 1, componentY + 1, componentWidth - 2, componentHeight - 2)

        gfx.paint = Color.BLACK
        gfx.drawString(
            component.javaClass.simpleName,
            componentX + 4, componentY + 16
        )

        if (component is ContainerComponent) {
            component.childComponents.forEach {
                drawComponent(gfx, it, x + component.position.x, y + component.position.y, random)
            }
        }
    }

    fun createImage(component: Component, random: Random = Random): BufferedImage {
        val image = BufferedImage(
            component.size.targetSize.width.toInt(),
            component.size.targetSize.height.toInt(),
            BufferedImage.TYPE_INT_RGB
        )

        drawComponent(image.createGraphics(), component, 0.0, 0.0, random)

        return image
    }
}