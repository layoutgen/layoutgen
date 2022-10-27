package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.components.shapes.path.PathCubicInstruction

class PathCubicFunction : BuiltinFunction("PathCubic") {
    override fun execute(context: FunctionContext): PathCubicInstruction {
        return PathCubicInstruction(
            context.argumentSingleValue("through1", TypeName.POINT),
            context.argumentSingleValue("through2", TypeName.POINT),
            context.argumentSingleValue("to", TypeName.POINT)
        )
    }
}