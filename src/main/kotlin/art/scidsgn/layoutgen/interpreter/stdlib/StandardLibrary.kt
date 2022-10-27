package art.scidsgn.layoutgen.interpreter.stdlib

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.stdlib.layout.*
import art.scidsgn.layoutgen.interpreter.stdlib.list.CountFunction
import art.scidsgn.layoutgen.interpreter.stdlib.list.RepeatFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.AddFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.DivFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.MulFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.SubFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.statistics.MaxFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.statistics.MinFunction
import art.scidsgn.layoutgen.interpreter.stdlib.random.RandomIntFunction
import art.scidsgn.layoutgen.interpreter.stdlib.shapes.CircleFunction
import art.scidsgn.layoutgen.interpreter.stdlib.shapes.RoundRectFunction
import art.scidsgn.layoutgen.interpreter.stdlib.shapes.path.*
import art.scidsgn.layoutgen.interpreter.stdlib.visual.PointFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.render.RGBFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.render.StrokeFunction
import art.scidsgn.layoutgen.ruletree.ast.BuiltinName

object StandardLibrary {
    val functions = listOf(
        // Layout elements
        BoxFunction(),
        OffsetBoxFunction(),
        CenterBoxFunction(),
        MarginBoxFunction(),

        HTilingFunction(),
        VTilingFunction(),

        HStackFunction(),
        VStackFunction(),
        OverlapHStackFunction(),
        OverlapVStackFunction(),

        GridFunction(),

        // Shapes
        RoundRectFunction(),
        CircleFunction(),

        // Path
        PathFunction(),
        PathMoveFunction(),
        PathLineFunction(),
        PathQuadraticFunction(),
        PathCubicFunction(),
        PathCloseFunction(),

        // Fills & strokes
        RGBFunction(),
        StrokeFunction(),

        // Visual types
        PointFunction(),

        // Math: arithmetic
        AddFunction(),
        SubFunction(),
        MulFunction(),
        DivFunction(),

        // Math: statistics
        MinFunction(),
        MaxFunction(),

        // Random
        RandomIntFunction(),

        // List
        CountFunction(),
        RepeatFunction(),
    )

    fun getFunction(name: BuiltinName): BuiltinFunction {
        return functions.find { "\$${it.name}" == name.name } ?: throw InFileError(
            Errors.BUILTIN_FUNCTION_NOT_FOUND, arrayOf(name.name), name.codePosition
        )
    }
}