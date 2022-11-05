package art.scidsgn.layoutgen.interpreter.stdlib.shapes

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils
import art.scidsgn.layoutgen.components.shapes.RoundRect

class RoundRectFunction : BuiltinFunction("RoundRect") {
    override fun execute(context: FunctionContext): RoundRect {
        val radius = context.argumentSingleValue<Double>("radius", TypeName.NUMBER) {
            if (it < 0) {
                throw GeneralError(Errors.SHAPE_ROUNDING_RADIUS_CANNOT_BE_NEGATIVE)
            }
        }
        val component = RoundRect(radius, context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component
    }
}