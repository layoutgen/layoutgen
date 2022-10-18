package demos

import art.scidsgn.layoutgen.ruletree.RuletreeEnvironment
import art.scidsgn.layoutgen.ruletree.parsers.antlr.AntlrRuletreeGenerator
import java.nio.file.Path

//object DemoListener : RulecodeBaseListener() {
//    override fun enterIsRule(ctx: RulecodeParser.IsRuleContext?) {
//        println("Is-rule found!")
//    }
//}

fun main() {
    val ruleCodePath = Path.of(
        {}.javaClass.classLoader.getResource(
            "rulecode/example.rulecode"
        )!!.toURI()
    ).toString()

    val generator = AntlrRuletreeGenerator()
    val environment = RuletreeEnvironment(generator)

    // TODO: error listener!
    val ruletree = environment.loadFile(ruleCodePath)

    println(ruletree)
}
