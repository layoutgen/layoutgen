package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.io.CodePosition

class RuleCall(val name: RuleName, codePosition: CodePosition) : Element(codePosition) {
    val arguments = mutableMapOf<String, Element>()
}
