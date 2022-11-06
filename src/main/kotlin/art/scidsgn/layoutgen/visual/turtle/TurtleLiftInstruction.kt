package art.scidsgn.layoutgen.visual.turtle

class TurtleLiftInstruction() : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.state.pressed = false
    }
}