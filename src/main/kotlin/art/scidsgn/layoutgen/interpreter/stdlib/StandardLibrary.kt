package art.scidsgn.layoutgen.interpreter.stdlib

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.stdlib.list.CountFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.AddFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.DivFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.MulFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.SubFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.statistics.MaxFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.statistics.MinFunction
import art.scidsgn.layoutgen.ruletree.ast.BuiltinName

object StandardLibrary {
    val functions = listOf(
        // Math: arithmetic
        AddFunction(),
        SubFunction(),
        MulFunction(),
        DivFunction(),

        // Math: statistics
        MinFunction(),
        MaxFunction(),

        // List
        CountFunction(),

        TestFunction()
    )

    fun getFunction(name: BuiltinName): BuiltinFunction {
        return functions.find { "\$${it.name}" == name.name } ?: throw InFileError(
            Errors.BUILTIN_FUNCTION_NOT_FOUND, arrayOf(name.name), name.codePosition
        )
    }
}