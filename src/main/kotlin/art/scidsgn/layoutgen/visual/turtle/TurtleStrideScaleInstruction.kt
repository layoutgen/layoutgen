package art.scidsgn.layoutgen.visual.turtle

class TurtleStrideScaleInstruction(val factor: Double) : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.state.stride *= factor
    }
}