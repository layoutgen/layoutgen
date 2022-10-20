package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.io.CodePosition

abstract class Rule(val ruleTree: Ruletree, val name: RuleName, codePosition: CodePosition) :
    Element(codePosition) {
    val annotations = mutableListOf<String>()
}