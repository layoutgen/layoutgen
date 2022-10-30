package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.layout.utils.MarginBox
import art.scidsgn.layoutgen.components.sizing.Margins

class MarginBoxFunction : BuiltinFunction("MarginBox") {
    private val marginGuard = { it: Double ->
        if (it < 0.0) {
            throw GeneralError(Errors.LAYOUT_MARGIN_CANNOT_BE_NEGATIVE)
        }
    }

    override fun execute(context: FunctionContext): MarginBox {
        var left = 0.0
        var top = 0.0
        var right = 0.0
        var bottom = 0.0
        if (context.hasArgument("all")) {
            val value = context.argumentSingleValue("all", TypeName.NUMBER, marginGuard)

            left = value
            top = value
            right = value
            bottom = value
        }
        if (context.hasArgument("vertical")) {
            val value = context.argumentSingleValue("vertical", TypeName.NUMBER, marginGuard)

            top = value
            bottom = value
        }
        if (context.hasArgument("horizontal")) {
            val value = context.argumentSingleValue("horizontal", TypeName.NUMBER, marginGuard)

            left = value
            right = value
        }
        if (context.hasArgument("left")) {
            left = context.argumentSingleValue("left", TypeName.NUMBER, marginGuard)
        }
        if (context.hasArgument("top")) {
            top = context.argumentSingleValue("top", TypeName.NUMBER, marginGuard)
        }
        if (context.hasArgument("right")) {
            right = context.argumentSingleValue("right", TypeName.NUMBER, marginGuard)
        }
        if (context.hasArgument("bottom")) {
            bottom = context.argumentSingleValue("bottom", TypeName.NUMBER, marginGuard)
        }

        val component =
            MarginBox(Margins(top, right, bottom, left), context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}