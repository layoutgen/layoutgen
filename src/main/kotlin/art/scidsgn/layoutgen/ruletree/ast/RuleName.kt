package art.scidsgn.layoutgen.ruletree.ast

import art.scidsgn.layoutgen.ruletree.RuletreeCodePosition

data class RuleName(val name: String, val moduleName: String?, val codePosition: RuletreeCodePosition)
