package art.scidsgn.layoutgen.layout.components.flexbox

import art.scidsgn.layoutgen.layout.Component

class ColumnFlexItem(component: Component) : FlexItem(component) {
    override val mainSize = component.size.targetSize.height
    override val crossSize = component.size.targetSize.width
}