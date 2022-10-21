package art.scidsgn.layoutgen.layout.components.flexbox

import art.scidsgn.layoutgen.layout.Component

abstract class FlexItem(val component: Component) {
    abstract var mainSize: Double
    abstract val crossSize: Double
}