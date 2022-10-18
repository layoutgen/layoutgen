package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

abstract class Rule(val name: RuleName, codePosition: RuletreeCodePosition) : Element(codePosition) {
    val annotations = mutableListOf<String>()
}