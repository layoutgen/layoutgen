package art.scidsgn.layoutgen.components.layout.stack

import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.layout.GappedContainerComponent
import art.scidsgn.layoutgen.components.layout.alignment.HorizontalAlignment
import art.scidsgn.layoutgen.components.layout.alignment.VerticalAlignment
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions

class VStack(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var horizontalAlignment = HorizontalAlignment.LEFT
    private var verticalAlignment = VerticalAlignment.TOP
    private var horizontalStretch = false

    init {
        LayoutUtils.setChildrenParent(this)
    }

    fun withVerticalAlignment(alignment: VerticalAlignment): VStack {
        this.verticalAlignment = alignment
        return this
    }

    fun withHorizontalAlignment(alignment: HorizontalAlignment): VStack {
        this.horizontalAlignment = alignment
        return this
    }

    fun withHorizontalStretch(stretch: Boolean): VStack {
        this.horizontalStretch = stretch
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
                    if (horizontalStretch) size.requestedSize.width else null,
                    null
                )
            )
        }
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
        val totalHeight = LayoutUtils.getFittingHeight(childComponents) + getTotalGap()
        var yOffset = when (verticalAlignment) {
            VerticalAlignment.TOP -> 0.0
            VerticalAlignment.CENTER -> (size.targetSize.height - totalHeight) / 2
            VerticalAlignment.BOTTOM -> size.targetSize.height - totalHeight
        }
        if (yOffset < 0) {
            yOffset = 0.0
        }

        childComponents.forEach {
            it.position = Position(
                LayoutUtils.calculateAlignmentOffset(
                    size.targetSize.width,
                    it.size.targetSize.width,
                    horizontalAlignment
                ),
                yOffset
            )

            yOffset += it.size.targetSize.height + gap
        }
    }
}