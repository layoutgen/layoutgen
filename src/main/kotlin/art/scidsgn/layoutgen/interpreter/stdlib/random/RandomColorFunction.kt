package art.scidsgn.layoutgen.interpreter.stdlib.random

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.visual.fill.RGBColor

class RandomColorFunction : BuiltinFunction("RandomColor") {
    override fun execute(context: FunctionContext): RGBColor {
        return RGBColor(
            context.interpreter.random.nextDouble(0.0, 255.0),
            context.interpreter.random.nextDouble(0.0, 255.0),
            context.interpreter.random.nextDouble(0.0, 255.0),
            255.0
        )
    }
}