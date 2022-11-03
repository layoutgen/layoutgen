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
            NUMBER = 1, HEXCOLOR = 2, STRING = 3, TRUE = 4, FALSE = 5, IMPORT_KEYWORD = 6, USE_KEYWORD = 7,
            AS_KEYWORD = 8, BUILTIN_ID = 9, ANNOTATION_ID = 10, VARIABLE_ID = 11, ID = 12, IS_EQUALS = 13,
            ARROW = 14, EQUALS = 15, COMMA = 16, SEMI = 17, BAR = 18, DOT = 19, LPAREN = 20, RPAREN = 21,
            LBRACKET = 22, RBRACKET = 23, LBRACE = 24, RBRACE = 25, WS = 26;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "NUMBER", "HEXCOLOR", "STRING", "TRUE", "FALSE", "IMPORT_KEYWORD", "USE_KEYWORD",
                "AS_KEYWORD", "BUILTIN_ID", "ANNOTATION_ID", "VARIABLE_ID", "ID", "IS_EQUALS",
                "ARROW", "EQUALS", "COMMA", "SEMI", "BAR", "DOT", "LPAREN", "RPAREN",
                "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "WS"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, "'true'", "'false'", "'import'", "'use'", "'as'",
                null, null, null, null, "':='", "'->'", "'='", "','", "';'", "'|'", "'.'",
                "'('", "')'", "'['", "']'", "'{'", "'}'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "NUMBER", "HEXCOLOR", "STRING", "TRUE", "FALSE", "IMPORT_KEYWORD",
                "USE_KEYWORD", "AS_KEYWORD", "BUILTIN_ID", "ANNOTATION_ID", "VARIABLE_ID",
                "ID", "IS_EQUALS", "ARROW", "EQUALS", "COMMA", "SEMI", "BAR", "DOT",
                "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "WS"
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
            "\u0004\u0000\u001a\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
                    "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
                    "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
                    "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
                    "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
                    "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011" +
                    "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014" +
                    "\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017" +
                    "\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0003\u0000" +
                    "7\b\u0000\u0001\u0000\u0004\u0000:\b\u0000\u000b\u0000\f\u0000;\u0001" +
                    "\u0000\u0001\u0000\u0004\u0000@\b\u0000\u000b\u0000\f\u0000A\u0003\u0000" +
                    "D\b\u0000\u0001\u0001\u0001\u0001\u0004\u0001H\b\u0001\u000b\u0001\f\u0001" +
                    "I\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002P\b\u0002" +
                    "\n\u0002\f\u0002S\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001" +
                    "\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b" +
                    "\u0001\u000b\u0005\u000b{\b\u000b\n\u000b\f\u000b~\t\u000b\u0001\f\u0001" +
                    "\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f" +
                    "\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012" +
                    "\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015" +
                    "\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018" +
                    "\u0001\u0018\u0001\u0019\u0004\u0019\u009d\b\u0019\u000b\u0019\f\u0019" +
                    "\u009e\u0001\u0019\u0001\u0019\u0000\u0000\u001a\u0001\u0001\u0003\u0002" +
                    "\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013" +
                    "\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011" +
                    "#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a\u0001" +
                    "\u0000\u0007\u0001\u000009\u0003\u000009AFaf\u0004\u0000\n\n\r\r\"\"\\" +
                    "\\\u0002\u0000\"\"\\\\\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000" +
                    "\t\n\f\r  \u00aa\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001" +
                    "\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001" +
                    "\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000" +
                    "\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000" +
                    "\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000" +
                    "\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000" +
                    "\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000" +
                    "\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000" +
                    "\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000" +
                    "%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001" +
                    "\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000" +
                    "\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000" +
                    "3\u0001\u0000\u0000\u0000\u00016\u0001\u0000\u0000\u0000\u0003E\u0001" +
                    "\u0000\u0000\u0000\u0005K\u0001\u0000\u0000\u0000\u0007V\u0001\u0000\u0000" +
                    "\u0000\t[\u0001\u0000\u0000\u0000\u000ba\u0001\u0000\u0000\u0000\rh\u0001" +
                    "\u0000\u0000\u0000\u000fl\u0001\u0000\u0000\u0000\u0011o\u0001\u0000\u0000" +
                    "\u0000\u0013r\u0001\u0000\u0000\u0000\u0015u\u0001\u0000\u0000\u0000\u0017" +
                    "x\u0001\u0000\u0000\u0000\u0019\u007f\u0001\u0000\u0000\u0000\u001b\u0082" +
                    "\u0001\u0000\u0000\u0000\u001d\u0085\u0001\u0000\u0000\u0000\u001f\u0087" +
                    "\u0001\u0000\u0000\u0000!\u0089\u0001\u0000\u0000\u0000#\u008b\u0001\u0000" +
                    "\u0000\u0000%\u008d\u0001\u0000\u0000\u0000\'\u008f\u0001\u0000\u0000" +
                    "\u0000)\u0091\u0001\u0000\u0000\u0000+\u0093\u0001\u0000\u0000\u0000-" +
                    "\u0095\u0001\u0000\u0000\u0000/\u0097\u0001\u0000\u0000\u00001\u0099\u0001" +
                    "\u0000\u0000\u00003\u009c\u0001\u0000\u0000\u000057\u0005-\u0000\u0000" +
                    "65\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000" +
                    "\u00008:\u0007\u0000\u0000\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000" +
                    "\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<C\u0001" +
                    "\u0000\u0000\u0000=?\u0005.\u0000\u0000>@\u0007\u0000\u0000\u0000?>\u0001" +
                    "\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000" +
                    "AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000C=\u0001\u0000\u0000" +
                    "\u0000CD\u0001\u0000\u0000\u0000D\u0002\u0001\u0000\u0000\u0000EG\u0005" +
                    "#\u0000\u0000FH\u0007\u0001\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001" +
                    "\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000" +
                    "J\u0004\u0001\u0000\u0000\u0000KQ\u0005\"\u0000\u0000LP\b\u0002\u0000" +
                    "\u0000MN\u0005\\\u0000\u0000NP\u0007\u0003\u0000\u0000OL\u0001\u0000\u0000" +
                    "\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000" +
                    "\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001" +
                    "\u0000\u0000\u0000TU\u0005\"\u0000\u0000U\u0006\u0001\u0000\u0000\u0000" +
                    "VW\u0005t\u0000\u0000WX\u0005r\u0000\u0000XY\u0005u\u0000\u0000YZ\u0005" +
                    "e\u0000\u0000Z\b\u0001\u0000\u0000\u0000[\\\u0005f\u0000\u0000\\]\u0005" +
                    "a\u0000\u0000]^\u0005l\u0000\u0000^_\u0005s\u0000\u0000_`\u0005e\u0000" +
                    "\u0000`\n\u0001\u0000\u0000\u0000ab\u0005i\u0000\u0000bc\u0005m\u0000" +
                    "\u0000cd\u0005p\u0000\u0000de\u0005o\u0000\u0000ef\u0005r\u0000\u0000" +
                    "fg\u0005t\u0000\u0000g\f\u0001\u0000\u0000\u0000hi\u0005u\u0000\u0000" +
                    "ij\u0005s\u0000\u0000jk\u0005e\u0000\u0000k\u000e\u0001\u0000\u0000\u0000" +
                    "lm\u0005a\u0000\u0000mn\u0005s\u0000\u0000n\u0010\u0001\u0000\u0000\u0000" +
                    "op\u0005$\u0000\u0000pq\u0003\u0017\u000b\u0000q\u0012\u0001\u0000\u0000" +
                    "\u0000rs\u0005@\u0000\u0000st\u0003\u0017\u000b\u0000t\u0014\u0001\u0000" +
                    "\u0000\u0000uv\u0005_\u0000\u0000vw\u0003\u0017\u000b\u0000w\u0016\u0001" +
                    "\u0000\u0000\u0000x|\u0007\u0004\u0000\u0000y{\u0007\u0005\u0000\u0000" +
                    "zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000" +
                    "\u0000|}\u0001\u0000\u0000\u0000}\u0018\u0001\u0000\u0000\u0000~|\u0001" +
                    "\u0000\u0000\u0000\u007f\u0080\u0005:\u0000\u0000\u0080\u0081\u0005=\u0000" +
                    "\u0000\u0081\u001a\u0001\u0000\u0000\u0000\u0082\u0083\u0005-\u0000\u0000" +
                    "\u0083\u0084\u0005>\u0000\u0000\u0084\u001c\u0001\u0000\u0000\u0000\u0085" +
                    "\u0086\u0005=\u0000\u0000\u0086\u001e\u0001\u0000\u0000\u0000\u0087\u0088" +
                    "\u0005,\u0000\u0000\u0088 \u0001\u0000\u0000\u0000\u0089\u008a\u0005;" +
                    "\u0000\u0000\u008a\"\u0001\u0000\u0000\u0000\u008b\u008c\u0005|\u0000" +
                    "\u0000\u008c$\u0001\u0000\u0000\u0000\u008d\u008e\u0005.\u0000\u0000\u008e" +
                    "&\u0001\u0000\u0000\u0000\u008f\u0090\u0005(\u0000\u0000\u0090(\u0001" +
                    "\u0000\u0000\u0000\u0091\u0092\u0005)\u0000\u0000\u0092*\u0001\u0000\u0000" +
                    "\u0000\u0093\u0094\u0005[\u0000\u0000\u0094,\u0001\u0000\u0000\u0000\u0095" +
                    "\u0096\u0005]\u0000\u0000\u0096.\u0001\u0000\u0000\u0000\u0097\u0098\u0005" +
                    "{\u0000\u0000\u00980\u0001\u0000\u0000\u0000\u0099\u009a\u0005}\u0000" +
                    "\u0000\u009a2\u0001\u0000\u0000\u0000\u009b\u009d\u0007\u0006\u0000\u0000" +
                    "\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000" +
                    "\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000" +
                    "\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006\u0019\u0000\u0000" +
                    "\u00a14\u0001\u0000\u0000\u0000\n\u00006;ACIOQ|\u009e\u0001\u0006\u0000" +
                    "\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}