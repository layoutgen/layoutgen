package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.components.layout.flexbox.Flexbox
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils

class FlexboxFunction : BuiltinFunction("Flexbox") {
    override fun execute(context: FunctionContext): Flexbox {
        val component = Flexbox(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        if (context.hasArgument("direction")) {
            component.withFlexDirection(
                context.argumentEnumValue(
                    "direction",
                    LayoutFunctionUtils.flexDirectionMap
                )
            )
        }
        if (context.hasArgument("justifyContent")) {
            component.withJustifyContent(
                context.argumentEnumValue(
                    "justifyContent",
                    LayoutFunctionUtils.flexContentJustificationMap
                )
            )
        }
        if (context.hasArgument("alignContent")) {
            component.withAlignContent(
                context.argumentEnumValue(
                    "alignContent",
                    LayoutFunctionUtils.flexContentAlignmentMap
                )
            )
        }
        if (context.hasArgument("alignItems")) {
            component.withAlignItems(
                context.argumentEnumValue(
                    "alignItems",
                    LayoutFunctionUtils.flexItemAlignmentMap
                )
            )
        }
        if (context.hasArgument("wrap")) {
            component.withFlexWrap(context.argumentSingleValue("wrap", TypeName.BOOLEAN))
        }

        return component
    }
}