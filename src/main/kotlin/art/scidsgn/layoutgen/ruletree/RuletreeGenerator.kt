package art.scidsgn.layoutgen.ruletree

interface RuletreeGenerator {
    fun parse(ruletree: Ruletree, code: String)
}