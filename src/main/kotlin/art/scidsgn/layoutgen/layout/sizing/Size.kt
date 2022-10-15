package art.scidsgn.layoutgen.layout.sizing

class Size() {
    var requestedSize: Dimensions? = null
    lateinit var targetSize: Dimensions

    var definedSize: Dimensions? = null

    fun hasTargetSize(): Boolean {
        return this::targetSize.isInitialized
    }
}