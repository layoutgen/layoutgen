package art.scidsgn.layoutgen.components.layout.flexbox

import art.scidsgn.layoutgen.components.layout.flexbox.enums.FlexContentJustification
import art.scidsgn.layoutgen.components.layout.flexbox.enums.FlexItemAlignment
import kotlin.math.max
import kotlin.math.min

class FlexLine(
    private val mainSize: Double,
    private val gap: Double,
    private val justifyContent: FlexContentJustification,
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
        return items.maxOfOrNull { it.crossSize } ?: 0.0
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
            FlexContentJustification.FLEX_START,
            FlexContentJustification.SPACE_BETWEEN -> 0.0

            FlexContentJustification.CENTER -> (mainSize - totalMainSize) / 2
            FlexContentJustification.FLEX_END -> mainSize - totalMainSize

            FlexContentJustification.SPACE_AROUND -> min(
                (mainSize - totalGaplessMainSize) / (items.size * 2),
                (mainSize - totalMainSize) / 2
            )
        }

        items.forEach {
            val itemCrossOffset = when (alignItems) {
                FlexItemAlignment.FLEX_START,
                FlexItemAlignment.STRETCH -> 0.0

                FlexItemAlignment.CENTER -> (crossSize - it.crossSize) / 2
                FlexItemAlignment.FLEX_END -> crossSize - it.crossSize
            }

            block(it, mainOffset, itemCrossOffset)

            mainOffset += it.mainSize

            mainOffset += when (justifyContent) {
                FlexContentJustification.FLEX_START,
                FlexContentJustification.CENTER,
                FlexContentJustification.FLEX_END -> gap

                FlexContentJustification.SPACE_BETWEEN -> max(
                    gap,
                    (mainSize - totalGaplessMainSize) / (items.size - 1)
                )

                FlexContentJustification.SPACE_AROUND -> max(
                    gap,
                    (mainSize - totalGaplessMainSize) / items.size
                )
            }
        }
    }

    private fun totalFlexGrow(): Double {
        return items.sumOf { it.component.flexGrow }
    }

    fun commitLine() {
        val totalFlexGrow = totalFlexGrow()
        val spaceAvailable = mainSize - getTotalMainSize()

        if (totalFlexGrow == 0.0) {
            return
        }

        items.forEach {
            it.mainSize += (it.component.flexGrow / totalFlexGrow) * spaceAvailable
        }
    }

    fun commitCrossSize() {
        val crossSize = getCrossSize()

        items.forEach {
            if (alignItems == FlexItemAlignment.STRETCH) {
                it.crossSize = crossSize
            }
        }
    }
}