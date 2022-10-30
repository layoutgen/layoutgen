package art.scidsgn.layoutgen.interpreter.stdlib.text

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.text.Font
import art.scidsgn.layoutgen.components.text.FontStyle

class FontFunction : BuiltinFunction("Font") {
    private val fontStyleMap = mapOf(
        Pair("regular", FontStyle.REGULAR),
        Pair("bold", FontStyle.BOLD),
        Pair("italic", FontStyle.ITALIC),
        Pair("boldItalic", FontStyle.BOLD_ITALIC),
    )

    override fun execute(context: FunctionContext): Font {
        var style = FontStyle.REGULAR
        if (context.hasArgument("style")) {
            style = context.argumentEnumValue("style", fontStyleMap)
        }

        return Font(
            context.argumentSingleValue("family", TypeName.STRING),
            context.argumentSingleValue("size", TypeName.NUMBER),
            style
        )
    }
}