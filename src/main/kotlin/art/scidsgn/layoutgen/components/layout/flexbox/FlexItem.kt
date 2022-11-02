package art.scidsgn.layoutgen.components.layout.flexbox

import art.scidsgn.layoutgen.components.Component

abstract class FlexItem(val component: Component) {
    abstract var mainSize: Double
    abstract var crossSize: Double
}