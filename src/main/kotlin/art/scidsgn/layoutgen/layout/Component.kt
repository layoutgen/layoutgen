package art.scidsgn.layoutgen.layout

import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size

abstract class Component {
    abstract var parent: Component?

    abstract val size: Size
    abstract var position: Position

    abstract fun propagateRequestedSize(parentRequestedSize: Dimensions?)
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

    fun hasDefinedSize(): Boolean {
        return size.definedSize != null
    }

    fun setDefinedSize(dimensions: Dimensions) {
        size.definedSize = dimensions
    }
}

fun <T : Component> T.withDefinedSize(dimensions: Dimensions): T {
    setDefinedSize(dimensions)
    return this
}