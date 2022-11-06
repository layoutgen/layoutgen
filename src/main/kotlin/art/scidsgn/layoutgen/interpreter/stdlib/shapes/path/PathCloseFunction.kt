package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.path.PathCloseInstruction

class PathCloseFunction : BuiltinFunction("PathClose") {
    override fun execute(context: FunctionContext): PathCloseInstruction {
        return PathCloseInstruction()
    }
}