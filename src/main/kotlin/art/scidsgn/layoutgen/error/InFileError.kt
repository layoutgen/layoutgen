package art.scidsgn.layoutgen.error

import art.scidsgn.layoutgen.ruletree.io.CodePosition

data class InFileError(override val cause: Throwable, val codePosition: CodePosition) :
    Throwable() {
    override val message: String
        get() {
            val lines = codePosition.sourceFile.fileContents.split(Regex("\r?\n"))

            return "In file %s, line %d column %d:\n%s\n    %s\n    %s".format(
                codePosition.sourceFile.absoluteFilePath,
                codePosition.line,
                codePosition.column + 1,
                cause.message,
                lines[codePosition.line - 1],
                " ".repeat(codePosition.column) + "^"
            )
        }

    constructor(
        errorType: Errors,
        formatStringArgs: Array<String>,
        codePosition: CodePosition
    ) : this(
        GeneralError(errorType, formatStringArgs), codePosition
    )
}
