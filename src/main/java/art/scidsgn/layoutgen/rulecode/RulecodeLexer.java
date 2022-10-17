package art.scidsgn.layoutgen.rulecode;

// Generated from java-escape by ANTLR 4.11.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RulecodeLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            NUMBER = 1, HEXCOLOR = 2, STRING = 3, TRUE = 4, FALSE = 5, IMPORT_KEYWORD = 6, AS_KEYWORD = 7,
            BUILTIN_ID = 8, ANNOTATION_ID = 9, VARIABLE_ID = 10, ID = 11, IS_EQUALS = 12, ARROW = 13,
            EQUALS = 14, COMMA = 15, SEMI = 16, BAR = 17, DOT = 18, LPAREN = 19, RPAREN = 20, LBRACKET = 21,
            RBRACKET = 22, LBRACE = 23, RBRACE = 24, WS = 25;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "NUMBER", "HEXCOLOR", "STRING", "TRUE", "FALSE", "IMPORT_KEYWORD", "AS_KEYWORD",
                "BUILTIN_ID", "ANNOTATION_ID", "VARIABLE_ID", "ID", "IS_EQUALS", "ARROW",
                "EQUALS", "COMMA", "SEMI", "BAR", "DOT", "LPAREN", "RPAREN", "LBRACKET",
                "RBRACKET", "LBRACE", "RBRACE", "WS"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, "'true'", "'false'", "'import'", "'as'", null,
                null, null, null, "':='", "'->'", "'='", "','", "';'", "'|'", "'.'",
                "'('", "')'", "'['", "']'", "'{'", "'}'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "NUMBER", "HEXCOLOR", "STRING", "TRUE", "FALSE", "IMPORT_KEYWORD",
                "AS_KEYWORD", "BUILTIN_ID", "ANNOTATION_ID", "VARIABLE_ID", "ID", "IS_EQUALS",
                "ARROW", "EQUALS", "COMMA", "SEMI", "BAR", "DOT", "LPAREN", "RPAREN",
                "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "WS"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }


    public RulecodeLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "Rulecode.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\u0004\u0000\u0019\u009c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
                    "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
                    "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
                    "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
                    "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
                    "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011" +
                    "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014" +
                    "\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017" +
                    "\u0002\u0018\u0007\u0018\u0001\u0000\u0003\u00005\b\u0000\u0001\u0000" +
                    "\u0004\u00008\b\u0000\u000b\u0000\f\u00009\u0001\u0000\u0001\u0000\u0004" +
                    "\u0000>\b\u0000\u000b\u0000\f\u0000?\u0003\u0000B\b\u0000\u0001\u0001" +
                    "\u0001\u0001\u0004\u0001F\b\u0001\u000b\u0001\f\u0001G\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0005\u0002N\b\u0002\n\u0002\f\u0002Q\t" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001" +
                    "\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t" +
                    "\u0001\t\u0001\n\u0001\n\u0005\nu\b\n\n\n\f\nx\t\n\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001" +
                    "\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001" +
                    "\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001" +
                    "\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001" +
                    "\u0017\u0001\u0018\u0004\u0018\u0097\b\u0018\u000b\u0018\f\u0018\u0098" +
                    "\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005" +
                    "\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n" +
                    "\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011" +
                    "#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000" +
                    "\u0007\u0001\u000009\u0003\u000009AFaf\u0004\u0000\n\n\r\r\"\"\\\\\u0002" +
                    "\u0000\"\"\\\\\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n\f\r" +
                    "  \u00a4\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000" +
                    "\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000" +
                    "\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000" +
                    "\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000" +
                    "\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000" +
                    "\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000" +
                    "\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000" +
                    "\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000" +
                    "!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001" +
                    "\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000" +
                    "\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000" +
                    "\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00014" +
                    "\u0001\u0000\u0000\u0000\u0003C\u0001\u0000\u0000\u0000\u0005I\u0001\u0000" +
                    "\u0000\u0000\u0007T\u0001\u0000\u0000\u0000\tY\u0001\u0000\u0000\u0000" +
                    "\u000b_\u0001\u0000\u0000\u0000\rf\u0001\u0000\u0000\u0000\u000fi\u0001" +
                    "\u0000\u0000\u0000\u0011l\u0001\u0000\u0000\u0000\u0013o\u0001\u0000\u0000" +
                    "\u0000\u0015r\u0001\u0000\u0000\u0000\u0017y\u0001\u0000\u0000\u0000\u0019" +
                    "|\u0001\u0000\u0000\u0000\u001b\u007f\u0001\u0000\u0000\u0000\u001d\u0081" +
                    "\u0001\u0000\u0000\u0000\u001f\u0083\u0001\u0000\u0000\u0000!\u0085\u0001" +
                    "\u0000\u0000\u0000#\u0087\u0001\u0000\u0000\u0000%\u0089\u0001\u0000\u0000" +
                    "\u0000\'\u008b\u0001\u0000\u0000\u0000)\u008d\u0001\u0000\u0000\u0000" +
                    "+\u008f\u0001\u0000\u0000\u0000-\u0091\u0001\u0000\u0000\u0000/\u0093" +
                    "\u0001\u0000\u0000\u00001\u0096\u0001\u0000\u0000\u000035\u0005-\u0000" +
                    "\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000" +
                    "\u0000\u000068\u0007\u0000\u0000\u000076\u0001\u0000\u0000\u000089\u0001" +
                    "\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000" +
                    ":A\u0001\u0000\u0000\u0000;=\u0005.\u0000\u0000<>\u0007\u0000\u0000\u0000" +
                    "=<\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000" +
                    "\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A;\u0001\u0000" +
                    "\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0002\u0001\u0000\u0000\u0000" +
                    "CE\u0005#\u0000\u0000DF\u0007\u0001\u0000\u0000ED\u0001\u0000\u0000\u0000" +
                    "FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000" +
                    "\u0000H\u0004\u0001\u0000\u0000\u0000IO\u0005\"\u0000\u0000JN\b\u0002" +
                    "\u0000\u0000KL\u0005\\\u0000\u0000LN\u0007\u0003\u0000\u0000MJ\u0001\u0000" +
                    "\u0000\u0000MK\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001" +
                    "\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000" +
                    "QO\u0001\u0000\u0000\u0000RS\u0005\"\u0000\u0000S\u0006\u0001\u0000\u0000" +
                    "\u0000TU\u0005t\u0000\u0000UV\u0005r\u0000\u0000VW\u0005u\u0000\u0000" +
                    "WX\u0005e\u0000\u0000X\b\u0001\u0000\u0000\u0000YZ\u0005f\u0000\u0000" +
                    "Z[\u0005a\u0000\u0000[\\\u0005l\u0000\u0000\\]\u0005s\u0000\u0000]^\u0005" +
                    "e\u0000\u0000^\n\u0001\u0000\u0000\u0000_`\u0005i\u0000\u0000`a\u0005" +
                    "m\u0000\u0000ab\u0005p\u0000\u0000bc\u0005o\u0000\u0000cd\u0005r\u0000" +
                    "\u0000de\u0005t\u0000\u0000e\f\u0001\u0000\u0000\u0000fg\u0005a\u0000" +
                    "\u0000gh\u0005s\u0000\u0000h\u000e\u0001\u0000\u0000\u0000ij\u0005$\u0000" +
                    "\u0000jk\u0003\u0015\n\u0000k\u0010\u0001\u0000\u0000\u0000lm\u0005@\u0000" +
                    "\u0000mn\u0003\u0015\n\u0000n\u0012\u0001\u0000\u0000\u0000op\u0005_\u0000" +
                    "\u0000pq\u0003\u0015\n\u0000q\u0014\u0001\u0000\u0000\u0000rv\u0007\u0004" +
                    "\u0000\u0000su\u0007\u0005\u0000\u0000ts\u0001\u0000\u0000\u0000ux\u0001" +
                    "\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000" +
                    "w\u0016\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000yz\u0005:\u0000" +
                    "\u0000z{\u0005=\u0000\u0000{\u0018\u0001\u0000\u0000\u0000|}\u0005-\u0000" +
                    "\u0000}~\u0005>\u0000\u0000~\u001a\u0001\u0000\u0000\u0000\u007f\u0080" +
                    "\u0005=\u0000\u0000\u0080\u001c\u0001\u0000\u0000\u0000\u0081\u0082\u0005" +
                    ",\u0000\u0000\u0082\u001e\u0001\u0000\u0000\u0000\u0083\u0084\u0005;\u0000" +
                    "\u0000\u0084 \u0001\u0000\u0000\u0000\u0085\u0086\u0005|\u0000\u0000\u0086" +
                    "\"\u0001\u0000\u0000\u0000\u0087\u0088\u0005.\u0000\u0000\u0088$\u0001" +
                    "\u0000\u0000\u0000\u0089\u008a\u0005(\u0000\u0000\u008a&\u0001\u0000\u0000" +
                    "\u0000\u008b\u008c\u0005)\u0000\u0000\u008c(\u0001\u0000\u0000\u0000\u008d" +
                    "\u008e\u0005[\u0000\u0000\u008e*\u0001\u0000\u0000\u0000\u008f\u0090\u0005" +
                    "]\u0000\u0000\u0090,\u0001\u0000\u0000\u0000\u0091\u0092\u0005{\u0000" +
                    "\u0000\u0092.\u0001\u0000\u0000\u0000\u0093\u0094\u0005}\u0000\u0000\u0094" +
                    "0\u0001\u0000\u0000\u0000\u0095\u0097\u0007\u0006\u0000\u0000\u0096\u0095" +
                    "\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0096" +
                    "\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a" +
                    "\u0001\u0000\u0000\u0000\u009a\u009b\u0006\u0018\u0000\u0000\u009b2\u0001" +
                    "\u0000\u0000\u0000\n\u000049?AGMOv\u0098\u0001\u0006\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}