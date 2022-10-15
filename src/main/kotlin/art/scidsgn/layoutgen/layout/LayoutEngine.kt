package art.scidsgn.layoutgen.layout

import art.scidsgn.layoutgen.layout.sizing.Dimensions
import art.scidsgn.layoutgen.layout.tree.BreadthUpIterable

object LayoutEngine {
    fun layOut(root: Component, rootDimensions: Dimensions?) {
        root.propagateRequestedSize(rootDimensions)
        BreadthUpIterable(root).forEach {
            it.calculateTargetSize()
            if (it is ContainerComponent) {
                it.determineChildrenPositions()
            }
        }
    }
}