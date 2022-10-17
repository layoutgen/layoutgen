package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.layout.components.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.components.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

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
                    // TODO: should this stretch to requested size or max child defined size??
                    if (horizontalStretch) LayoutUtils.getMaxDefinedWidthOrNull(childComponents) else null,
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