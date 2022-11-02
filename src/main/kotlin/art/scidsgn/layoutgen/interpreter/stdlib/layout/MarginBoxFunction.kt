package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.components.layout.utils.MarginBox
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class MarginBoxFunction : BuiltinFunction("MarginBox") {
    override fun execute(context: FunctionContext): MarginBox {
        val component =
            MarginBox(LayoutFunctionUtils.getMargins(context), context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}