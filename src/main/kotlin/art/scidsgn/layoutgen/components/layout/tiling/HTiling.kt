package art.scidsgn.layoutgen.components.layout.tiling

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.layout.GappedComponent
import art.scidsgn.layoutgen.components.layout.alignment.VerticalAlignment
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.LayoutUtils

class HTiling(children: List<Component> = emptyList()) : GappedComponent() {
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

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        val width: Double? = size.definedSize.width ?: parentRequestedSize.width
        val height: Double? = size.definedSize.height ?: parentRequestedSize.height

        size.requestedSize = UnclearDimensions(width, height)

        var childWidth: Double? = null

        if (width != null) {
            val nonDefinedWidth =
                width - LayoutUtils.getCombinedDefinedWidth(childComponents) - getTotalGap()
            val nonDefinedItemCount =
                LayoutUtils.getComponentsWithoutDefinedWidth(childComponents).size

            childWidth = nonDefinedWidth / nonDefinedItemCount
        }

        childComponents.forEach { it.propagateRequestedSize(UnclearDimensions(childWidth, height)) }
    }

    override fun calculateTargetSize() {
        LayoutUtils.setTargetSizeForExpansiveComponent(
            this,
            Dimensions(
                LayoutUtils.getFittingWidth(childComponents) + getTotalGap(),
                LayoutUtils.getMaxHeight(childComponents)
            )
        )
    }

    override fun determineChildrenPositions() {
        val nonDefinedWidth = size.targetSize.width - LayoutUtils.getCombinedDefinedWidth(
            childComponents
        ) - getTotalGap()
        val nonDefinedItemCount = LayoutUtils.getComponentsWithoutDefinedWidth(childComponents).size
        var xOffset = 0.0

        childComponents.forEach {
            it.position = Position(
                xOffset,
                LayoutUtils.calculateAlignmentOffset(
                    size.targetSize.height,
                    it.size.targetSize.height,
                    alignment
                )
            )

            xOffset += it.size.definedSize.width ?: (nonDefinedWidth / nonDefinedItemCount)
            xOffset += gap
        }
    }
}