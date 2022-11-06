package art.scidsgn.layoutgen.visual.turtle

class TurtleStrideSetInstruction(val stride: Double) : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.state.stride += stride
    }
}