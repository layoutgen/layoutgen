package art.scidsgn.layoutgen.ruletree

import java.io.File

class RuletreeEnvironment(val generator: RuletreeGenerator) {
    val ruleTrees = mutableMapOf<String, Ruletree>()

    fun loadFile(absoluteFilePath: String): Ruletree {
        if (ruleTrees.containsKey(absoluteFilePath)) {
            return ruleTrees[absoluteFilePath]!!
        } else {
            val ruleTree = Ruletree(this, absoluteFilePath)
            ruleTrees[absoluteFilePath] = ruleTree

            // TODO: exception
            val code = File(absoluteFilePath).readText()
            generator.parse(ruleTree, code)

            return ruleTree
        }
    }
}