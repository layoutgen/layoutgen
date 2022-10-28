package art.scidsgn.layoutgen.interpreter.stdlib.text

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.layout.LayoutFunctionUtils
import art.scidsgn.layoutgen.visual.components.text.TextBox

class TextFunction : BuiltinFunction("Text") {
    override fun execute(context: FunctionContext): TextBox {
        val component = TextBox(
            context.body<String>(TypeName.STRING).joinToString(),
            context.argumentSingleValue("font", TypeName.FONT)
        )
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}