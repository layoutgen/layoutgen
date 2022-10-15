package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.utils.LayoutUtils

class VStack(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var horizontalAlignment = HorizontalAlignment.LEFT
    private var verticalAlignment = VerticalAlignment.TOP

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

    override fun propagateRequestedSize(parentRequestedSize: Dimensions?) {
        if (hasDefinedSize()) {
            size.requestedSize = size.definedSize
        } else {
            size.requestedSize = parentRequestedSize
        }

        childComponents.forEach { it.propagateRequestedSize(null) }
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