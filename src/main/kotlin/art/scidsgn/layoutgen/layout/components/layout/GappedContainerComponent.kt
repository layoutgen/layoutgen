package art.scidsgn.layoutgen.layout.components.layout

import art.scidsgn.layoutgen.layout.ContainerComponent
import kotlin.math.max

abstract class GappedContainerComponent : ContainerComponent() {
    var gap = 0.0

    fun withGap(gap: Double): GappedContainerComponent {
        this.gap = gap
        return this
    }

    fun getTotalGap(): Double {
        return gap * max(childComponents.size - 1, 0)
    }
}