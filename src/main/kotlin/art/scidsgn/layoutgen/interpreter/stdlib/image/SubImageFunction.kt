package art.scidsgn.layoutgen.interpreter.stdlib.image

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import java.awt.image.BufferedImage

class SubImageFunction : BuiltinFunction("SubImage") {
    override fun execute(context: FunctionContext): BufferedImage {
        val image = context.argumentSingleValue<BufferedImage>("image", TypeName.IMAGE)

        return image.getSubimage(
            context.argumentSingleValue<Double>("x", TypeName.NUMBER).toInt(),
            context.argumentSingleValue<Double>("y", TypeName.NUMBER).toInt(),
            context.argumentSingleValue<Double>("width", TypeName.NUMBER).toInt(),
            context.argumentSingleValue<Double>("height", TypeName.NUMBER).toInt()
        )
    }
}