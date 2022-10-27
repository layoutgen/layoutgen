package art.scidsgn.layoutgen.layout.components

import java.awt.Graphics2D

abstract class ContainerComponent : Component() {
    abstract val childComponents: List<Component>

    abstract fun determineChildrenPositions()

    fun hasChildren(): Boolean {
        return childComponents.isNotEmpty()
    }

    override fun isLaidOut(): Boolean {
        return super.isLaidOut() && childComponents.all { it.isLaidOut() }
    }

    override fun render(gfx: Graphics2D) {
        gfx.translate(position.x, position.y)

        val shape = createShape()

        gfx.paint = fill.toAwtPaint(this)
        gfx.fill(shape)

        if (stroke != null) {
            gfx.stroke = stroke!!.toAwtStroke()
            gfx.paint = stroke!!.fill.toAwtPaint(this)
            gfx.draw(shape)
        }

        for (component in childComponents) {
            component.render(gfx)
        }

        gfx.translate(-position.x, -position.y)
    }
}