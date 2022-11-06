package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.turtle.TurtleForwardInstruction

class TurtleForwardFunction : BuiltinFunction("TurtleForward") {
    override fun execute(context: FunctionContext): TurtleForwardInstruction {
        return TurtleForwardInstruction()
    }
}