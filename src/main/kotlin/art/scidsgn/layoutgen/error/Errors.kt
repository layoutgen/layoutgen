package art.scidsgn.layoutgen.error

enum class Errors(val message: String) {
    COULDNT_LOAD_SOURCE_FILE("Couldn't load source file %s"),
    MODULE_ALREADY_EXISTS("Module %s already imported in this Rulecode"),
    MODULE_NOT_FOUND("Module %s not found")
}