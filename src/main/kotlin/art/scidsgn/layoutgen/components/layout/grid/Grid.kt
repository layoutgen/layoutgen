package art.scidsgn.layoutgen.components.layout.grid

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.layout.GappedComponent
import art.scidsgn.layoutgen.components.layout.alignment.HorizontalAlignment
import art.scidsgn.layoutgen.components.layout.alignment.VerticalAlignment
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.Size
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.LayoutUtils
import kotlin.math.floor

class Grid(val rows: Int, val cols: Int, children: List<Component> = emptyList()) :
    GappedComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var cellHorizontalAlignment = HorizontalAlignment.LEFT
    private var cellVerticalAlignment = VerticalAlignment.TOP

    init {
        require(rows > 0) { "Grid must have at least one row" }
        require(cols > 0) { "Grid must have at least one column" }
        require(childComponents.size <= rows * cols) { "Cannot have more children components than grid cells" }

        LayoutUtils.setChildrenParent(this)
    }

    fun withCellVerticalAlignment(alignment: VerticalAlignment): Grid {
        this.cellVerticalAlignment = alignment
        return this
    }

    fun withCellHorizontalAlignment(alignment: HorizontalAlignment): Grid {
        this.cellHorizontalAlignment = alignment
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        var width: Double? = size.definedSize.width ?: parentRequestedSize.width
        var height: Double? = size.definedSize.height ?: parentRequestedSize.height

        if (width == null && LayoutUtils.getComponentsWithoutDefinedWidth(childComponents).size < childComponents.size) {
            val definedWidth = LayoutUtils.getMaxDefinedWidthOrNull(childComponents)

            if (definedWidth != null) {
                width = definedWidth * cols + gap * (cols - 1)
            }
        }
        if (height == null && LayoutUtils.getComponentsWithoutDefinedHeight(childComponents).size < childComponents.size) {
            val definedHeight = LayoutUtils.getMaxDefinedHeightOrNull(childComponents)

            if (definedHeight != null) {
                height = definedHeight * rows + gap * (rows - 1)
            }
        }

        size.requestedSize = UnclearDimensions(width, height)

        var cellWidth: Double? = null
        var cellHeight: Double? = null

        if (width != null) {
            cellWidth = (width - (cols - 1) * gap) / cols
        }
        if (height != null) {
            cellHeight = (height - (rows - 1) * gap) / rows
        }

        childComponents.forEach {
            it.propagateRequestedSize(
                UnclearDimensions(
                    cellWidth,
                    cellHeight
                )
            )
        }
    }

    override fun calculateTargetSize() {
        val fallbackWidth = LayoutUtils.getMaxWidth(childComponents) * cols + gap * (cols - 1)
        val fallbackHeight = LayoutUtils.getMaxHeight(childComponents) * rows + gap * (rows - 1)

        size.targetSize = Dimensions(
            size.requestedSize.width ?: fallbackWidth,
            size.requestedSize.height ?: fallbackHeight
        )
    }

    override fun determineChildrenPositions() {
        val columnWidth = (size.targetSize.width - gap * (cols - 1)) / cols
        val rowHeight = (size.targetSize.height - gap * (rows - 1)) / rows

        for (i in childComponents.indices) {
            val child = childComponents[i]
            val col = i % cols
            val row = floor((i / cols).toDouble()).toInt()

            val cellXOffset = when (cellHorizontalAlignment) {
                HorizontalAlignment.LEFT -> 0.0
                HorizontalAlignment.MIDDLE -> (columnWidth - child.size.targetSize.width) / 2
                HorizontalAlignment.RIGHT -> columnWidth - child.size.targetSize.width
            }
            val cellYOffset = when (cellVerticalAlignment) {
                VerticalAlignment.TOP -> 0.0
                VerticalAlignment.CENTER -> (rowHeight - child.size.targetSize.height) / 2
                VerticalAlignment.BOTTOM -> rowHeight - child.size.targetSize.height
            }

            child.position = Position(
                col * columnWidth + col * gap + cellXOffset,
                row * rowHeight + row * gap + cellYOffset
            )
        }
    }
}