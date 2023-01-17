package art.scidsgn.layoutgen.components.layout.utils

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.layout.LayoutUtils

class OffsetBox(val offset: Position, children: List<Component>) : Box(children) {
    override fun calculateTargetSize() {
        size.targetSize = Dimensions(
            LayoutUtils.getMaxWidth(childComponents),
            LayoutUtils.getMaxHeight(childComponents)
        )
    }

    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = offset }
    }
}