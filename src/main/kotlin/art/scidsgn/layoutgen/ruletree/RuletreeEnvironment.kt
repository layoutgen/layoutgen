package art.scidsgn.layoutgen.ruletree

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.ruletree.io.SourceFile
import java.io.File
import java.io.IOException

class RuletreeEnvironment(val generator: RuletreeGenerator) {
    val ruleTrees = mutableMapOf<String, Ruletree>()

    fun loadFile(absoluteFilePath: String): Ruletree {
        if (ruleTrees.containsKey(absoluteFilePath)) {
            return ruleTrees[absoluteFilePath]!!
        } else {
            val code = try {
                File(absoluteFilePath).readText()
            } catch (_: IOException) {
                throw GeneralError(Errors.COULD_NOT_LOAD_SOURCE_FILE, arrayOf(absoluteFilePath))
            }
            val sourceFile = SourceFile(absoluteFilePath, code)

            val ruleTree = Ruletree(this, sourceFile)
            ruleTrees[absoluteFilePath] = ruleTree

            return generator.parse(ruleTree, code)
        }
    }
}