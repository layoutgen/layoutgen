package art.scidsgn.layoutgen.layout.components

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent
import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

open class Box(child: Component? = null) : ContainerComponent() {
    override var parent: Component? = null
    final override val childComponents: List<Component>

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    init {
        if (child == null) {
            childComponents = emptyList()
        } else {
            childComponents = listOf(child)
        }

        LayoutUtils.setChildrenParent(this)
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = UnclearDimensions(
            size.definedSize.width ?: parentRequestedSize.width,
            size.definedSize.height ?: parentRequestedSize.height
        )

        childComponents.forEach { it.propagateRequestedSize(size.requestedSize) }
    }

    override fun calculateTargetSize() {
        LayoutUtils.setTargetSizeForExpansiveComponent(this)
    }

    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = Position(0.0, 0.0) }
    }
}