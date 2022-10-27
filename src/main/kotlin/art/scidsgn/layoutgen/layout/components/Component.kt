package art.scidsgn.layoutgen.layout.components

import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions
import art.scidsgn.layoutgen.visual.components.VisualComponent
import java.awt.Graphics2D
import java.awt.Shape
import java.awt.geom.Rectangle2D

abstract class Component : VisualComponent() {
    abstract var parent: Component?

    abstract val size: Size
    abstract var position: Position

    var flexGrow = 0.0

    abstract fun propagateRequestedSize(parentRequestedSize: UnclearDimensions)
    abstract fun calculateTargetSize()

    fun nextSibling(): Component? {
        if (parent == null || parent !is ContainerComponent) {
            return null
        }

        val childComponents = (parent as ContainerComponent).childComponents
        val index = childComponents.indexOf(this)
        if (index == childComponents.size - 1) {
            return null
        }

        return childComponents[index + 1]
    }

    fun isLast(): Boolean {
        return nextSibling() == null
    }

    open fun isLaidOut(): Boolean {
        return size.hasTargetSize()
    }

    fun hasDefinedWidth(): Boolean {
        return size.definedSize.hasWidth()
    }

    fun hasDefinedHeight(): Boolean {
        return size.definedSize.hasHeight()
    }

    open fun createShape(): Shape {
        return Rectangle2D.Double(0.0, 0.0, size.targetSize.width, size.targetSize.height)
    }

    override fun render(gfx: Graphics2D) {
        if (size.targetSize.width.toInt() == 0 || size.targetSize.height.toInt() == 0) {
            return
        }

        gfx.translate(position.x, position.y)

        val shape = createShape()

        gfx.paint = fill.toAwtPaint(this)
        gfx.fill(shape)

        if (stroke != null) {
            gfx.stroke = stroke!!.toAwtStroke()
            gfx.paint = stroke!!.fill.toAwtPaint(this)
            gfx.draw(shape)
        }

        gfx.translate(-position.x, -position.y)
    }
}

fun <T : Component> T.withSize(width: Double, height: Double): T {
    size.definedSize = UnclearDimensions(width, height)
    return this
}

fun <T : Component> T.withWidth(width: Double): T {
    size.definedSize.width = width
    return this
}

fun <T : Component> T.withHeight(height: Double): T {
    size.definedSize.height = height
    return this
}

fun <T : Component> T.withFlexGrow(flexGrow: Double): T {
    this.flexGrow = flexGrow
    return this
}