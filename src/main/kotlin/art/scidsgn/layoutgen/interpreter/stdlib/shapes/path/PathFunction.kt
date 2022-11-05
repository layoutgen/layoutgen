package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils
import art.scidsgn.layoutgen.components.shapes.path.Path

class PathFunction : BuiltinFunction("Path") {
    override fun execute(context: FunctionContext): Path {
        var fillContainer = false
        if (context.hasArgument("fillContainer")) {
            fillContainer = context.argumentSingleValue("fillContainer", TypeName.BOOLEAN)
        }

        val component = Path(context.body(TypeName.PATH_INSTRUCTION), fillContainer)
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}