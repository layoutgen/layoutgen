package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.turtle.TurtleLiftInstruction

class TurtleLiftFunction : BuiltinFunction("TurtleLift") {
    override fun execute(context: FunctionContext): TurtleLiftInstruction {
        return TurtleLiftInstruction()
    }
}