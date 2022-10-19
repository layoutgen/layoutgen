package art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class AddFunction : BuiltinFunction("Add") {
    override fun execute(context: FunctionContext): Any {
        return context.body<Double>().sum()
    }
}