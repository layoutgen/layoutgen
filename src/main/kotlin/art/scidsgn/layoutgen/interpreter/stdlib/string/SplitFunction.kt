package art.scidsgn.layoutgen.interpreter.stdlib.string

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class SplitFunction : BuiltinFunction("Split") {
    override fun execute(context: FunctionContext): List<String> {
        return context.argumentSingleValue<String>("string", TypeName.STRING)
            .split(context.argumentSingleValue<String>("separator", TypeName.STRING))
    }
}
