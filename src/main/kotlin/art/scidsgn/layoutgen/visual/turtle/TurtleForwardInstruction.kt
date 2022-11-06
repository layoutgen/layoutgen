package art.scidsgn.layoutgen.visual.turtle

class TurtleForwardInstruction() : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.forward()
    }
}