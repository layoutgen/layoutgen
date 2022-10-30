package art.scidsgn.layoutgen.components.layout.utils

import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Position

class OffsetBox(val offset: Position, children: List<Component>) : Box(children) {
    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = offset }
    }
}