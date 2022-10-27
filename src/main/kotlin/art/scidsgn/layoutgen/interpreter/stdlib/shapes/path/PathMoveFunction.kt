package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.components.shapes.path.PathMoveInstruction

class PathMoveFunction : BuiltinFunction("PathMove") {
    override fun execute(context: FunctionContext): PathMoveInstruction {
        return PathMoveInstruction(context.argumentSingleValue("to", TypeName.POINT))
    }
}