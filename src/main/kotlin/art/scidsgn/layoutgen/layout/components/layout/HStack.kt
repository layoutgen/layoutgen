package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.utils.LayoutUtils

class HStack(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var horizontalAlignment = HorizontalAlignment.LEFT
    private var verticalAlignment = VerticalAlignment.TOP

    init {
        LayoutUtils.setChildrenParent(this)
    }

    fun withVerticalAlignment(alignment: VerticalAlignment): HStack {
        this.verticalAlignment = alignment
        return this
    }

    fun withHorizontalAlignment(alignment: HorizontalAlignment): HStack {
        this.horizontalAlignment = alignment
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: Dimensions?) {
        size.requestedSize = parentRequestedSize

        childComponents.forEach { it.propagateRequestedSize(null) }
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
        val totalWidth = LayoutUtils.getFittingWidth(childComponents) + getTotalGap()
        var xOffset = when (horizontalAlignment) {
            HorizontalAlignment.LEFT -> 0.0
            HorizontalAlignment.MIDDLE -> (size.targetSize.width - totalWidth) / 2
            HorizontalAlignment.RIGHT -> size.targetSize.width - totalWidth
        }
        if (xOffset < 0) {
            xOffset = 0.0
        }

        childComponents.forEach {
            it.position = Position(
                xOffset,
                LayoutUtils.calculateAlignmentOffset(
                    size.targetSize.height,
                    it.size.targetSize.height,
                    verticalAlignment
                )
            )

            xOffset += it.size.targetSize.width + gap
        }
    }
}