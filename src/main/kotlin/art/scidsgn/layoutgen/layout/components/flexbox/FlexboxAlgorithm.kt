package art.scidsgn.layoutgen.layout.components.flexbox

import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.flexbox.enums.FlexItemAlignment
import kotlin.math.max
import kotlin.math.min

class FlexboxAlgorithm(
    val items: List<FlexItem>,
    var mainSize: Double,
    var crossSize: Double,
    val gap: Double,
    val flexWrap: Boolean,
    val justifyContent: FlexContentAlignment,
    val alignContent: FlexContentAlignment,
    var alignItems: FlexItemAlignment
) {
    var lines = mutableListOf(makeLine())

    private fun makeLine(): FlexLine {
        return FlexLine(mainSize, gap, justifyContent, alignItems)
    }

    fun distributeFlexLines() {
        lines = mutableListOf(makeLine())
        items.forEach {
            if (!lines.last().willFit(it) && flexWrap) {
                lines.last().commitLine()
                lines += makeLine()
            }
            lines.last().items += it
        }
        lines.last().commitLine()
    }

    fun getTotalCrossSize(): Double {
        return lines.sumOf { it.getCrossSize() } + max(0, lines.size - 1) * gap
    }

    private fun getTotalGaplessCrossSize(): Double {
        return lines.sumOf { it.getCrossSize() }
    }

    fun layOutLines(block: (line: FlexLine, crossOffset: Double) -> Unit) {
        val totalCrossSize = getTotalCrossSize()
        val totalGaplessCrossSize = getTotalGaplessCrossSize()

        var crossOffset = when (alignContent) {
            FlexContentAlignment.FLEX_START,
            FlexContentAlignment.SPACE_BETWEEN -> 0.0

            FlexContentAlignment.CENTER -> (crossSize - totalCrossSize) / 2
            FlexContentAlignment.FLEX_END -> crossSize - totalCrossSize

            FlexContentAlignment.SPACE_AROUND -> min(
                (crossSize - totalGaplessCrossSize) / (lines.size * 2),
                (crossSize - totalCrossSize) / 2
            )
        }

        lines.forEach {
            block(it, crossOffset)

            crossOffset += it.getCrossSize()
            crossOffset += when (alignContent) {
                FlexContentAlignment.FLEX_START,
                FlexContentAlignment.CENTER,
                FlexContentAlignment.FLEX_END -> gap

                FlexContentAlignment.SPACE_BETWEEN -> max(gap, (crossSize - totalGaplessCrossSize) / (lines.size - 1))
                FlexContentAlignment.SPACE_AROUND -> max(gap, (crossSize - totalGaplessCrossSize) / lines.size)

            }
        }
    }

    fun getMinimumMainSize(): Double {
        return lines.maxOf { it.getTotalMainSize() }
    }
}