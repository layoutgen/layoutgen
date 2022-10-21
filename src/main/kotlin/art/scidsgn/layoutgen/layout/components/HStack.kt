package art.scidsgn.layoutgen.layout.components

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.layout.components.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.components.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

class HStack(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var horizontalAlignment = HorizontalAlignment.LEFT
    private var verticalAlignment = VerticalAlignment.TOP
    private var verticalStretch = false

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

    fun withVerticalStretch(stretch: Boolean): HStack {
        this.verticalStretch = stretch
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = UnclearDimensions(
            size.definedSize.width ?: parentRequestedSize.width,
            size.definedSize.height ?: parentRequestedSize.height
        )

        childComponents.forEach {
            it.propagateRequestedSize(
                UnclearDimensions(
                    null,
                    if (verticalStretch) LayoutUtils.getMaxDefinedHeightOrNull(childComponents) else null
                )
            )
        }
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