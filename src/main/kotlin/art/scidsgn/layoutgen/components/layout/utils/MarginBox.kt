package art.scidsgn.layoutgen.components.layout.utils

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.*
import art.scidsgn.layoutgen.layout.LayoutUtils

class MarginBox(val margins: Margins, children: List<Component>) : Component() {
    override var parent: Component? = null
    override val childComponents = children

    override val size: Size = Size()
    override var position: Position = Position(0.0, 0.0)

    init {
        LayoutUtils.setChildrenParent(this)
    }

    override fun propagateRequestedSize(parentRequestedSize: UnclearDimensions) {
        size.requestedSize = parentRequestedSize

        childComponents.forEach {
            it.propagateRequestedSize(
                UnclearDimensions(
                    size.requestedSize.width?.minus(margins.horizontal),
                    size.requestedSize.height?.minus(margins.vertical)
                )
            )
        }
    }

    override fun calculateTargetSize() {
        size.targetSize = Dimensions(
            LayoutUtils.getMaxWidth(childComponents) + margins.horizontal,
            LayoutUtils.getMaxHeight(childComponents) + margins.vertical
        )
    }

    override fun determineChildrenPositions() {
        childComponents.forEach { it.position = Position(margins.left, margins.top) }
    }
}