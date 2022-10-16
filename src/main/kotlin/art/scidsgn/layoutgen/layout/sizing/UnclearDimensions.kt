package art.scidsgn.layoutgen.layout.sizing

data class UnclearDimensions(var width: Double?, var height: Double?) {
    fun hasWidth(): Boolean {
        return width != null
    }

    fun hasHeight(): Boolean {
        return height != null
    }
}
