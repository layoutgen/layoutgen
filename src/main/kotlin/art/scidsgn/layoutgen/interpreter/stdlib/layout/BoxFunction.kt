package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.Box
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils

class BoxFunction : BuiltinFunction("Box") {
    override fun execute(context: FunctionContext): Box {
        val component = Box(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}