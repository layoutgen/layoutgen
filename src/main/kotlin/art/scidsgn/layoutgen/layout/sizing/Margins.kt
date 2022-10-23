package art.scidsgn.layoutgen.layout.sizing

data class Margins(val top: Double, val right: Double, val bottom: Double, val left: Double) {
    constructor(topBottom: Double, leftRight: Double) : this(
        topBottom,
        leftRight,
        topBottom,
        leftRight
    )

    constructor(all: Double) : this(all, all, all, all)

    val horizontal: Double
        get() = left + right
    val vertical: Double
        get() = top + bottom
}
