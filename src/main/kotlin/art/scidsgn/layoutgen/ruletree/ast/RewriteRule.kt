package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.io.CodePosition

class RewriteRule(ruleTree: Ruletree, name: RuleName, codePosition: CodePosition) :
    Rule(ruleTree, name, codePosition) {
    val branches = mutableListOf<RuleBranch<RuleName>>()
}