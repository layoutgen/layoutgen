package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.utils.LayoutUtils
import kotlin.math.floor

class Grid(val rows: Int, val cols: Int, children: List<Component> = emptyList()) : ContainerComponent() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    private var gap: Double = 0.0

    private var cellHorizontalAlignment = HorizontalAlignment.LEFT
    private var cellVerticalAlignment = VerticalAlignment.TOP

    init {
        require(rows > 0) { "Grid must have at least one row" }
        require(cols > 0) { "Grid must have at least one column" }
        require(childComponents.size <= rows * cols) { "Cannot have more children components than grid cells" }

        LayoutUtils.setChildrenParent(this)
    }

    fun withGap(gap: Double): Grid {
        this.gap = gap
        return this
    }

    fun withCellVerticalAlignment(alignment: VerticalAlignment): Grid {
        this.cellVerticalAlignment = alignment
        return this
    }

    fun withCellHorizontalAlignment(alignment: HorizontalAlignment): Grid {
        this.cellHorizontalAlignment = alignment
        return this
    }

    override fun propagateRequestedSize(parentRequestedSize: Dimensions?) {
        if (hasDefinedSize()) {
            size.requestedSize = size.definedSize
        } else {
            size.requestedSize = parentRequestedSize
        }

        if (size.requestedSize == null) {
            childComponents.forEach { it.propagateRequestedSize(null) }
        } else {
            val cellDimensions = Dimensions(
                (size.requestedSize!!.width - (cols - 1) * gap) / cols,
                (size.requestedSize!!.height - (rows - 1) * gap) / rows
            )

            childComponents.forEach { it.propagateRequestedSize(cellDimensions) }
        }
    }

    override fun calculateTargetSize() {
        if (size.requestedSize != null) {
            size.targetSize = size.requestedSize!!
        } else {
            val columnWidth = LayoutUtils.getMaxWidth(childComponents)
            val rowHeight = LayoutUtils.getMaxHeight(childComponents)

            size.targetSize = Dimensions(
                columnWidth * cols + gap * (cols - 1),
                rowHeight * rows + gap * (rows - 1)
            )
        }
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