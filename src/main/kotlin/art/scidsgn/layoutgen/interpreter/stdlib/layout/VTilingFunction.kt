package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.components.layout.tiling.VTiling

class VTilingFunction : BuiltinFunction("VTiling") {
    override fun execute(context: FunctionContext): VTiling {
        val component = VTiling(context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleContainerArguments(component, context)

        if (context.hasArgument("alignItems")) {
            component.withHorizontalAlignment(
                context.argumentEnumValue(
                    "alignItems",
                    LayoutFunctionUtils.horizontalAlignmentMap
                )
            )
        }

        return component
    }
}