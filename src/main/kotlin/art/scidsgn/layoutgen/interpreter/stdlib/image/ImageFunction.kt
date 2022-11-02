package art.scidsgn.layoutgen.interpreter.stdlib.image

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageFunction : BuiltinFunction("Image") {
    override fun execute(context: FunctionContext): BufferedImage {
        val imagePath = context.ruleTree.absolutePathRelativeToRuleTree(
            context.argumentSingleValue(
                "path",
                TypeName.STRING
            )
        )

        return context.interpreter.createOrGetObject(imagePath) { ImageIO.read(File(imagePath)) }
    }
}