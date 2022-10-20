package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.io.CodePosition

class BuiltinCall(val name: BuiltinName, codePosition: CodePosition) : Element(codePosition) {
    val arguments = mutableMapOf<String, Element>()
    val body = mutableListOf<Element>()
}