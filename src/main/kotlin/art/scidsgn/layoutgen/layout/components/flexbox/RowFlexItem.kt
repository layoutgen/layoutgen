package art.scidsgn.layoutgen.layout.components.flexbox

import art.scidsgn.layoutgen.layout.components.Component


class RowFlexItem(component: Component) : FlexItem(component) {
    override var mainSize = component.size.targetSize.width
    override val crossSize = component.size.targetSize.height
}
