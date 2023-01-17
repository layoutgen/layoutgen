package art.scidsgn.layoutgen.interpreter.stdlib.visual.fill

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.fill.HSLColor

class HSLFunction : BuiltinFunction("HSV") {
    override fun execute(context: FunctionContext): HSLColor {
        val h = context.argumentSingleValue<Double>("h", TypeName.NUMBER)
        val s = context.argumentSingleValue<Double>("s", TypeName.NUMBER)
        val l = context.argumentSingleValue<Double>("l", TypeName.NUMBER)

        var alpha = 255.0
        if (context.hasArgument("a")) {
            alpha = context.argumentSingleValue("a", TypeName.NUMBER)
        }

        return HSLColor(h, s, l, alpha)
    }
}