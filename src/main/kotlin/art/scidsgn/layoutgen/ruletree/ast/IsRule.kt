package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

class IsRule(name: RuleName, codePosition: RuletreeCodePosition) : Rule(name, codePosition) {
    var branches = mutableListOf<RuleBranch<Element>>()
    var variables = mutableListOf<Variable>()
}