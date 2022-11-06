package art.scidsgn.layoutgen.visual.turtle

class TurtleRestoreInstruction() : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.restore()
    }
}