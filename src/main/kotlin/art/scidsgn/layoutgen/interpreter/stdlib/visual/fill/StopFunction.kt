package art.scidsgn.layoutgen.interpreter.stdlib.visual.fill

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.fill.GradientStop

class StopFunction : BuiltinFunction("Stop") {
    override fun execute(context: FunctionContext): Any {
        return GradientStop(
            context.argumentSingleValue("position", TypeName.NUMBER),
            context.argumentSingleValue("color", TypeName.COLOR)
        )
    }
}