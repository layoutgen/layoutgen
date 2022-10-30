package art.scidsgn.layoutgen.interpreter.stdlib.flow

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class BlockFunction : BuiltinFunction("B") {
    override fun execute(context: FunctionContext): List<Any> {
        return context.body(TypeName.BASE)
    }
}