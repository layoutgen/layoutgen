package art.scidsgn.layoutgen.layout.components

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.sizing.Position
import art.scidsgn.layoutgen.layout.sizing.UnclearDimensions

class CenterBox(child: Component? = null) : Box(child) {
    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = UnclearDimensions(
            size.definedSize.width ?: parentRequestedSize.width,
            size.definedSize.height ?: parentRequestedSize.height
        )

        childComponents.forEach { it.propagateRequestedSize(UnclearDimensions(null, null)) }
    }

    override fun determineChildrenPositions() {
        childComponents.forEach {
            it.position = Position(
                (size.targetSize.width - it.size.targetSize.width) / 2,
                (size.targetSize.height - it.size.targetSize.height) / 2
            )
        }
    }
}