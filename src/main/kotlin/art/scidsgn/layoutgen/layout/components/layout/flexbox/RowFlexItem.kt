package art.scidsgn.layoutgen.layout.components.layout.flexbox

import art.scidsgn.layoutgen.layout.Component


class RowFlexItem(component: Component) : FlexItem(component) {
    override val mainSize = component.size.targetSize.width
    override val crossSize = component.size.targetSize.height
}
