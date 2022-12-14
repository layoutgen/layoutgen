package art.scidsgn.layoutgen.components.layout.stack

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.layout.GappedComponent
import art.scidsgn.layoutgen.components.layout.alignment.HorizontalAlignment
import art.scidsgn.layoutgen.components.layout.alignment.VerticalAlignment
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.LayoutUtils
import kotlin.math.max

class OverlapHStack(children: List<Component> = emptyList()) : GappedComponent() {
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

    fun withVerticalAlignment(alignment: VerticalAlignment): OverlapHStack {
        this.verticalAlignment = alignment
        return this
    }

    fun withHorizontalAlignment(alignment: HorizontalAlignment): OverlapHStack {
        this.horizontalAlignment = alignment
        return this
    }

    fun withVerticalStretch(stretch: Boolean): OverlapHStack {
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
                    if (verticalStretch) size.requestedSize.height else null
                )
            )
        }
    }

    private fun getTargetWidth(): Double {
        var targetWidth = 0.0

        for (index in childComponents.indices) {
            targetWidth =
                max(targetWidth, childComponents[index].size.targetSize.width + index * gap)
        }

        return targetWidth
    }

    override fun calculateTargetSize() {
        LayoutUtils.setTargetSizeForExpansiveComponent(
            this,
            Dimensions(
                getTargetWidth(),
                LayoutUtils.getMaxHeight(childComponents)
            )
        )
    }

    override fun determineChildrenPositions() {
        val totalWidth = getTargetWidth()
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

            xOffset += gap
        }
    }
}