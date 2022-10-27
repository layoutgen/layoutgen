package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.components.shapes.path.PathQuadraticInstruction

class PathQuadraticFunction : BuiltinFunction("PathQuadratic") {
    override fun execute(context: FunctionContext): PathQuadraticInstruction {
        return PathQuadraticInstruction(
            context.argumentSingleValue("through", TypeName.POINT),
            context.argumentSingleValue("to", TypeName.POINT)
        )
    }
}