package art.scidsgn.layoutgen.components

import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.LayoutUtils

open class Box(children: List<Component> = emptyList()) : ContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    init {
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
        LayoutUtils.setTargetSizeForExpansiveComponent(
            this,
            Dimensions(
                LayoutUtils.getMaxWidth(childComponents),
                LayoutUtils.getMaxHeight(childComponents)
            )
        )
    }

    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = Position(0.0, 0.0) }
    }
}