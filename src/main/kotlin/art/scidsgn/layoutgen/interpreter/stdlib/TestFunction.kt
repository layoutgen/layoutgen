package art.scidsgn.layoutgen.interpreter.stdlib

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class TestFunction : BuiltinFunction("Test") {
    override fun execute(context: FunctionContext): Any {
        context.noBody()
        val xs = context.argumentList<Double>("x", TypeName.NUMBER)

        return xs.sum()
    }
}