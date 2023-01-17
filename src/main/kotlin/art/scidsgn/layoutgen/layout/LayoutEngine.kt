package art.scidsgn.layoutgen.layout

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.tree.PostOrderIterable

object LayoutEngine {
    fun layOut(root: Component, rootDimensions: Dimensions) {
        root.propagateRequestedSize(UnclearDimensions(rootDimensions.width, rootDimensions.height))
        for (it in PostOrderIterable(root)) {
            it.calculateTargetSize()
            it.determineChildrenPositions()

            if (it == root) {
                break
            }
        }
    }

    fun resetLayout(component: Component) {
        component.position = Position(0.0, 0.0)
        component.size.requestedSize = UnclearDimensions(null, null)
        component.childComponents.forEach { resetLayout(it) }
    }
}