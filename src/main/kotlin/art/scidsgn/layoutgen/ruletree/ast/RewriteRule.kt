package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

class RewriteRule(name: RuleName, codePosition: RuletreeCodePosition) : Rule(name, codePosition) {
    val branches = mutableListOf<RuleBranch<RuleName>>()
}