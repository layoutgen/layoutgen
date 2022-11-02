package art.scidsgn.layoutgen.interpreter.stdlib.visual.render

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.visual.fill.Texture
import art.scidsgn.layoutgen.visual.fill.TextureStretch

class TextureFunction : BuiltinFunction("Texture") {
    private val textureStretchMap = mapOf(
        Pair("none", TextureStretch.NONE),
        Pair("width", TextureStretch.WIDTH),
        Pair("height", TextureStretch.HEIGHT),
        Pair("both", TextureStretch.BOTH),
    )

    override fun execute(context: FunctionContext): Texture {
        var width: Double? = null
        if (context.hasArgument("width")) {
            width = context.argumentSingleValue("width", TypeName.NUMBER)
        }

        var height: Double? = null
        if (context.hasArgument("height")) {
            height = context.argumentSingleValue("height", TypeName.NUMBER)
        }

        var stretch = TextureStretch.NONE
        if (context.hasArgument("stretch")) {
            stretch = context.argumentEnumValue("stretch", textureStretchMap)
        }

        return Texture(context.argumentSingleValue("image", TypeName.IMAGE), width, height, stretch)
    }
}