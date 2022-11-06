package art.scidsgn.layoutgen.visual.turtle

class TurtleTurnInstruction(val deltaAngle: Double) : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.state.turn(deltaAngle)
    }
}