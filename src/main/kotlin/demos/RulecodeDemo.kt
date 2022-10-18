package demos

import art.scidsgn.layoutgen.interpreter.Interpreter
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
            "rulecode/mathtest.rulecode"
        )!!.toURI()
    ).toString()

    val generator = AntlrRuletreeGenerator()
    val environment = RuletreeEnvironment(generator)

    // TODO: error listener!
    val ruletree = environment.loadFile(ruleCodePath)
    val resultRule = ruletree.getIsRule("Result")

    val interpreter = Interpreter()

    val output = interpreter.execute(resultRule)

    println(output as List<Double>)
}
