package art.scidsgn.layoutgen.visual.turtle

interface TurtleInstruction {
    fun perform(machine: TurtleMachine)
}