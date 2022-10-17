package art.scidsgn.layoutgen.ruletree

import art.scidsgn.layoutgen.ruletree.ast.Rule

class Ruletree(val absoluteFilePath: String) {
    val rules = mutableListOf<Rule>()
}