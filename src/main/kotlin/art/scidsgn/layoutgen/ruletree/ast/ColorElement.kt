package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.ruletree.io.CodePosition
import art.scidsgn.layoutgen.visual.fill.RGBColor

class ColorElement(val hex: String, codePosition: CodePosition) : Element(codePosition) {
    fun toFill(): RGBColor {
        if (hex.length == 4) {
            return RGBColor(
                (255 * (hex.substring(1, 2).toInt(16).toDouble() / 15)),
                (255 * (hex.substring(2, 3).toInt(16).toDouble() / 15)),
                (255 * (hex.substring(3, 4).toInt(16).toDouble() / 15)),
                255.0
            )
        } else if (hex.length == 5) {
            return RGBColor(
                (255 * (hex.substring(1, 2).toInt(16).toDouble() / 15)),
                (255 * (hex.substring(2, 3).toInt(16).toDouble() / 15)),
                (255 * (hex.substring(3, 4).toInt(16).toDouble() / 15)),
                (255 * (hex.substring(4, 5).toInt(16).toDouble() / 15))
            )
        } else if (hex.length == 7) {
            return RGBColor(
                hex.substring(1, 3).toInt(16).toDouble(),
                hex.substring(3, 5).toInt(16).toDouble(),
                hex.substring(5, 7).toInt(16).toDouble(),
                255.0
            )
        } else if (hex.length == 9) {
            return RGBColor(
                hex.substring(1, 3).toInt(16).toDouble(),
                hex.substring(3, 5).toInt(16).toDouble(),
                hex.substring(5, 7).toInt(16).toDouble(),
                hex.substring(7, 9).toInt(16).toDouble()
            )
        } else {
            throw InFileError(Errors.COLOR_SYNTAX_INCORRECT, emptyArray(), codePosition)
        }
    }
}