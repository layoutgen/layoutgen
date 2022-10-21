package art.scidsgn.layoutgen.interpreter.stdlib

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext

class TestFunction : BuiltinFunction("Test") {
    override fun execute(context: FunctionContext): Any {
        context.noBody()
        val x = context.argumentSingleValue<Double>("x")

        return x
    }
}