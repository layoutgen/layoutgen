package art.scidsgn.layoutgen.visual.turtle

class TurtlePressInstruction() : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.state.pressed = true
    }
}