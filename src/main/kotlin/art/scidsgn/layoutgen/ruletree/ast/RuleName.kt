package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.io.CodePosition

open class RuleName(val name: String, val moduleName: String?, codePosition: CodePosition) :
    Element(codePosition)
