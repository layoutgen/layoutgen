package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.layout.stack.OverlapHStack
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils

class OverlapHStackFunction : BuiltinFunction("OverlapHStack") {
    override fun execute(context: FunctionContext): OverlapHStack {
        val component = OverlapHStack(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        if (context.hasArgument("alignItems")) {
            component.withVerticalAlignment(
                context.argumentEnumValue(
                    "alignItems",
                    LayoutFunctionUtils.verticalAlignmentMap
                )
            )
        }
        if (context.hasArgument("alignAll")) {
            component.withHorizontalAlignment(
                context.argumentEnumValue(
                    "alignAll",
                    LayoutFunctionUtils.horizontalAlignmentMap
                )
            )
        }
        if (context.hasArgument("stretchItems")) {
            component.withVerticalStretch(
                context.argumentSingleValue(
                    "stretchItems",
                    TypeName.BOOLEAN
                )
            )
        }

        return component
    }
}