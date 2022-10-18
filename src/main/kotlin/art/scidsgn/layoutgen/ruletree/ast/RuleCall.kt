package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

class RuleCall(val name: RuleName, codePosition: RuletreeCodePosition) : Element(codePosition) {
    val arguments = mutableMapOf<String, Element>()
}
