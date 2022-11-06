package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.path.PathLineInstruction

class PathLineFunction : BuiltinFunction("PathLine") {
    override fun execute(context: FunctionContext): PathLineInstruction {
        return PathLineInstruction(context.argumentSingleValue("to", TypeName.POINT))
    }
}