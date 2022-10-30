package art.scidsgn.layoutgen.layout.components.flexbox

import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.layout.components.GappedContainerComponent
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexDirection
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexItemAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

class Flexbox(children: List<Component> = emptyList()) : GappedContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    lateinit var algorithm: FlexboxAlgorithm

    private var flexDirection = FlexDirection.ROW
    private var flexWrap = false
    private var flexJustifyContent = FlexContentAlignment.FLEX_START
    private var flexAlignContent = FlexContentAlignment.FLEX_START
    private var flexAlignItems = FlexItemAlignment.FLEX_START

    init {
        LayoutUtils.setChildrenParent(this)
    }

    fun withGap(gap: Double): Flexbox {
        this.gap = gap
        return this
    }

    fun withFlexDirection(flexDirection: FlexDirection): Flexbox {
        this.flexDirection = flexDirection
        return this
    }

    fun withFlexWrap(flexWrap: Boolean): Flexbox {
        this.flexWrap = flexWrap
        return this
    }

    fun withJustifyContent(flexJustifyContent: FlexContentAlignment): Flexbox {
        this.flexJustifyContent = flexJustifyContent
        return this
    }

    fun withAlignContent(flexAlignContent: FlexContentAlignment): Flexbox {
        this.flexAlignContent = flexAlignContent
        return this
    }

    fun withAlignItems(flexAlignItems: FlexItemAlignment): Flexbox {
        this.flexAlignItems = flexAlignItems
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = UnclearDimensions(
            size.definedSize.width ?: parentRequestedSize.width,
            size.definedSize.height ?: parentRequestedSize.height
        )

        childComponents.forEach { it.propagateRequestedSize(UnclearDimensions(null, null)) }
    }

    override fun calculateTargetSize() {
        val flexContainerWidth = size.requestedSize.width ?: Double.MAX_VALUE
        val flexContainerHeight = size.requestedSize.height ?: Double.MAX_VALUE

        if (flexDirection == FlexDirection.ROW) {
            algorithm = FlexboxAlgorithm(
                childComponents.map { RowFlexItem(it) },
                flexContainerWidth, flexContainerHeight, gap,
                flexWrap, flexJustifyContent, flexAlignContent, flexAlignItems
            )
        } else {
            algorithm = FlexboxAlgorithm(
                childComponents.map { ColumnFlexItem(it) },
                flexContainerHeight, flexContainerWidth, gap,
                flexWrap, flexJustifyContent, flexAlignContent, flexAlignItems
            )
        }

        // TODO: flexGrow shouldn't affect defined sizes!!
        algorithm.distributeFlexLines()

        LayoutUtils.setTargetSizeForExpansiveComponent(
            this,
            if (flexDirection == FlexDirection.ROW)
                Dimensions(algorithm.getMinimumMainSize(), algorithm.getTotalCrossSize())
            else
                Dimensions(algorithm.getTotalCrossSize(), algorithm.getMinimumMainSize())
        )

        if (algorithm.mainSize == Double.MAX_VALUE || algorithm.crossSize == Double.MAX_VALUE) {
            if (flexDirection == FlexDirection.ROW) {
                algorithm.mainSize = size.targetSize.width
                algorithm.crossSize = size.targetSize.height
            } else {
                algorithm.mainSize = size.targetSize.height
                algorithm.crossSize = size.targetSize.width
            }
            algorithm.distributeFlexLines()
        }

        algorithm.items.forEach {
            val flexWidth = if (flexDirection == FlexDirection.ROW) it.mainSize else it.crossSize
            val flexHeight = if (flexDirection == FlexDirection.ROW) it.crossSize else it.mainSize

            if (
                flexWidth != it.component.size.targetSize.width ||
                flexHeight != it.component.size.targetSize.height
            ) {
                LayoutEngine.layOut(it.component, Dimensions(flexWidth, flexHeight))
            }
        }
    }

    override fun determineChildrenPositions() {
        algorithm.layOutLines { line, lineCrossOffset ->
            line.layOutItems { item, mainOffset, crossOffset ->
                if (flexDirection == FlexDirection.ROW) {
                    item.component.position = Position(mainOffset, crossOffset + lineCrossOffset)
                } else {
                    item.component.position = Position(crossOffset + lineCrossOffset, mainOffset)
                }
            }
        }
    }
}