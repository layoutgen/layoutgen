package demos

import art.scidsgn.layoutgen.interpreter.Interpreter
import art.scidsgn.layoutgen.layout.components.Component
import art.scidsgn.layoutgen.ruletree.RuletreeEnvironment
import art.scidsgn.layoutgen.ruletree.depsgraph.Depsgraph
import art.scidsgn.layoutgen.ruletree.parsers.antlr.AntlrRuletreeGenerator
import demos.visual.VisualDemoBase
import java.nio.file.Path

fun main() {
    try {
        val ruleCodePath = Path.of(
            {}.javaClass.classLoader.getResource(
                "rulecode/text.rulecode"
            )!!.toURI()
        ).toString()

        val environment = RuletreeEnvironment(AntlrRuletreeGenerator)

        val ruletree = environment.loadFile(ruleCodePath)
        val resultRule = ruletree.getIsRule("Main")
        val interpreter = Interpreter()

        val depsgraph = Depsgraph(environment)
        depsgraph.markCycles(resultRule)

        val output = interpreter.execute(resultRule)

        if (output is List<*> && output.all { it is Component }) {
            VisualDemoBase.runDemoOf(output[0] as Component, "test")
        }
    } catch (e: Throwable) {
        System.err.println(e.message)
    }
}
