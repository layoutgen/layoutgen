package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

class BuiltinCall(val name: BuiltinName, codePosition: RuletreeCodePosition) : Element(codePosition) {
    val arguments = mutableMapOf<String, Element>()
    val body = mutableListOf<Element>()
}