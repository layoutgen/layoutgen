package art.scidsgn.layoutgen.interpreter.stdlib.visual

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.types.Point

class PointFunction : BuiltinFunction("Point") {
    override fun execute(context: FunctionContext): Point {
        return Point(
            context.argumentSingleValue("x", TypeName.NUMBER),
            context.argumentSingleValue("y", TypeName.NUMBER)
        )
    }
}