package art.scidsgn.layoutgen.layout.components.layout.flexbox

import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.layout.components.layout.flexbox.enums.FlexItemAlignment
import kotlin.math.max
import kotlin.math.min

class FlexLine(
    private val mainSize: Double,
    private val gap: Double,
    private val justifyContent: FlexContentAlignment,
    private val alignItems: FlexItemAlignment
) {
    val items: MutableList<FlexItem> = mutableListOf()
    var enforcedCrossSize: Double? = null

    fun getTotalMainSize(): Double {
        return items.sumOf { it.mainSize } + max(0, items.size - 1) * gap
    }

    private fun getTotalGaplessMainSize(): Double {
        return items.sumOf { it.mainSize }
    }

    private fun getTotalMainSizeWithTrailingGap(): Double {
        return items.sumOf { it.mainSize } + items.size * gap
    }

    private fun getInitialCrossSize(): Double {
        return items.maxOf { it.crossSize }
    }

    fun getCrossSize(): Double {
        return enforcedCrossSize ?: getInitialCrossSize()
    }

    fun willFit(item: FlexItem): Boolean {
        if (items.size == 0) {
            return true
        }
        return mainSize >= (getTotalMainSizeWithTrailingGap() + item.mainSize)
    }

    fun layOutItems(block: (item: FlexItem, mainOffset: Double, crossOffset: Double) -> Unit) {
        val totalMainSize = getTotalMainSize()
        val totalGaplessMainSize = getTotalGaplessMainSize()

        val crossSize = getCrossSize()

        var mainOffset = when (justifyContent) {
            FlexContentAlignment.FLEX_START,
            FlexContentAlignment.SPACE_BETWEEN -> 0.0

            FlexContentAlignment.CENTER -> (mainSize - totalMainSize) / 2
            FlexContentAlignment.FLEX_END -> mainSize - totalMainSize

            FlexContentAlignment.SPACE_AROUND -> min(
                (mainSize - totalGaplessMainSize) / (items.size * 2),
                (mainSize - totalMainSize) / 2
            )
        }

        items.forEach {
            val itemCrossOffset = when (alignItems) {
                FlexItemAlignment.FLEX_START -> 0.0
                FlexItemAlignment.CENTER -> (crossSize - it.crossSize) / 2
                FlexItemAlignment.FLEX_END -> crossSize - it.crossSize
            }
            block(it, mainOffset, itemCrossOffset)

            mainOffset += it.mainSize

            mainOffset += when (justifyContent) {
                FlexContentAlignment.FLEX_START,
                FlexContentAlignment.CENTER,
                FlexContentAlignment.FLEX_END -> gap

                FlexContentAlignment.SPACE_BETWEEN -> max(gap, (mainSize - totalGaplessMainSize) / (items.size - 1))
                FlexContentAlignment.SPACE_AROUND -> max(gap, (mainSize - totalGaplessMainSize) / items.size)
            }
        }
    }
}