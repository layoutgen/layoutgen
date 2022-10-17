package art.scidsgn.layoutgen.layout.components.layout.flexbox

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent
import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexDirection
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

class Flexbox(children: List<Component> = emptyList()) : ContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    lateinit var algorithm: FlexboxAlgorithm

    private var gap: Double = 0.0

    private var flexDirection = FlexDirection.ROW
    private var flexWrap = false
    private var flexJustifyContent = FlexContentAlignment.FLEX_START
    private var flexAlignContent = FlexContentAlignment.FLEX_START

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

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = UnclearDimensions(
            size.definedSize.width ?: parentRequestedSize.width,
            size.definedSize.height ?: parentRequestedSize.height
        )

        childComponents.forEach { it.propagateRequestedSize(UnclearDimensions(null, null)) }
    }

    override fun calculateTargetSize() {
        // TODO: you need to implement maxRequestedSize!
        val flexContainerWidth = size.requestedSize.width ?: Double.MAX_VALUE
        val flexContainerHeight = size.requestedSize.height ?: Double.MAX_VALUE

        if (flexDirection == FlexDirection.ROW) {
            algorithm = FlexboxAlgorithm(
                childComponents.map { RowFlexItem(it) },
                flexContainerWidth, flexContainerHeight, gap,
                flexWrap, flexJustifyContent, flexAlignContent
            )
        } else {
            algorithm = FlexboxAlgorithm(
                childComponents.map { ColumnFlexItem(it) },
                flexContainerHeight, flexContainerWidth, gap,
                flexWrap, flexJustifyContent, flexAlignContent
            )
        }

        algorithm.distributeFlexLines()

        // TODO: this doesn't account for the stuff inside!!
        LayoutUtils.setTargetSizeForExpansiveComponent(this)
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