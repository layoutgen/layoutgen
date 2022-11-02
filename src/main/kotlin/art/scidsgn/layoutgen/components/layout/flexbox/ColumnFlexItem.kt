package art.scidsgn.layoutgen.components.layout.flexbox

import art.scidsgn.layoutgen.components.Component

class ColumnFlexItem(component: Component) : FlexItem(component) {
    override var mainSize = component.size.targetSize.height
    override var crossSize = component.size.targetSize.width
}