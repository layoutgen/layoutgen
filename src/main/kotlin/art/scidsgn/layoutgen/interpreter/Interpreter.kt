package art.scidsgn.layoutgen.interpreter

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.interpreter.stdlib.StandardLibrary
import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.ast.*
import kotlin.random.Random

class Interpreter(val random: Random = Random, val maxDepth: Int = 16) {
    fun execute(rule: IsRule, ruleArguments: Map<String, Any> = emptyMap()): List<Any> {
        return execute(rule, ruleArguments, 0)
    }

    private fun execute(rule: IsRule, ruleArguments: Map<String, Any>, depth: Int): List<Any> {
        if (!rule.safe && depth >= maxDepth) {
            return emptyList()
        }

        // TODO: needs to be better, allow accessing codePosition here
        if (ruleArguments.size != rule.variables.size) {
            throw GeneralError(
                Errors.RULE_INCORRECT_ARGUMENT_COUNT,
                arrayOf(
                    rule.name.name,
                    rule.variables.size.toString(),
                    ruleArguments.size.toString()
                )
            )
        }
        ruleArguments.forEach { key, _ ->
            if (rule.variables.none { it.name == key }) {
                throw GeneralError(Errors.RULE_UNEXPECTED_ARGUMENT, arrayOf(key))
            }
        }

        return execute(rule.ruleTree, pickBranch(rule.branches), ruleArguments, depth)
    }

    private fun execute(
        ruleTree: Ruletree,
        branch: RuleBranch<Element>,
        arguments: Map<String, Any>,
        depth: Int
    ): List<Any> {
        return branch.items.map { interpretElement(ruleTree, it, arguments, depth) }.flat()
    }

    fun interpretElement(
        ruleTree: Ruletree,
        element: Element,
        ruleArguments: Map<String, Any>,
        depth: Int
    ): Any {
        return when (element) {
            is NumberElement -> element.number
            is StringElement -> element.string
            is BooleanElement -> element.boolean
            is Variable -> ruleArguments[element.name] ?: InFileError(
                Errors.RULE_UNDEFINED_VARIABLE, arrayOf(element.name), element.codePosition
            )

            is RuleCall -> interpretRuleCall(ruleTree, element, ruleArguments, depth)
            is BuiltinCall -> interpretBuiltinCall(ruleTree, element, ruleArguments, depth)

            is ColorElement -> element.toFill()
            else -> TODO("unknown element, sorry")
        }
    }

    private fun interpretBuiltinCall(
        ruleTree: Ruletree,
        builtinCall: BuiltinCall,
        ruleArguments: Map<String, Any>,
        depth: Int
    ): Any {
        val function = StandardLibrary.getFunction(builtinCall.name)
        val functionContext = FunctionContext(this, ruleTree, builtinCall, ruleArguments, depth)


        return function.execute(functionContext)
    }

    private fun interpretRuleCall(
        ruleTree: Ruletree,
        ruleCall: RuleCall,
        ruleArguments: Map<String, Any>,
        depth: Int
    ): Any {
        val rule = ruleTree.getIsRule(ruleCall.name)
        val ruleCallArguments = mutableMapOf<String, Any>()

        ruleCall.arguments.forEach { key, element ->
            ruleCallArguments[key] = interpretElement(ruleTree, element, ruleArguments, depth)
        }

        try {
            return execute(rule, ruleCallArguments, if (rule.safe) depth else depth + 1)
        } catch (e: GeneralError) {
            throw InFileError(e, ruleCall.codePosition)
        }
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