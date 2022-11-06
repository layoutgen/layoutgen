package art.scidsgn.layoutgen.interpreter.stdlib.turtle

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.TrigFunctionUtils
import art.scidsgn.layoutgen.visual.path.PathInstruction
import art.scidsgn.layoutgen.visual.turtle.TurtleMachine
import art.scidsgn.layoutgen.visual.types.Point

class TurtleMachineFunction : BuiltinFunction("TurtleMachine") {
    override fun execute(context: FunctionContext): List<PathInstruction> {
        val initialPosition = if (context.hasArgument("position")) {
            context.argumentSingleValue("position", TypeName.POINT)
        } else {
            Point(0.0, 0.0)
        }

        val initialAngle = if (context.hasArgument("angle")) {
            TrigFunctionUtils.getValue(context, "angle")
        } else {
            0.0
        }

        val initialStride = if (context.hasArgument("stride")) {
            context.argumentSingleValue("stride", TypeName.NUMBER)
        } else {
            10.0
        }

        val initialPressed = if (context.hasArgument("pressed")) {
            context.argumentSingleValue("pressed", TypeName.BOOLEAN)
        } else {
            false
        }

        val machine = TurtleMachine(initialPosition, initialAngle, initialStride, initialPressed)
        machine.execute(context.body(TypeName.TURTLE_INSTRUCTION))

        return machine.pathInstructions
    }
}