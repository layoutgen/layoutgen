package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.io.CodePosition

class IsRule(ruleTree: Ruletree, name: RuleName, codePosition: CodePosition) :
    Rule(ruleTree, name, codePosition) {
    var branches = mutableListOf<RuleBranch<Element>>()
    var variables = mutableListOf<Variable>()

    var safe = false
}