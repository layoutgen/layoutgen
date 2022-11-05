package art.scidsgn.layoutgen.interpreter.stdlib.image

import art.scidsgn.layoutgen.components.image.ImageBox
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils

class ImageBoxFunction : BuiltinFunction("ImageBox") {
    override fun execute(context: FunctionContext): ImageBox {
        val component = ImageBox(context.argumentSingleValue("image", TypeName.IMAGE))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}