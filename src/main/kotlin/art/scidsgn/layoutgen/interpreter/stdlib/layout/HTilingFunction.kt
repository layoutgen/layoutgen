package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.components.tiling.HTiling

class HTilingFunction : BuiltinFunction("HTiling") {
    override fun execute(context: FunctionContext): HTiling {
        val component = HTiling(context.body(TypeName.COMPONENT))

        if (context.hasArgument("gap")) {
            component.gap = context.argumentSingleValue("gap", TypeName.NUMBER) {
                if (it < 0) {
                    throw GeneralError(Errors.LAYOUT_GAP_CANNOT_BE_NEGATIVE, emptyArray())
                }
            }
        }

        return component
    }
}