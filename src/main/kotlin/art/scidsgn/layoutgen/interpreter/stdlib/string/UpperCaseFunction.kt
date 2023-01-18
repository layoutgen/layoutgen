package art.scidsgn.layoutgen.interpreter.stdlib.string

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import java.util.*

class UpperCaseFunction : BuiltinFunction("UpperCase") {
    override fun execute(context: FunctionContext): String {
        return context.argumentSingleValue<String>("string", TypeName.STRING).uppercase(Locale.getDefault())
    }
}
