package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.stdlib.utils.TrigFunctionUtils
import art.scidsgn.layoutgen.visual.turtle.TurtleTurnInstruction

class TurtleTurnFunction : BuiltinFunction("TurtleTurn") {
    override fun execute(context: FunctionContext): TurtleTurnInstruction {
        return TurtleTurnInstruction(
            TrigFunctionUtils.getValue(context, "angle")
        )
    }
}