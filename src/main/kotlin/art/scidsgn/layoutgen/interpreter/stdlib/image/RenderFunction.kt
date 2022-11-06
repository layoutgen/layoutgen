package art.scidsgn.layoutgen.interpreter.stdlib.image

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.visual.VisualTreeRenderer
import java.awt.image.BufferedImage

class RenderFunction : BuiltinFunction("Render") {
    override fun execute(context: FunctionContext): BufferedImage {
        val width = context.argumentSingleValue<Double>("width", TypeName.NUMBER).toInt()
        val height = context.argumentSingleValue<Double>("height", TypeName.NUMBER).toInt()
        val root = context.argumentSingleValue<Component>("root", TypeName.COMPONENT)

        LayoutEngine.layOut(root, Dimensions(width.toDouble(), height.toDouble()))
        return VisualTreeRenderer(root).render()
    }
}