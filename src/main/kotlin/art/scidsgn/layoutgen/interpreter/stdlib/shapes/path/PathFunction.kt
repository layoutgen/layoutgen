package art.scidsgn.layoutgen.interpreter.stdlib.shapes.path

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.layout.LayoutFunctionUtils
import art.scidsgn.layoutgen.visual.components.shapes.path.Path

class PathFunction : BuiltinFunction("Path") {
    override fun execute(context: FunctionContext): Path {
        val component = Path(context.body(TypeName.PATH_INSTRUCTION))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}