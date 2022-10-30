package art.scidsgn.layoutgen.interpreter.stdlib.visual

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.image.ImageBox

class ImageBoxFunction : BuiltinFunction("ImageBox") {
    override fun execute(context: FunctionContext): ImageBox {
        return ImageBox(context.argumentSingleValue("image", TypeName.IMAGE))
    }
}