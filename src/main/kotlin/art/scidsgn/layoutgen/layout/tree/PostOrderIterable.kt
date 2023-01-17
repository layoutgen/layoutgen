package art.scidsgn.layoutgen.layout.tree

import art.scidsgn.layoutgen.components.Component

class PostOrderIterable(private var start: Component) : Iterable<Component> {
    override fun iterator(): Iterator<Component> {
        return PostOrderIterator(start)
    }
}