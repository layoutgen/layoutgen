package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.turtle.TurtleSaveInstruction

class TurtleSaveFunction : BuiltinFunction("TurtleSave") {
    override fun execute(context: FunctionContext): TurtleSaveInstruction {
        return TurtleSaveInstruction()
    }
}