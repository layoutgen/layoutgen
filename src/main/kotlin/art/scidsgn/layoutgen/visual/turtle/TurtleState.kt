package art.scidsgn.layoutgen.visual.turtle

import art.scidsgn.layoutgen.visual.types.Point
import kotlin.math.cos
import kotlin.math.sin

data class TurtleState(var position: Point, var angle: Double, var stride: Double, var pressed: Boolean) {
    fun forward() {
        position = Point(
            position.x + stride * cos(angle),
            position.y + stride * sin(angle)
        )
    }

    fun turn(deltaAngle: Double) {
        angle += deltaAngle
    }

    fun clone(): TurtleState {
        return TurtleState(
            Point(position.x, position.y),
            angle, stride, pressed
        )
    }
}
