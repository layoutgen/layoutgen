package art.scidsgn.layoutgen.layout.components

import art.scidsgn.layoutgen.layout.ContainerComponent
import kotlin.math.max

abstract class GappedContainerComponent : ContainerComponent() {
    var gap = 0.0

    fun getTotalGap(): Double {
        return gap * max(childComponents.size - 1, 0)
    }
}

fun <T : GappedContainerComponent> T.withGap(gap: Double): T {
    this.gap = gap
    return this
}