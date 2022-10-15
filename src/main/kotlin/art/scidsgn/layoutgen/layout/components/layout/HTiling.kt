package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.utils.LayoutUtils

class HTiling(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var alignment = VerticalAlignment.TOP

    init {
        LayoutUtils.setChildrenParent(this)
    }

    fun withVerticalAlignment(alignment: VerticalAlignment): HTiling {
        this.alignment = alignment
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: Dimensions?) {
        size.requestedSize = parentRequestedSize

        if (parentRequestedSize == null) {
            childComponents.forEach { it.propagateRequestedSize(null) }
        } else {
            val nonDefinedWidth = parentRequestedSize.width - LayoutUtils.getCombinedDefinedWidth(
                childComponents
            ) - getTotalGap()
            val nonDefinedItemCount = LayoutUtils.getComponentsWithoutDefinedSize(childComponents).size

            childComponents.forEach {
                if (it.hasDefinedSize()) {
                    it.propagateRequestedSize(it.size.definedSize)
                } else {
                    it.propagateRequestedSize(
                        Dimensions(nonDefinedWidth / nonDefinedItemCount, parentRequestedSize.height)
                    )
                }
            }
        }
    }

    override fun calculateTargetSize() {
        LayoutUtils.setTargetSizeForExpansiveComponent(this, horizontalGap = gap)
    }

    override fun determineChildrenPositions() {
        val nonDefinedWidth = size.targetSize.width - LayoutUtils.getCombinedDefinedWidth(
            childComponents
        ) - getTotalGap()
        val nonDefinedItemCount = LayoutUtils.getComponentsWithoutDefinedSize(childComponents).size
        var xOffset = 0.0

        childComponents.forEach {
            it.position = Position(
                xOffset,
                LayoutUtils.calculateAlignmentOffset(size.targetSize.height, it.size.targetSize.height, alignment)
            )

            if (it.hasDefinedSize()) {
                xOffset += it.size.definedSize!!.width
            } else {
                xOffset += nonDefinedWidth / nonDefinedItemCount
            }
            xOffset += gap
        }
    }
}