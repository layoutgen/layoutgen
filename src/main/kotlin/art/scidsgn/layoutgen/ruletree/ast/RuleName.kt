package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

open class RuleName(val name: String, val moduleName: String?, codePosition: RuletreeCodePosition) :
    Element(codePosition)
