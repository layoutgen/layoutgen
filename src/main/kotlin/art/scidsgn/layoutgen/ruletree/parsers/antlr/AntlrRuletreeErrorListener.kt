package art.scidsgn.layoutgen.ruletree.parsers.antlr

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.io.CodePosition
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.util.*

class AntlrRuletreeErrorListener(val ruleTree: Ruletree) : ANTLRErrorListener {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?
    ) {
        throw InFileError(Errors.ANTLR_SYNTAX_ERROR, arrayOf(msg!!), CodePosition(ruleTree.sourceFile, line, charPositionInLine))
    }

    override fun reportAmbiguity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        exact: Boolean,
        ambigAlts: BitSet?,
        configs: ATNConfigSet?
    ) {
        TODO("Not yet implemented")
    }

    override fun reportAttemptingFullContext(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        conflictingAlts: BitSet?,
        configs: ATNConfigSet?
    ) {
        TODO("Not yet implemented")
    }

    override fun reportContextSensitivity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        prediction: Int,
        configs: ATNConfigSet?
    ) {
        TODO("Not yet implemented")
    }
}