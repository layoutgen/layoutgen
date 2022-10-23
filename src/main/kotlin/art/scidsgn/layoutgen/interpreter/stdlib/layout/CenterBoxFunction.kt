package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.components.utils.CenterBox

class CenterBoxFunction : BuiltinFunction("CenterBox") {
    override fun execute(context: FunctionContext): CenterBox {
        val component = CenterBox(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleSizeArguments(component, context)

        return component
    }
}