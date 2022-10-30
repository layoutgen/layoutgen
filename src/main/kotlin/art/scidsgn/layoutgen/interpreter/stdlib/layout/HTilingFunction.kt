package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.layout.tiling.HTiling

class HTilingFunction : BuiltinFunction("HTiling") {
    override fun execute(context: FunctionContext): HTiling {
        val component = HTiling(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        if (context.hasArgument("alignItems")) {
            component.withVerticalAlignment(
                context.argumentEnumValue(
                    "alignItems",
                    LayoutFunctionUtils.verticalAlignmentMap
                )
            )
        }

        return component
    }
}