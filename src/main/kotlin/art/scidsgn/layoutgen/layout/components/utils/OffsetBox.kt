package art.scidsgn.layoutgen.layout.components.utils

import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.layout.components.ContainerComponent
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

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

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = parentRequestedSize

        childComponents.forEach { it.propagateRequestedSize(size.requestedSize) }
    }

    override fun calculateTargetSize() {
        size.targetSize = Dimensions(
            size.definedSize.width ?: size.requestedSize.width ?: 0.0,
            size.definedSize.height ?: size.requestedSize.height ?: 0.0
        )
    }

    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = offset }
    }
}