package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.components.Box

class BoxFunction : BuiltinFunction("Box") {
    override fun execute(context: FunctionContext): Box {
        val component = Box(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleSizeArguments(component, context)

        return component
    }
}