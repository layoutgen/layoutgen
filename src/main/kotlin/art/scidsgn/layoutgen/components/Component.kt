package art.scidsgn.layoutgen.components

import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.visual.fill.Fill
import art.scidsgn.layoutgen.visual.fill.RGBColor
import art.scidsgn.layoutgen.visual.stroke.Stroke
import java.awt.Graphics2D
import java.awt.Shape
import java.awt.geom.Rectangle2D

abstract class Component {
    abstract val childComponents: List<Component>

    abstract var parent: Component?

    abstract val size: Size
    abstract var position: Position

    var fill: Fill = RGBColor(0.0, 0.0, 0.0, 0.0)
    var stroke: Stroke? = null

    var flexGrow = 0.0

    abstract fun propagateRequestedSize(parentRequestedSize: UnclearDimensions)
    abstract fun calculateTargetSize()
    abstract fun determineChildrenPositions()

    fun hasChildren(): Boolean {
        return childComponents.isNotEmpty()
    }

    fun nextSibling(): Component? {
        if (parent == null || parent !is Component) {
            return null
        }

        val childComponents = (parent as Component).childComponents
        val index = childComponents.indexOf(this)
        if (index == childComponents.size - 1) {
            return null
        }

        return childComponents[index + 1]
    }

    fun isLast(): Boolean {
        return nextSibling() == null
    }

    fun hasDefinedWidth(): Boolean {
        return size.definedSize.hasWidth()
    }

    fun hasDefinedHeight(): Boolean {
        return size.definedSize.hasHeight()
    }

    fun isLaidOut(): Boolean {
        return size.hasTargetSize() && childComponents.all { it.isLaidOut() }
    }

    open fun createShape(): Shape {
        return Rectangle2D.Double(0.0, 0.0, size.targetSize.width, size.targetSize.height)
    }

    open fun renderSelf(gfx: Graphics2D) {
        val shape = createShape()

        gfx.paint = fill.toAwtPaint(this)
        gfx.fill(shape)

        renderChildren(gfx)

        if (stroke != null) {
            gfx.stroke = stroke!!.toAwtStroke()
            gfx.paint = stroke!!.fill.toAwtPaint(this)
            gfx.draw(shape)
        }
    }

    fun renderChildren(gfx: Graphics2D) {
        for (component in childComponents) {
            component.render(gfx)
        }
    }

    fun render(gfx: Graphics2D) {
        gfx.translate(position.x, position.y)

        renderSelf(gfx)

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

fun <T : Component> T.withFill(fill: Fill): T {
    this.fill = fill
    return this
}

fun <T : Component> T.withStroke(stroke: Stroke): T {
    this.stroke = stroke
    return this
}