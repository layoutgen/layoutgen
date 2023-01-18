package art.scidsgn.layoutgen.interpreter.stdlib.string

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import java.util.*

class LowerCaseFunction : BuiltinFunction("LowerCase") {
    override fun execute(context: FunctionContext): String {
        return context.argumentSingleValue<String>("string", TypeName.STRING).lowercase(Locale.getDefault())
    }
}
