package art.scidsgn.layoutgen.layout

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.ContainerComponent
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.components.sizing.Position
import art.scidsgn.layoutgen.components.sizing.UnclearDimensions
import art.scidsgn.layoutgen.layout.tree.BreadthUpIterable

object LayoutEngine {
    fun layOut(root: Component, rootDimensions: Dimensions) {
        root.propagateRequestedSize(UnclearDimensions(rootDimensions.width, rootDimensions.height))
        for (it in BreadthUpIterable(root)) {
            it.calculateTargetSize()
            if (it is ContainerComponent) {
                it.determineChildrenPositions()
            }

            if (it == root) {
                break
            }
        }
    }

    fun resetLayout(component: Component) {
        component.position = Position(0.0, 0.0)
        component.size.requestedSize = UnclearDimensions(null, null)

        if (component is ContainerComponent) {
            component.childComponents.forEach { resetLayout(it) }
        }
    }
}