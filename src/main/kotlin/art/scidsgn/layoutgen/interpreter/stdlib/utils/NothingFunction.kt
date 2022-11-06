package art.scidsgn.layoutgen.interpreter.stdlib.utils

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class NothingFunction : BuiltinFunction("Nothing") {
    override fun execute(context: FunctionContext): List<Any> {
        return emptyList()
    }
}