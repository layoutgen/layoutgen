package art.scidsgn.layoutgen.ruletree

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.ruletree.ast.IsRule
import art.scidsgn.layoutgen.ruletree.ast.RewriteRule
import art.scidsgn.layoutgen.ruletree.ast.RuleName
import art.scidsgn.layoutgen.ruletree.io.CodePosition
import art.scidsgn.layoutgen.ruletree.io.SourceFile
import java.nio.file.FileSystems
import java.nio.file.Path

class Ruletree(val environment: RuletreeEnvironment, val sourceFile: SourceFile) {
    val importedModules = mutableMapOf<String, Ruletree>()
    val isRules = mutableListOf<IsRule>()
    val rewriteRules = mutableListOf<RewriteRule>()

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

    fun importStd(moduleName: String) {
        if (importedModules.containsKey(moduleName)) {
            throw GeneralError(Errors.MODULE_ALREADY_EXISTS, arrayOf(moduleName))
        }

        val importPath = Path.of(
            {}.javaClass.classLoader.getResource(
                "std/$moduleName.rulecode"
            )?.toURI() ?: throw GeneralError(Errors.STD_MODULE_NOT_FOUND, arrayOf(moduleName))
        ).toString()

        importedModules[moduleName] = environment.loadFile(importPath)
    }

    fun getRootRule(): IsRule {
        val rootRules = isRules.filter { it.isRoot() }
        if (rootRules.isEmpty()) {
            throw InFileError(Errors.ROOT_RULE_NOT_PRESENT, emptyArray(), CodePosition(sourceFile, 1, 0))
        } else if (rootRules.size > 1) {
            throw InFileError(Errors.ROOT_RULE_ALREADY_PRESENT, emptyArray(), rootRules[1].codePosition)
        }

        return rootRules[0]
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
        return isRules.find { it.name.name == name && it.name.moduleName == null }
            ?: throw GeneralError(Errors.IS_RULE_NOT_FOUND, arrayOf(name))
    }

    fun getRewriteRule(name: String): RewriteRule {
        return rewriteRules.find { it.name.name == name && it.name.moduleName == null }
            ?: throw GeneralError(Errors.REWRITE_RULE_NOT_FOUND, arrayOf(name))
    }

    fun hasIsRule(name: String): Boolean {
        return isRules.any { it.name.name == name }
    }

    fun hasRewriteRule(name: String): Boolean {
        return rewriteRules.any { it.name.name == name }
    }
}