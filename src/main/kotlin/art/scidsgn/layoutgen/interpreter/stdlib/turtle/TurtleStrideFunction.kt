package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.turtle.TurtleInstruction
import art.scidsgn.layoutgen.visual.turtle.TurtleStrideAddInstruction
import art.scidsgn.layoutgen.visual.turtle.TurtleStrideScaleInstruction
import art.scidsgn.layoutgen.visual.turtle.TurtleStrideSetInstruction

class TurtleStrideFunction : BuiltinFunction("TurtleStride") {
    override fun execute(context: FunctionContext): TurtleInstruction {
        return if (context.hasArgument("set")) {
            TurtleStrideSetInstruction(context.argumentSingleValue("set", TypeName.NUMBER))
        } else if (context.hasArgument("add")) {
            TurtleStrideAddInstruction(context.argumentSingleValue("add", TypeName.NUMBER))
        } else if (context.hasArgument("scale")) {
            TurtleStrideScaleInstruction(context.argumentSingleValue("scale", TypeName.NUMBER))
        } else {
            throw GeneralError(Errors.TURTLE_STRIDE_ARGUMENTS_MISSING)
        }
    }
}