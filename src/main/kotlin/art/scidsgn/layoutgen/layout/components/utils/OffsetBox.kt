package art.scidsgn.layoutgen.layout.components.utils

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size

class OffsetBox(val offset: Position, child: Component? = null) : ContainerComponent() {
    override var parent: Component? = null
    override val childComponents: List<Component>

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    init {
        if (child == null) {
            childComponents = emptyList()
        } else {
            childComponents = listOf(child)

            child.parent = this
        }
    }

    override fun propagateRequestedSize(parentRequestedSize: Dimensions?) {
        size.requestedSize = parentRequestedSize

        childComponents.forEach { it.propagateRequestedSize(size.requestedSize) }
    }

    override fun calculateTargetSize() {
        if (size.definedSize != null) {
            size.targetSize = size.definedSize!!
        } else {
            size.targetSize = size.requestedSize ?: Dimensions(0.0, 0.0)
        }
    }

    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = offset }
    }
}