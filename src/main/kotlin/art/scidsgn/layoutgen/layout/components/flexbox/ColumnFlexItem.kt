package art.scidsgn.layoutgen.layout.components.flexbox

import art.scidsgn.layoutgen.layout.components.Component

class ColumnFlexItem(component: Component) : FlexItem(component) {
    override var mainSize = component.size.targetSize.height
    override val crossSize = component.size.targetSize.width
}