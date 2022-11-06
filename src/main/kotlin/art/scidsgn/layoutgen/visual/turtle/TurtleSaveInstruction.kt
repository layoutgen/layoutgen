package art.scidsgn.layoutgen.visual.turtle

class TurtleSaveInstruction() : TurtleInstruction {
    override fun perform(machine: TurtleMachine) {
        machine.save()
    }
}