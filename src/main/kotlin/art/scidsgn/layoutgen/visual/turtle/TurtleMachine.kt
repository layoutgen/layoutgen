package art.scidsgn.layoutgen.visual.turtle

import art.scidsgn.layoutgen.visual.path.PathInstruction
import art.scidsgn.layoutgen.visual.path.PathLineInstruction
import art.scidsgn.layoutgen.visual.path.PathMoveInstruction
import art.scidsgn.layoutgen.visual.types.Point

class TurtleMachine(initialPosition: Point, initialAngle: Double, initialStride: Double, initialPressed: Boolean) {
    var state = TurtleState(initialPosition, initialAngle, initialStride, initialPressed)
    private val memory: ArrayDeque<TurtleState> = ArrayDeque()

    val pathInstructions: MutableList<PathInstruction> = mutableListOf()

    init {
        pathInstructions.add(PathMoveInstruction(initialPosition))
    }

    fun execute(instructions: List<TurtleInstruction>) {
        instructions.forEach { it.perform(this) }
    }

    fun save() {
        memory.addLast(state.clone())
    }

    fun restore() {
        state = memory.removeLastOrNull() ?: TODO("no state to restore")
        pathInstructions.add(PathMoveInstruction(state.position))
    }

    fun forward() {
        state.forward()
        if (state.pressed) {
            pathInstructions.add(PathLineInstruction(state.position))
        } else {
            pathInstructions.add(PathMoveInstruction(state.position))
        }
    }
}