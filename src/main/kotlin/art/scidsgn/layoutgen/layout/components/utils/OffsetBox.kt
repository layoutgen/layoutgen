package art.scidsgn.layoutgen.layout.components.utils

import art.scidsgn.layoutgen.layout.LayoutUtils
import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.layout.components.ContainerComponent
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.Size
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

class OffsetBox(val offset: Position, children: List<Component>) : Box(children) {
    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = offset }
    }
}