package art.scidsgn.layoutgen.interpreter.stdlib.shapes

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils
import art.scidsgn.layoutgen.components.shapes.Circle

class CircleFunction : BuiltinFunction("Circle") {
    override fun execute(context: FunctionContext): Circle {
        val component = Circle(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}