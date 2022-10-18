package art.scidsgn.layoutgen.ruletree

import art.scidsgn.layoutgen.ruletree.ast.Rule
import java.nio.file.FileSystems

class Ruletree(val environment: RuletreeEnvironment, val absoluteFilePath: String) {
    val importedModules = mutableMapOf<String, Ruletree>()
    val rules = mutableListOf<Rule>()

    fun import(moduleName: String, relativePath: String) {
        if (importedModules.containsKey(moduleName)) {
            TODO("module already imported")
        }

        val basePath = FileSystems.getDefault().getPath(absoluteFilePath)
        val absoluteImportPath = basePath.parent.resolve(relativePath).normalize()

        importedModules[moduleName] = environment.loadFile(absoluteImportPath.toString())
    }
}