package art.scidsgn.layoutgen.interpreter.stdlib.visual.render

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.layout.LayoutFunctionUtils
import art.scidsgn.layoutgen.visual.fill.NineSlice

class NineSliceFunction : BuiltinFunction("NineSlice") {
    override fun execute(context: FunctionContext): NineSlice {
        return NineSlice(context.argumentSingleValue("image", TypeName.IMAGE), LayoutFunctionUtils.getMargins(context))
    }
}