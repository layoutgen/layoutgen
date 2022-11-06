package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.turtle.TurtlePressInstruction

class TurtlePressFunction : BuiltinFunction("TurtlePress") {
    override fun execute(context: FunctionContext): TurtlePressInstruction {
        return TurtlePressInstruction()
    }
}