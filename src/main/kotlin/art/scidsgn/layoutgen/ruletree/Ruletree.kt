package art.scidsgn.layoutgen.ruletree

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.ruletree.ast.IsRule
import art.scidsgn.layoutgen.ruletree.ast.RewriteRule
import art.scidsgn.layoutgen.ruletree.ast.Rule
import art.scidsgn.layoutgen.ruletree.ast.RuleName
import art.scidsgn.layoutgen.ruletree.io.SourceFile
import java.nio.file.FileSystems

class Ruletree(val environment: RuletreeEnvironment, val sourceFile: SourceFile) {
    val importedModules = mutableMapOf<String, Ruletree>()
    val rules = mutableListOf<Rule>()

    fun absolutePathRelativeToRuleTree(relativePath: String): String {
        val basePath = FileSystems.getDefault().getPath(sourceFile.absoluteFilePath)
        val absolutePath = basePath.parent.resolve(relativePath).normalize()

        return absolutePath.toString()
    }

    fun import(moduleName: String, relativePath: String) {
        if (importedModules.containsKey(moduleName)) {
            throw GeneralError(Errors.MODULE_ALREADY_EXISTS, arrayOf(moduleName))
        }

        importedModules[moduleName] =
            environment.loadFile(absolutePathRelativeToRuleTree(relativePath))
    }

    fun getIsRule(name: RuleName): IsRule {
        try {
            if (name.moduleName == null) {
                return getIsRule(name.name)
            }
            if (!importedModules.containsKey(name.moduleName)) {
                throw InFileError(
                    Errors.MODULE_NOT_FOUND,
                    arrayOf(name.moduleName),
                    name.codePosition
                )
            }

            return importedModules[name.moduleName]!!.getIsRule(name.name)
        } catch (e: GeneralError) {
            throw InFileError(e, name.codePosition)
        }
    }

    fun getIsRule(name: String): IsRule {
        return rules.find { it.name.name == name && it.name.moduleName == null && it is IsRule } as IsRule?
            ?: throw GeneralError(Errors.IS_RULE_NOT_FOUND, arrayOf(name))
    }

    fun getRewriteRule(name: String): RewriteRule {
        return rules.find { it.name.name == name && it.name.moduleName == null && it is RewriteRule } as RewriteRule?
            ?: throw GeneralError(Errors.REWRITE_RULE_NOT_FOUND, arrayOf(name))
    }
}