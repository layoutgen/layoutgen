package art.scidsgn.layoutgen.ruletree.ast

class RuleBranch<T>(var weight: Double = 1.0) {
    val items = mutableListOf<T>()
}