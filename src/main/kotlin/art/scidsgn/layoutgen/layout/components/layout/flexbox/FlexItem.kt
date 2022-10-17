package art.scidsgn.layoutgen.layout.components.layout.flexbox

import art.scidsgn.layoutgen.layout.Component

abstract class FlexItem(val component: Component) {
    abstract val mainSize: Double
    abstract val crossSize: Double
}