package art.scidsgn.layoutgen.interpreter.stdlib.text

import art.scidsgn.layoutgen.components.text.TextAlignment
import art.scidsgn.layoutgen.components.text.TextBox
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.layout.LayoutFunctionUtils

class TextFunction : BuiltinFunction("Text") {
    private val textAlignmentMap = mapOf(
        Pair("left", TextAlignment.LEFT),
        Pair("center", TextAlignment.CENTER),
        Pair("right", TextAlignment.RIGHT),
    )

    override fun execute(context: FunctionContext): TextBox {
        var alignment = TextAlignment.LEFT
        if (context.hasArgument("align")) {
            alignment = context.argumentEnumValue("align", textAlignmentMap)
        }

        val component = TextBox(
            context.body<String>(TypeName.STRING).joinToString(""),
            context.argumentSingleValue("font", TypeName.FONT),
            alignment
        )
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}