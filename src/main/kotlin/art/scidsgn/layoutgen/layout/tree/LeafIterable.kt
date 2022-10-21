package art.scidsgn.layoutgen.layout.tree

import art.scidsgn.layoutgen.layout.components.Component

class LeafIterable(private val component: Component) : Iterable<Component> {
    override fun iterator(): Iterator<Component> {
        return LeafIterator(component)
    }
}