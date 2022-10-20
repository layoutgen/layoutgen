package art.scidsgn.layoutgen.interpreter.stdlib.list

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class CountFunction : BuiltinFunction("Count") {
    override fun execute(context: FunctionContext): Double {
        return context.body<Any>().size.toDouble()
    }
}