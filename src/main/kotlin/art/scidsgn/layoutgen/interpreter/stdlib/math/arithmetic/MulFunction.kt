package art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

class MulFunction : BuiltinFunction("Mul") {
    override fun execute(context: FunctionContext): Double {
        return context.body<Double>(TypeName.NUMBER).reduce { acc, x -> acc * x }
    }
}