package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.turtle.TurtleRestoreInstruction

class TurtleRestoreFunction : BuiltinFunction("TurtleRestore") {
    override fun execute(context: FunctionContext): TurtleRestoreInstruction {
        return TurtleRestoreInstruction()
    }
}