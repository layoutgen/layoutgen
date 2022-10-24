package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.components.stack.VStack

class VStackFunction : BuiltinFunction("VStack") {
    override fun execute(context: FunctionContext): VStack {
        val component = VStack(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        if (context.hasArgument("alignItems")) {
            component.withHorizontalAlignment(
                context.argumentEnumValue(
                    "alignItems",
                    LayoutFunctionUtils.horizontalAlignmentMap
                )
            )
        }
        if (context.hasArgument("alignAll")) {
            component.withVerticalAlignment(
                context.argumentEnumValue(
                    "alignAll",
                    LayoutFunctionUtils.verticalAlignmentMap
                )
            )
        }
        if (context.hasArgument("stretchItems")) {
            component.withHorizontalStretch(
                context.argumentSingleValue(
                    "stretchItems",
                    TypeName.BOOLEAN
                )
            )
        }

        return component
    }
}