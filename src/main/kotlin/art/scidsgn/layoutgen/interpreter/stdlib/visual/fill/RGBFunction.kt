package art.scidsgn.layoutgen.interpreter.stdlib.visual.fill

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.fill.RGBColor

class RGBFunction : BuiltinFunction("RGB") {
    override fun execute(context: FunctionContext): RGBColor {
        val red = context.argumentSingleValue<Double>("r", TypeName.NUMBER)
        val green = context.argumentSingleValue<Double>("g", TypeName.NUMBER)
        val blue = context.argumentSingleValue<Double>("b", TypeName.NUMBER)

        var alpha = 255.0
        if (context.hasArgument("a")) {
            alpha = context.argumentSingleValue("a", TypeName.NUMBER)
        }

        return RGBColor(red, green, blue, alpha)
    }
}