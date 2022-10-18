package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

abstract class Rule(val ruleTree: Ruletree, val name: RuleName, codePosition: RuletreeCodePosition) :
    Element(codePosition) {
    val annotations = mutableListOf<String>()
}