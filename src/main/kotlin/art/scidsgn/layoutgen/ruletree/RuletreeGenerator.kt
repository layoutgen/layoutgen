package art.scidsgn.layoutgen.ruletree

interface RuletreeGenerator {
    fun parse(ruleTree: Ruletree, code: String)
}