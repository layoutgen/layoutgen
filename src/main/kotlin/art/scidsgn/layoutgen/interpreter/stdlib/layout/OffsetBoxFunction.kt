package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.components.utils.OffsetBox
import art.scidsgn.layoutgen.layout.sizing.Position

class OffsetBoxFunction : BuiltinFunction("OffsetBox") {
    override fun execute(context: FunctionContext): OffsetBox {
        val offsetX = context.argumentSingleValue<Double>("offsetX", TypeName.NUMBER)
        val offsetY = context.argumentSingleValue<Double>("offsetY", TypeName.NUMBER)

        val component = OffsetBox(Position(offsetX, offsetY), context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        return component

    }
}