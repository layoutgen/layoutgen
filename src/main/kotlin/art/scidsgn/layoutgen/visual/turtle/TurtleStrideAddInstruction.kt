package art.scidsgn.layoutgen.visual.turtle

class TurtleStrideAddInstruction(val delta: Double) : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.state.stride += delta
    }
}