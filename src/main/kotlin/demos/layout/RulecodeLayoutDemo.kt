package demos.layout

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.interpreter.Interpreter
import art.scidsgn.layoutgen.ruletree.RuletreeEnvironment
import art.scidsgn.layoutgen.ruletree.parsers.antlr.AntlrRuletreeGenerator
import java.nio.file.Path

fun main() {
    try {
        val ruleCodePath = Path.of(
            {}.javaClass.classLoader.getResource(
                "rulecode/layouttest.rulecode"
            )!!.toURI()
        ).toString()

        val environment = RuletreeEnvironment(AntlrRuletreeGenerator)

        val ruletree = environment.loadFile(ruleCodePath)
        val resultRule = ruletree.getIsRule("Main")
        val interpreter = Interpreter()
        val output = interpreter.execute(resultRule)

        if (output.all { it is Component }) {
            LayoutDemoBase.runDemoOf(output[0] as Component, "test")
        }
    } catch (e: Throwable) {
        System.err.println(e.message)
    }
}
