package art.scidsgn.layoutgen.components.layout.tiling

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.layout.GappedComponent
import art.scidsgn.layoutgen.components.layout.alignment.HorizontalAlignment
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.LayoutUtils

class VTiling(children: List<Component> = emptyList()) : GappedComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    var alignment = HorizontalAlignment.LEFT

    init {
        LayoutUtils.setChildrenParent(this)
    }

    fun withHorizontalAlignment(alignment: HorizontalAlignment): VTiling {
        this.alignment = alignment
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        val width: Double? = size.definedSize.width ?: parentRequestedSize.width
        val height: Double? = size.definedSize.height ?: parentRequestedSize.height

        size.requestedSize = UnclearDimensions(width, height)

        var childHeight: Double? = null

        if (height != null) {
            val nonDefinedHeight =
                height - LayoutUtils.getCombinedDefinedHeight(childComponents) - getTotalGap()
            val nonDefinedItemCount =
                LayoutUtils.getComponentsWithoutDefinedHeight(childComponents).size

            childHeight = nonDefinedHeight / nonDefinedItemCount
        }

        childComponents.forEach { it.propagateRequestedSize(UnclearDimensions(width, childHeight)) }
    }

    override fun calculateTargetSize() {
        LayoutUtils.setTargetSizeForExpansiveComponent(
            this,
            Dimensions(
                LayoutUtils.getMaxWidth(childComponents),
                LayoutUtils.getFittingHeight(childComponents) + getTotalGap()
            )
        )
    }

    override fun determineChildrenPositions() {
        val nonDefinedHeight = size.targetSize.height - LayoutUtils.getCombinedDefinedHeight(
            childComponents
        ) - getTotalGap()
        val nonDefinedItemCount =
            LayoutUtils.getComponentsWithoutDefinedHeight(childComponents).size
        var yOffset = 0.0

        childComponents.forEach {
            it.position = Position(
                LayoutUtils.calculateAlignmentOffset(
                    size.targetSize.width,
                    it.size.targetSize.width,
                    alignment
                ),
                yOffset
            )

            yOffset += it.size.definedSize.height ?: (nonDefinedHeight / nonDefinedItemCount)
            yOffset += gap
        }
    }
}