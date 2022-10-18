package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

class RewriteRule(ruleTree: Ruletree, name: RuleName, codePosition: RuletreeCodePosition) :
    Rule(ruleTree, name, codePosition) {
    val branches = mutableListOf<RuleBranch<RuleName>>()
}