package art.scidsgn.layoutgen.layout.tree

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent

internal class LeafIterator(start: Component) : Iterator<Component> {
    private var component: Component?

    init {
        component = start
    }

    override fun hasNext(): Boolean {
        return component != null
    }

    override fun next(): Component {
        val current = component!!

        if (current is ContainerComponent && current.hasChildren()) {
            component = current.childComponents[0]
        } else {
            component = null
        }

        return current
    }
}