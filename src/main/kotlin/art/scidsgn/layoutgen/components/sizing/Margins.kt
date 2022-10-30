package art.scidsgn.layoutgen.components.sizing

data class Margins(val top: Double, val right: Double, val bottom: Double, val left: Double) {
    val horizontal: Double
        get() = left + right
    val vertical: Double
        get() = top + bottom
}
