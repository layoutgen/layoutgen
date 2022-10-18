package art.scidsgn.layoutgen.interpreter

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.ast.*
import kotlin.random.Random

class Interpreter(val random: Random = Random, val maxDepth: Int = 100) {
    fun execute(rule: IsRule, arguments: Map<String, Any> = emptyMap()): List<Any> {
        return execute(rule, arguments, 0)
    }

    private fun execute(rule: IsRule, arguments: Map<String, Any>, depth: Int): List<Any> {
        if (depth >= maxDepth) {
            return emptyList()
        }

        // TODO: test if arguments match variables
        if (arguments.size != rule.variables.size) {
            TODO("wrong variable count")
        }
        arguments.forEach { key, _ ->
            if (rule.variables.none { it.name == key }) {
                TODO("unknown argument!!")
            }
        }

        return execute(rule.ruleTree, pickBranch(rule.branches), arguments, depth)
    }

    private fun execute(
        ruleTree: Ruletree,
        branch: RuleBranch<Element>,
        arguments: Map<String, Any>,
        depth: Int
    ): List<Any> {
        return branch.items.map { interpretElement(ruleTree, it, arguments, depth) }.flat()
    }

    private fun interpretElement(ruleTree: Ruletree, element: Element, arguments: Map<String, Any>, depth: Int): Any {
        return when (element) {
            is NumberElement -> element.number
            is StringElement -> element.string
            is BooleanElement -> element.boolean
            is Variable -> arguments[element.name] ?: TODO("unknown parameter!")
            is RuleCall -> interpretRuleCall(ruleTree, element, arguments, depth)

            else -> TODO("unknown element, sorry")
        }
    }

    private fun interpretRuleCall(
        ruleTree: Ruletree,
        ruleCall: RuleCall,
        arguments: Map<String, Any>,
        depth: Int
    ): Any {
        val ruleCallArguments = mutableMapOf<String, Any>()

        ruleCall.arguments.forEach { key, element ->
            ruleCallArguments[key] = interpretElement(ruleTree, element, arguments, depth)
        }

        val rule = ruleTree.getIsRule(ruleCall.name)

        return execute(rule, ruleCallArguments, depth + 1)
    }

    private fun <T> pickBranch(branches: List<RuleBranch<T>>): RuleBranch<T> {
        val cumulativeWeights = mutableListOf<Double>()
        var sum = 0.0

        branches.forEach {
            sum += it.weight
            cumulativeWeights += sum
        }

        val randomNumber = random.nextDouble() * sum
        val index = cumulativeWeights.indexOfFirst { it >= randomNumber }

        return branches[index]
    }
}