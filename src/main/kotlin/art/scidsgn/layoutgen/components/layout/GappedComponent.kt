package art.scidsgn.layoutgen.components.layout

import art.scidsgn.layoutgen.components.Component
import kotlin.math.max

abstract class GappedComponent : Component() {
    var gap = 0.0

    fun getTotalGap(): Double {
        return gap * max(childComponents.size - 1, 0)
    }
}

fun <T : GappedComponent> T.withGap(gap: Double): T {
    this.gap = gap
    return this
}