package art.scidsgn.layoutgen.components.layout.flexbox

import art.scidsgn.layoutgen.components.Component


class RowFlexItem(component: Component) : FlexItem(component) {
    override var mainSize = component.size.targetSize.width
    override var crossSize = component.size.targetSize.height
}
