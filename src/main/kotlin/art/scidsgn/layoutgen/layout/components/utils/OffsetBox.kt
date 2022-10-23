package art.scidsgn.layoutgen.layout.components.utils

import art.scidsgn.layoutgen.layout.components.Box
import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.layout.sizing.Position

class OffsetBox(val offset: Position, children: List<Component>) : Box(children) {
    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = offset }
    }
}