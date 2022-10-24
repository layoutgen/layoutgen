package art.scidsgn.layoutgen.interpreter.stdlib.shapes

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.layout.LayoutFunctionUtils
import art.scidsgn.layoutgen.visual.components.shapes.RoundRect

class RoundRectFunction : BuiltinFunction("RoundRect") {
    override fun execute(context: FunctionContext): RoundRect {
        val radius = context.argumentSingleValue<Double>("radius", TypeName.NUMBER) {
            if (it < 0) {
                TODO("radius >= 0!!")
            }
        }
        val component = RoundRect(radius, context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}