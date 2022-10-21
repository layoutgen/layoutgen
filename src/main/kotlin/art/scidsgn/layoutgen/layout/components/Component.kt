package art.scidsgn.layoutgen.layout.components

import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

abstract class Component {
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