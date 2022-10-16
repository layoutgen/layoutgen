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
            NUMBER = 1, HEXCOLOR = 2, STRING = 3, BUILTIN = 4, ANNOTATION = 5, VARIABLE = 6, ID = 7,
            IS_EQUALS = 8, ARROW = 9, EQUALS = 10, COMMA = 11, SEMI = 12, BAR = 13, DOT = 14, LPAREN = 15,
            RPAREN = 16, LBRACKET = 17, RBRACKET = 18, LBRACE = 19, RBRACE = 20, WS = 21;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "NUMBER", "HEXCOLOR", "STRING", "BUILTIN", "ANNOTATION", "VARIABLE",
                "ID", "IS_EQUALS", "ARROW", "EQUALS", "COMMA", "SEMI", "BAR", "DOT",
                "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "WS"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, "':='", "'->'", "'='",
                "','", "';'", "'|'", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "NUMBER", "HEXCOLOR", "STRING", "BUILTIN", "ANNOTATION", "VARIABLE",
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
            "\u0004\u0000\u0015\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
                    "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
                    "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
                    "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
                    "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
                    "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011" +
                    "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014" +
                    "\u0001\u0000\u0003\u0000-\b\u0000\u0001\u0000\u0004\u00000\b\u0000\u000b" +
                    "\u0000\f\u00001\u0001\u0000\u0001\u0000\u0004\u00006\b\u0000\u000b\u0000" +
                    "\f\u00007\u0003\u0000:\b\u0000\u0001\u0001\u0001\u0001\u0004\u0001>\b" +
                    "\u0001\u000b\u0001\f\u0001?\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0005\u0002F\b\u0002\n\u0002\f\u0002I\t\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005" +
                    "\u0006X\b\u0006\n\u0006\f\u0006[\t\u0006\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b" +
                    "\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001" +
                    "\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001" +
                    "\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0004\u0014z\b" +
                    "\u0014\u000b\u0014\f\u0014{\u0001\u0014\u0001\u0014\u0000\u0000\u0015" +
                    "\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r" +
                    "\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e" +
                    "\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000" +
                    "\u0007\u0001\u000009\u0003\u000009AFaf\u0004\u0000\n\n\r\r\"\"\\\\\u0002" +
                    "\u0000\"\"\\\\\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n\f\r" +
                    "  \u0087\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000" +
                    "\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000" +
                    "\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000" +
                    "\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000" +
                    "\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000" +
                    "\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000" +
                    "\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000" +
                    "\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000" +
                    "!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001" +
                    "\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000" +
                    "\u0000\u0000\u0001,\u0001\u0000\u0000\u0000\u0003;\u0001\u0000\u0000\u0000" +
                    "\u0005A\u0001\u0000\u0000\u0000\u0007L\u0001\u0000\u0000\u0000\tO\u0001" +
                    "\u0000\u0000\u0000\u000bR\u0001\u0000\u0000\u0000\rU\u0001\u0000\u0000" +
                    "\u0000\u000f\\\u0001\u0000\u0000\u0000\u0011_\u0001\u0000\u0000\u0000" +
                    "\u0013b\u0001\u0000\u0000\u0000\u0015d\u0001\u0000\u0000\u0000\u0017f" +
                    "\u0001\u0000\u0000\u0000\u0019h\u0001\u0000\u0000\u0000\u001bj\u0001\u0000" +
                    "\u0000\u0000\u001dl\u0001\u0000\u0000\u0000\u001fn\u0001\u0000\u0000\u0000" +
                    "!p\u0001\u0000\u0000\u0000#r\u0001\u0000\u0000\u0000%t\u0001\u0000\u0000" +
                    "\u0000\'v\u0001\u0000\u0000\u0000)y\u0001\u0000\u0000\u0000+-\u0005-\u0000" +
                    "\u0000,+\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-/\u0001\u0000" +
                    "\u0000\u0000.0\u0007\u0000\u0000\u0000/.\u0001\u0000\u0000\u000001\u0001" +
                    "\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000" +
                    "29\u0001\u0000\u0000\u000035\u0005.\u0000\u000046\u0007\u0000\u0000\u0000" +
                    "54\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000" +
                    "\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u000093\u0001\u0000" +
                    "\u0000\u00009:\u0001\u0000\u0000\u0000:\u0002\u0001\u0000\u0000\u0000" +
                    ";=\u0005#\u0000\u0000<>\u0007\u0001\u0000\u0000=<\u0001\u0000\u0000\u0000" +
                    ">?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000" +
                    "\u0000@\u0004\u0001\u0000\u0000\u0000AG\u0005\"\u0000\u0000BF\b\u0002" +
                    "\u0000\u0000CD\u0005\\\u0000\u0000DF\u0007\u0003\u0000\u0000EB\u0001\u0000" +
                    "\u0000\u0000EC\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001" +
                    "\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000" +
                    "IG\u0001\u0000\u0000\u0000JK\u0005\"\u0000\u0000K\u0006\u0001\u0000\u0000" +
                    "\u0000LM\u0005$\u0000\u0000MN\u0003\r\u0006\u0000N\b\u0001\u0000\u0000" +
                    "\u0000OP\u0005@\u0000\u0000PQ\u0003\r\u0006\u0000Q\n\u0001\u0000\u0000" +
                    "\u0000RS\u0005_\u0000\u0000ST\u0003\r\u0006\u0000T\f\u0001\u0000\u0000" +
                    "\u0000UY\u0007\u0004\u0000\u0000VX\u0007\u0005\u0000\u0000WV\u0001\u0000" +
                    "\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001" +
                    "\u0000\u0000\u0000Z\u000e\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000" +
                    "\u0000\\]\u0005:\u0000\u0000]^\u0005=\u0000\u0000^\u0010\u0001\u0000\u0000" +
                    "\u0000_`\u0005-\u0000\u0000`a\u0005>\u0000\u0000a\u0012\u0001\u0000\u0000" +
                    "\u0000bc\u0005=\u0000\u0000c\u0014\u0001\u0000\u0000\u0000de\u0005,\u0000" +
                    "\u0000e\u0016\u0001\u0000\u0000\u0000fg\u0005;\u0000\u0000g\u0018\u0001" +
                    "\u0000\u0000\u0000hi\u0005|\u0000\u0000i\u001a\u0001\u0000\u0000\u0000" +
                    "jk\u0005.\u0000\u0000k\u001c\u0001\u0000\u0000\u0000lm\u0005(\u0000\u0000" +
                    "m\u001e\u0001\u0000\u0000\u0000no\u0005)\u0000\u0000o \u0001\u0000\u0000" +
                    "\u0000pq\u0005[\u0000\u0000q\"\u0001\u0000\u0000\u0000rs\u0005]\u0000" +
                    "\u0000s$\u0001\u0000\u0000\u0000tu\u0005{\u0000\u0000u&\u0001\u0000\u0000" +
                    "\u0000vw\u0005}\u0000\u0000w(\u0001\u0000\u0000\u0000xz\u0007\u0006\u0000" +
                    "\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000" +
                    "\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0006" +
                    "\u0014\u0000\u0000~*\u0001\u0000\u0000\u0000\n\u0000,179?EGY{\u0001\u0006" +
                    "\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}