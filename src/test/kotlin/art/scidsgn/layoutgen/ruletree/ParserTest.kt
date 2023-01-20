package art.scidsgn.layoutgen.ruletree

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.interpreter.Interpreter
import art.scidsgn.layoutgen.ruletree.depsgraph.Depsgraph
import art.scidsgn.layoutgen.ruletree.parsers.antlr.AntlrRuletreeGenerator
import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.nio.file.Path
import java.util.Objects
import kotlin.streams.toList
import kotlin.test.assertEquals

class ParserTest {

    @ParameterizedTest
    @MethodSource("errorsTestParams")
    fun shouldThrowCorrectError(sourceFile: String, expectedError: Errors) {
        try {
            runRulecode(sourceFile)
            fail("Exception was not thrown")
        } catch(e: GeneralError) {
            assertEquals(expectedError, e.errorType)
        } catch(e: InFileError) {
            assertEquals(expectedError, (e.cause as GeneralError).errorType)
        }
    }

    private fun runRulecode(sourceFile: String) {
        val environment = RuletreeEnvironment(AntlrRuletreeGenerator)

        val ruletree = environment.loadFile(sourceFile)
        val resultRule = ruletree.getRootRule()
        val interpreter = Interpreter()

        val depsgraph = Depsgraph(environment)
        depsgraph.markCycles(resultRule)

        interpreter.execute(resultRule)
    }

    companion object {
        @JvmStatic
        fun errorsTestParams(): List<Arguments?> {
            val allErrors = Errors.values()

            return allErrors.toList().stream().map { error ->
                val resource = {}.javaClass.classLoader.getResource(
                    "tests/parser/${error.name}.rulecode"
                ) ?: return@map null
                val ruleCodePath = Path.of(resource.toURI()).toString()

                Arguments.of(ruleCodePath, error)
            }.filter(Objects::nonNull).toList()
        }
    }
}