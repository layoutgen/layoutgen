package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.utils.LayoutUtils

class VTiling(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var alignment = HorizontalAlignment.LEFT

    init {
        LayoutUtils.setChildrenParent(this)
    }

    fun withHorizontalAlignment(alignment: HorizontalAlignment): VTiling {
        this.alignment = alignment
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: Dimensions?) {
        size.requestedSize = parentRequestedSize

        if (parentRequestedSize == null) {
            childComponents.forEach { it.propagateRequestedSize(null) }
        } else {
            val nonDefinedHeight = parentRequestedSize.height - LayoutUtils.getCombinedDefinedHeight(
                childComponents
            ) - getTotalGap()
            val nonDefinedItemCount = LayoutUtils.getComponentsWithoutDefinedSize(childComponents).size

            childComponents.forEach {
                if (it.hasDefinedSize()) {
                    it.propagateRequestedSize(it.size.definedSize)
                } else {
                    it.propagateRequestedSize(
                        Dimensions(parentRequestedSize.width, nonDefinedHeight / nonDefinedItemCount)
                    )
                }
            }
        }
    }

    override fun calculateTargetSize() {
        LayoutUtils.setTargetSizeForExpansiveComponent(this)
    }

    override fun determineChildrenPositions() {
        val nonDefinedHeight = size.targetSize.height - LayoutUtils.getCombinedDefinedHeight(
            childComponents
        ) - getTotalGap()
        val nonDefinedItemCount = LayoutUtils.getComponentsWithoutDefinedSize(childComponents).size
        var yOffset = 0.0

        childComponents.forEach {
            it.position = Position(
                LayoutUtils.calculateAlignmentOffset(size.targetSize.width, it.size.targetSize.width, alignment),
                yOffset
            )

            if (it.hasDefinedSize()) {
                yOffset += it.size.definedSize!!.height
            } else {
                yOffset += nonDefinedHeight / nonDefinedItemCount
            }
            yOffset += gap
        }
    }
}