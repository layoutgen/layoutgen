package art.scidsgn.layoutgen.interpreter.stdlib.image

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import java.awt.Image

class HeightFunction : BuiltinFunction("Height") {
    override fun execute(context: FunctionContext): Double {
        return context.argumentSingleValue<Image>("image", TypeName.IMAGE).getHeight(null).toDouble()
    }
}