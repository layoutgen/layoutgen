package art.scidsgn.layoutgen.error

class GeneralError(val errorType: Errors, private val formatStringArgs: Array<String>) :
    Throwable() {

    constructor(errorType: Errors) : this(errorType, emptyArray())

    override val message: String
        get() {
            return "E%04d: %s\n".format(
                Errors.values().indexOf(errorType),
                errorType.message.format(*formatStringArgs)
            )
        }
}