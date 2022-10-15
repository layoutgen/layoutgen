package art.scidsgn.layoutgen.layout.tree

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent

internal class BreadthUpIterator(start: Component) : Iterator<Component> {
    var component: Component?

    init {
        component = LeafIterable(start).last()
    }

    override fun hasNext(): Boolean {
        return component != null
    }

    override fun next(): Component {
        val current = component!!

        if (current.isLast()) {
            component = current.parent
        } else {
            component = current.nextSibling()

            if (component!! is ContainerComponent && (component!! as ContainerComponent).hasChildren()) {
                component = LeafIterable(component!!).last()
            }
        }

        return current
    }
}