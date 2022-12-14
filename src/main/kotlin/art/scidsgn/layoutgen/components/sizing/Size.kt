package art.scidsgn.layoutgen.components.sizing

class Size() {
    var requestedSize: UnclearDimensions = UnclearDimensions(null, null)
    lateinit var targetSize: Dimensions

    var definedSize: UnclearDimensions = UnclearDimensions(null, null)

    fun hasTargetSize(): Boolean {
        return this::targetSize.isInitialized
    }
}