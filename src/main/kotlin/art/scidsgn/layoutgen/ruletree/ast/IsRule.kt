package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

class IsRule(ruleTree: Ruletree, name: RuleName, codePosition: RuletreeCodePosition) :
    Rule(ruleTree, name, codePosition) {
    var branches = mutableListOf<RuleBranch<Element>>()
    var variables = mutableListOf<Variable>()
}