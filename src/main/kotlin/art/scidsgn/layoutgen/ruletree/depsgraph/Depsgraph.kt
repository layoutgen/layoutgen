package art.scidsgn.layoutgen.ruletree.depsgraph

import art.scidsgn.layoutgen.ruletree.RuletreeEnvironment
import art.scidsgn.layoutgen.ruletree.ast.*

class Depsgraph(val environment: RuletreeEnvironment) {
    fun markCycles(rule: IsRule) {
        reset()
        traverse(rule, emptyList())
    }

    private fun reset() {
        environment.ruleTrees.values.forEach { ruleTree ->
            ruleTree.isRules.forEach { it.safe = true }
        }
    }

    private fun traverse(rule: IsRule, history: List<IsRule>) {
        if (rule in history) {
            val index = history.indexOf(rule)
            for (i in index until history.size) {
                history[i].safe = false
            }
            rule.safe = false

            return
        }

        val newHistory = history + rule
        for (dep in getDependencies(rule)) {
            traverse(dep, newHistory)
        }
    }

    private fun getDependencies(rule: IsRule): Set<IsRule> {
        val dependencies = mutableSetOf<IsRule>()

        rule.branches.forEach {
            getDependencies(rule, it, dependencies)
        }

        return dependencies
    }

    private fun getDependencies(rule: IsRule, branch: RuleBranch<Element>, dependencies: MutableSet<IsRule>) {
        branch.items.forEach {
            getDependencies(rule, it, dependencies)
        }
    }

    private fun getDependencies(rule: IsRule, element: Element, dependencies: MutableSet<IsRule>) {
        when (element) {
            is RuleCall -> {
                dependencies += rule.ruleTree.getIsRule(element.name)
                element.arguments.values.forEach {
                    getDependencies(rule, it, dependencies)
                }
            }

            is BuiltinCall -> {
                element.body.forEach {
                    getDependencies(rule, it, dependencies)
                }
                element.arguments.values.forEach {
                    getDependencies(rule, it, dependencies)
                }
            }

            else -> {}
        }
    }
}