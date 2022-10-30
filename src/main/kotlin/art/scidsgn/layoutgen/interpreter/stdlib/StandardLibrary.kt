package art.scidsgn.layoutgen.interpreter.stdlib

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.stdlib.flow.BlockFunction
import art.scidsgn.layoutgen.interpreter.stdlib.layout.*
import art.scidsgn.layoutgen.interpreter.stdlib.list.CountFunction
import art.scidsgn.layoutgen.interpreter.stdlib.list.RepeatFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.AddFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.DivFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.MulFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.arithmetic.SubFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.comparison.GreaterFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.comparison.GreaterOrEqualFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.comparison.LessFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.comparison.LessOrEqualFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.statistics.MaxFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.statistics.MinFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry.CosFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry.SinFunction
import art.scidsgn.layoutgen.interpreter.stdlib.math.trigonometry.TanFunction
import art.scidsgn.layoutgen.interpreter.stdlib.random.RandomColorFunction
import art.scidsgn.layoutgen.interpreter.stdlib.random.RandomFunction
import art.scidsgn.layoutgen.interpreter.stdlib.random.RandomIntFunction
import art.scidsgn.layoutgen.interpreter.stdlib.shapes.CircleFunction
import art.scidsgn.layoutgen.interpreter.stdlib.shapes.RoundRectFunction
import art.scidsgn.layoutgen.interpreter.stdlib.shapes.path.*
import art.scidsgn.layoutgen.interpreter.stdlib.text.FontFunction
import art.scidsgn.layoutgen.interpreter.stdlib.text.TextFunction
import art.scidsgn.layoutgen.interpreter.stdlib.utils.ToStringFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.ImageBoxFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.ImageFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.PointFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.render.RGBFunction
import art.scidsgn.layoutgen.interpreter.stdlib.visual.render.StrokeFunction
import art.scidsgn.layoutgen.ruletree.ast.BuiltinName

object StandardLibrary {
    val functions = listOf(
        // Flow
        BlockFunction(),

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
        FlexboxFunction(),

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

        // Text
        TextFunction(),
        FontFunction(),

        // Fills & strokes
        RGBFunction(),
        StrokeFunction(),

        // Visual types
        PointFunction(),

        ImageFunction(),
        ImageBoxFunction(),

        // Math: arithmetic
        AddFunction(),
        SubFunction(),
        MulFunction(),
        DivFunction(),

        // Math: statistics
        MinFunction(),
        MaxFunction(),

        // Math: trigonometry
        SinFunction(),
        CosFunction(),
        TanFunction(),

        // Math: comparison
        LessFunction(),
        LessOrEqualFunction(),
        GreaterFunction(),
        GreaterOrEqualFunction(),

        // Random
        RandomFunction(),
        RandomIntFunction(),
        RandomColorFunction(),

        // List
        CountFunction(),
        RepeatFunction(),

        // Utils
        ToStringFunction(),
    )

    fun getFunction(name: BuiltinName): BuiltinFunction {
        return functions.find { "\$${it.name}" == name.name } ?: throw InFileError(
            Errors.BUILTIN_FUNCTION_NOT_FOUND, arrayOf(name.name), name.codePosition
        )
    }
}