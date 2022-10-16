package demos

import art.scidsgn.layoutgen.rulecode.RulecodeBaseListener
import art.scidsgn.layoutgen.rulecode.RulecodeLexer
import art.scidsgn.layoutgen.rulecode.RulecodeParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker

object DemoListener : RulecodeBaseListener() {
    override fun enterIsRule(ctx: RulecodeParser.IsRuleContext?) {
        println("Is-rule found!")
    }
}

fun main() {
    val ruleCode = "Test := A B C | Xyz"

    val lexer = RulecodeLexer(CharStreams.fromString(ruleCode))
    val tokens = CommonTokenStream(lexer)
    val parser = RulecodeParser(tokens)
    val walker = ParseTreeWalker()

    walker.walk(DemoListener, parser.program())
}