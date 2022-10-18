package art.scidsgn.layoutgen.rulecode;

// Generated from java-escape by ANTLR 4.11.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RulecodeParser extends Parser {
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
    public static final int
            RULE_program = 0, RULE_importStatement = 1, RULE_isRule = 2, RULE_isBranch = 3,
            RULE_isVars = 4, RULE_rewriteRule = 5, RULE_rewriteBranch = 6, RULE_builtinFn = 7,
            RULE_fnCallArgs = 8, RULE_fnCallArg = 9, RULE_fnCallBody = 10, RULE_ruleFn = 11,
            RULE_ruleCallArgs = 12, RULE_ruleCallArg = 13, RULE_element = 14, RULE_branchWeight = 15,
            RULE_branchSep = 16, RULE_moduleRuleName = 17, RULE_ruleName = 18, RULE_annotationName = 19,
            RULE_builtinName = 20, RULE_variableName = 21, RULE_number = 22, RULE_color = 23,
            RULE_string = 24, RULE_boolean = 25;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "importStatement", "isRule", "isBranch", "isVars", "rewriteRule",
                "rewriteBranch", "builtinFn", "fnCallArgs", "fnCallArg", "fnCallBody",
                "ruleFn", "ruleCallArgs", "ruleCallArg", "element", "branchWeight", "branchSep",
                "moduleRuleName", "ruleName", "annotationName", "builtinName", "variableName",
                "number", "color", "string", "boolean"
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

    @Override
    public String getGrammarFileName() {
        return "java-escape";
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
    public ATN getATN() {
        return _ATN;
    }

    public RulecodeParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ProgramContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(RulecodeParser.EOF, 0);
        }

        public List<ImportStatementContext> importStatement() {
            return getRuleContexts(ImportStatementContext.class);
        }

        public ImportStatementContext importStatement(int i) {
            return getRuleContext(ImportStatementContext.class, i);
        }

        public List<IsRuleContext> isRule() {
            return getRuleContexts(IsRuleContext.class);
        }

        public IsRuleContext isRule(int i) {
            return getRuleContext(IsRuleContext.class, i);
        }

        public List<RewriteRuleContext> rewriteRule() {
            return getRuleContexts(RewriteRuleContext.class);
        }

        public RewriteRuleContext rewriteRule(int i) {
            return getRuleContext(RewriteRuleContext.class, i);
        }

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitProgram(this);
        }
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(55);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        setState(55);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                            case 1: {
                                setState(52);
                                importStatement();
                            }
                            break;
                            case 2: {
                                setState(53);
                                isRule();
                            }
                            break;
                            case 3: {
                                setState(54);
                                rewriteRule();
                            }
                            break;
                        }
                    }
                    setState(57);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2624L) != 0);
                setState(59);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ImportStatementContext extends ParserRuleContext {
        public TerminalNode IMPORT_KEYWORD() {
            return getToken(RulecodeParser.IMPORT_KEYWORD, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public TerminalNode AS_KEYWORD() {
            return getToken(RulecodeParser.AS_KEYWORD, 0);
        }

        public RuleNameContext ruleName() {
            return getRuleContext(RuleNameContext.class, 0);
        }

        public ImportStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_importStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterImportStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitImportStatement(this);
        }
    }

    public final ImportStatementContext importStatement() throws RecognitionException {
        ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_importStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(61);
                match(IMPORT_KEYWORD);
                setState(62);
                string();
                setState(63);
                match(AS_KEYWORD);
                setState(64);
                ruleName();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IsRuleContext extends ParserRuleContext {
        public RuleNameContext ruleName() {
            return getRuleContext(RuleNameContext.class, 0);
        }

        public TerminalNode IS_EQUALS() {
            return getToken(RulecodeParser.IS_EQUALS, 0);
        }

        public List<IsBranchContext> isBranch() {
            return getRuleContexts(IsBranchContext.class);
        }

        public IsBranchContext isBranch(int i) {
            return getRuleContext(IsBranchContext.class, i);
        }

        public List<AnnotationNameContext> annotationName() {
            return getRuleContexts(AnnotationNameContext.class);
        }

        public AnnotationNameContext annotationName(int i) {
            return getRuleContext(AnnotationNameContext.class, i);
        }

        public IsVarsContext isVars() {
            return getRuleContext(IsVarsContext.class, 0);
        }

        public List<BranchSepContext> branchSep() {
            return getRuleContexts(BranchSepContext.class);
        }

        public BranchSepContext branchSep(int i) {
            return getRuleContext(BranchSepContext.class, i);
        }

        public IsRuleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_isRule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterIsRule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitIsRule(this);
        }
    }

    public final IsRuleContext isRule() throws RecognitionException {
        IsRuleContext _localctx = new IsRuleContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_isRule);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(69);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ANNOTATION_ID) {
                    {
                        {
                            setState(66);
                            annotationName();
                        }
                    }
                    setState(71);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(72);
                ruleName();
                setState(74);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(73);
                        isVars();
                    }
                }

                setState(76);
                match(IS_EQUALS);
                setState(77);
                isBranch();
                setState(83);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == BAR) {
                    {
                        {
                            setState(78);
                            branchSep();
                            setState(79);
                            isBranch();
                        }
                    }
                    setState(85);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IsBranchContext extends ParserRuleContext {
        public BranchWeightContext branchWeight() {
            return getRuleContext(BranchWeightContext.class, 0);
        }

        public List<ElementContext> element() {
            return getRuleContexts(ElementContext.class);
        }

        public ElementContext element(int i) {
            return getRuleContext(ElementContext.class, i);
        }

        public IsBranchContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_isBranch;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterIsBranch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitIsBranch(this);
        }
    }

    public final IsBranchContext isBranch() throws RecognitionException {
        IsBranchContext _localctx = new IsBranchContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_isBranch);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(86);
                        branchWeight();
                    }
                }

                setState(90);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(89);
                                element();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(92);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IsVarsContext extends ParserRuleContext {
        public TerminalNode LPAREN() {
            return getToken(RulecodeParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(RulecodeParser.RPAREN, 0);
        }

        public List<VariableNameContext> variableName() {
            return getRuleContexts(VariableNameContext.class);
        }

        public VariableNameContext variableName(int i) {
            return getRuleContext(VariableNameContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(RulecodeParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(RulecodeParser.COMMA, i);
        }

        public IsVarsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_isVars;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterIsVars(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitIsVars(this);
        }
    }

    public final IsVarsContext isVars() throws RecognitionException {
        IsVarsContext _localctx = new IsVarsContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_isVars);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(94);
                match(LPAREN);
                setState(103);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == VARIABLE_ID) {
                    {
                        setState(95);
                        variableName();
                        setState(100);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(96);
                                    match(COMMA);
                                    setState(97);
                                    variableName();
                                }
                            }
                            setState(102);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(105);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RewriteRuleContext extends ParserRuleContext {
        public RuleNameContext ruleName() {
            return getRuleContext(RuleNameContext.class, 0);
        }

        public TerminalNode ARROW() {
            return getToken(RulecodeParser.ARROW, 0);
        }

        public List<RewriteBranchContext> rewriteBranch() {
            return getRuleContexts(RewriteBranchContext.class);
        }

        public RewriteBranchContext rewriteBranch(int i) {
            return getRuleContext(RewriteBranchContext.class, i);
        }

        public List<AnnotationNameContext> annotationName() {
            return getRuleContexts(AnnotationNameContext.class);
        }

        public AnnotationNameContext annotationName(int i) {
            return getRuleContext(AnnotationNameContext.class, i);
        }

        public List<BranchSepContext> branchSep() {
            return getRuleContexts(BranchSepContext.class);
        }

        public BranchSepContext branchSep(int i) {
            return getRuleContext(BranchSepContext.class, i);
        }

        public RewriteRuleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rewriteRule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterRewriteRule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitRewriteRule(this);
        }
    }

    public final RewriteRuleContext rewriteRule() throws RecognitionException {
        RewriteRuleContext _localctx = new RewriteRuleContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_rewriteRule);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ANNOTATION_ID) {
                    {
                        {
                            setState(107);
                            annotationName();
                        }
                    }
                    setState(112);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(113);
                ruleName();
                setState(114);
                match(ARROW);
                setState(115);
                rewriteBranch();
                setState(121);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == BAR) {
                    {
                        {
                            setState(116);
                            branchSep();
                            setState(117);
                            rewriteBranch();
                        }
                    }
                    setState(123);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RewriteBranchContext extends ParserRuleContext {
        public BranchWeightContext branchWeight() {
            return getRuleContext(BranchWeightContext.class, 0);
        }

        public List<RuleNameContext> ruleName() {
            return getRuleContexts(RuleNameContext.class);
        }

        public RuleNameContext ruleName(int i) {
            return getRuleContext(RuleNameContext.class, i);
        }

        public RewriteBranchContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rewriteBranch;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterRewriteBranch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitRewriteBranch(this);
        }
    }

    public final RewriteBranchContext rewriteBranch() throws RecognitionException {
        RewriteBranchContext _localctx = new RewriteBranchContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_rewriteBranch);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(125);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(124);
                        branchWeight();
                    }
                }

                setState(128);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(127);
                                ruleName();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(130);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BuiltinFnContext extends ParserRuleContext {
        public BuiltinNameContext builtinName() {
            return getRuleContext(BuiltinNameContext.class, 0);
        }

        public FnCallArgsContext fnCallArgs() {
            return getRuleContext(FnCallArgsContext.class, 0);
        }

        public FnCallBodyContext fnCallBody() {
            return getRuleContext(FnCallBodyContext.class, 0);
        }

        public BuiltinFnContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_builtinFn;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterBuiltinFn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitBuiltinFn(this);
        }
    }

    public final BuiltinFnContext builtinFn() throws RecognitionException {
        BuiltinFnContext _localctx = new BuiltinFnContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_builtinFn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(132);
                builtinName();
                setState(134);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(133);
                        fnCallArgs();
                    }
                }

                setState(137);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACE) {
                    {
                        setState(136);
                        fnCallBody();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FnCallArgsContext extends ParserRuleContext {
        public TerminalNode LPAREN() {
            return getToken(RulecodeParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(RulecodeParser.RPAREN, 0);
        }

        public List<FnCallArgContext> fnCallArg() {
            return getRuleContexts(FnCallArgContext.class);
        }

        public FnCallArgContext fnCallArg(int i) {
            return getRuleContext(FnCallArgContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(RulecodeParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(RulecodeParser.COMMA, i);
        }

        public FnCallArgsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fnCallArgs;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterFnCallArgs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitFnCallArgs(this);
        }
    }

    public final FnCallArgsContext fnCallArgs() throws RecognitionException {
        FnCallArgsContext _localctx = new FnCallArgsContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_fnCallArgs);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(139);
                match(LPAREN);
                setState(148);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ID) {
                    {
                        setState(140);
                        fnCallArg();
                        setState(145);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(141);
                                    match(COMMA);
                                    setState(142);
                                    fnCallArg();
                                }
                            }
                            setState(147);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(150);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FnCallArgContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(RulecodeParser.ID, 0);
        }

        public TerminalNode EQUALS() {
            return getToken(RulecodeParser.EQUALS, 0);
        }

        public ElementContext element() {
            return getRuleContext(ElementContext.class, 0);
        }

        public FnCallArgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fnCallArg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterFnCallArg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitFnCallArg(this);
        }
    }

    public final FnCallArgContext fnCallArg() throws RecognitionException {
        FnCallArgContext _localctx = new FnCallArgContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_fnCallArg);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(152);
                match(ID);
                setState(153);
                match(EQUALS);
                setState(154);
                element();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FnCallBodyContext extends ParserRuleContext {
        public TerminalNode LBRACE() {
            return getToken(RulecodeParser.LBRACE, 0);
        }

        public TerminalNode RBRACE() {
            return getToken(RulecodeParser.RBRACE, 0);
        }

        public List<ElementContext> element() {
            return getRuleContexts(ElementContext.class);
        }

        public ElementContext element(int i) {
            return getRuleContext(ElementContext.class, i);
        }

        public FnCallBodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fnCallBody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterFnCallBody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitFnCallBody(this);
        }
    }

    public final FnCallBodyContext fnCallBody() throws RecognitionException {
        FnCallBodyContext _localctx = new FnCallBodyContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_fnCallBody);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(156);
                match(LBRACE);
                setState(160);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((_la) & ~0x3f) == 0 && ((1L << _la) & 3390L) != 0) {
                    {
                        {
                            setState(157);
                            element();
                        }
                    }
                    setState(162);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(163);
                match(RBRACE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RuleFnContext extends ParserRuleContext {
        public ModuleRuleNameContext moduleRuleName() {
            return getRuleContext(ModuleRuleNameContext.class, 0);
        }

        public RuleCallArgsContext ruleCallArgs() {
            return getRuleContext(RuleCallArgsContext.class, 0);
        }

        public RuleFnContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleFn;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterRuleFn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitRuleFn(this);
        }
    }

    public final RuleFnContext ruleFn() throws RecognitionException {
        RuleFnContext _localctx = new RuleFnContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_ruleFn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(165);
                moduleRuleName();
                setState(167);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(166);
                        ruleCallArgs();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RuleCallArgsContext extends ParserRuleContext {
        public TerminalNode LPAREN() {
            return getToken(RulecodeParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(RulecodeParser.RPAREN, 0);
        }

        public List<RuleCallArgContext> ruleCallArg() {
            return getRuleContexts(RuleCallArgContext.class);
        }

        public RuleCallArgContext ruleCallArg(int i) {
            return getRuleContext(RuleCallArgContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(RulecodeParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(RulecodeParser.COMMA, i);
        }

        public RuleCallArgsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleCallArgs;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterRuleCallArgs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitRuleCallArgs(this);
        }
    }

    public final RuleCallArgsContext ruleCallArgs() throws RecognitionException {
        RuleCallArgsContext _localctx = new RuleCallArgsContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_ruleCallArgs);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(169);
                match(LPAREN);
                setState(178);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == VARIABLE_ID) {
                    {
                        setState(170);
                        ruleCallArg();
                        setState(175);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(171);
                                    match(COMMA);
                                    setState(172);
                                    ruleCallArg();
                                }
                            }
                            setState(177);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(180);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RuleCallArgContext extends ParserRuleContext {
        public VariableNameContext variableName() {
            return getRuleContext(VariableNameContext.class, 0);
        }

        public TerminalNode EQUALS() {
            return getToken(RulecodeParser.EQUALS, 0);
        }

        public ElementContext element() {
            return getRuleContext(ElementContext.class, 0);
        }

        public RuleCallArgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleCallArg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterRuleCallArg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitRuleCallArg(this);
        }
    }

    public final RuleCallArgContext ruleCallArg() throws RecognitionException {
        RuleCallArgContext _localctx = new RuleCallArgContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_ruleCallArg);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(182);
                variableName();
                setState(183);
                match(EQUALS);
                setState(184);
                element();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElementContext extends ParserRuleContext {
        public RuleFnContext ruleFn() {
            return getRuleContext(RuleFnContext.class, 0);
        }

        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public ColorContext color() {
            return getRuleContext(ColorContext.class, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public BooleanContext boolean_() {
            return getRuleContext(BooleanContext.class, 0);
        }

        public VariableNameContext variableName() {
            return getRuleContext(VariableNameContext.class, 0);
        }

        public BuiltinFnContext builtinFn() {
            return getRuleContext(BuiltinFnContext.class, 0);
        }

        public ElementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_element;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterElement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitElement(this);
        }
    }

    public final ElementContext element() throws RecognitionException {
        ElementContext _localctx = new ElementContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_element);
        try {
            setState(193);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case ID:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(186);
                    ruleFn();
                }
                break;
                case NUMBER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(187);
                    number();
                }
                break;
                case HEXCOLOR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(188);
                    color();
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(189);
                    string();
                }
                break;
                case TRUE:
                case FALSE:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(190);
                    boolean_();
                }
                break;
                case VARIABLE_ID:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(191);
                    variableName();
                }
                break;
                case BUILTIN_ID:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(192);
                    builtinFn();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BranchWeightContext extends ParserRuleContext {
        public TerminalNode LBRACKET() {
            return getToken(RulecodeParser.LBRACKET, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(RulecodeParser.NUMBER, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(RulecodeParser.RBRACKET, 0);
        }

        public BranchWeightContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_branchWeight;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterBranchWeight(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitBranchWeight(this);
        }
    }

    public final BranchWeightContext branchWeight() throws RecognitionException {
        BranchWeightContext _localctx = new BranchWeightContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_branchWeight);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(195);
                match(LBRACKET);
                setState(196);
                match(NUMBER);
                setState(197);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BranchSepContext extends ParserRuleContext {
        public TerminalNode BAR() {
            return getToken(RulecodeParser.BAR, 0);
        }

        public BranchSepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_branchSep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterBranchSep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitBranchSep(this);
        }
    }

    public final BranchSepContext branchSep() throws RecognitionException {
        BranchSepContext _localctx = new BranchSepContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_branchSep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(199);
                match(BAR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ModuleRuleNameContext extends ParserRuleContext {
        public List<TerminalNode> ID() {
            return getTokens(RulecodeParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(RulecodeParser.ID, i);
        }

        public TerminalNode DOT() {
            return getToken(RulecodeParser.DOT, 0);
        }

        public ModuleRuleNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_moduleRuleName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterModuleRuleName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitModuleRuleName(this);
        }
    }

    public final ModuleRuleNameContext moduleRuleName() throws RecognitionException {
        ModuleRuleNameContext _localctx = new ModuleRuleNameContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_moduleRuleName);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(201);
                match(ID);
                setState(204);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DOT) {
                    {
                        setState(202);
                        match(DOT);
                        setState(203);
                        match(ID);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RuleNameContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(RulecodeParser.ID, 0);
        }

        public RuleNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterRuleName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitRuleName(this);
        }
    }

    public final RuleNameContext ruleName() throws RecognitionException {
        RuleNameContext _localctx = new RuleNameContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_ruleName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(206);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AnnotationNameContext extends ParserRuleContext {
        public TerminalNode ANNOTATION_ID() {
            return getToken(RulecodeParser.ANNOTATION_ID, 0);
        }

        public AnnotationNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_annotationName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterAnnotationName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitAnnotationName(this);
        }
    }

    public final AnnotationNameContext annotationName() throws RecognitionException {
        AnnotationNameContext _localctx = new AnnotationNameContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_annotationName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                match(ANNOTATION_ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BuiltinNameContext extends ParserRuleContext {
        public TerminalNode BUILTIN_ID() {
            return getToken(RulecodeParser.BUILTIN_ID, 0);
        }

        public BuiltinNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_builtinName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterBuiltinName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitBuiltinName(this);
        }
    }

    public final BuiltinNameContext builtinName() throws RecognitionException {
        BuiltinNameContext _localctx = new BuiltinNameContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_builtinName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(210);
                match(BUILTIN_ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VariableNameContext extends ParserRuleContext {
        public TerminalNode VARIABLE_ID() {
            return getToken(RulecodeParser.VARIABLE_ID, 0);
        }

        public VariableNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterVariableName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitVariableName(this);
        }
    }

    public final VariableNameContext variableName() throws RecognitionException {
        VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_variableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(212);
                match(VARIABLE_ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NumberContext extends ParserRuleContext {
        public TerminalNode NUMBER() {
            return getToken(RulecodeParser.NUMBER, 0);
        }

        public NumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitNumber(this);
        }
    }

    public final NumberContext number() throws RecognitionException {
        NumberContext _localctx = new NumberContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_number);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(214);
                match(NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ColorContext extends ParserRuleContext {
        public TerminalNode HEXCOLOR() {
            return getToken(RulecodeParser.HEXCOLOR, 0);
        }

        public ColorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_color;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterColor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitColor(this);
        }
    }

    public final ColorContext color() throws RecognitionException {
        ColorContext _localctx = new ColorContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_color);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(216);
                match(HEXCOLOR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StringContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(RulecodeParser.STRING, 0);
        }

        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitString(this);
        }
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_string);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(218);
                match(STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BooleanContext extends ParserRuleContext {
        public TerminalNode TRUE() {
            return getToken(RulecodeParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(RulecodeParser.FALSE, 0);
        }

        public BooleanContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolean;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterBoolean(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitBoolean(this);
        }
    }

    public final BooleanContext boolean_() throws RecognitionException {
        BooleanContext _localctx = new BooleanContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_boolean);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(220);
                _la = _input.LA(1);
                if (!(_la == TRUE || _la == FALSE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\u0004\u0001\u0019\u00df\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007" +
                    "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007" +
                    "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007" +
                    "\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0004" +
                    "\u00008\b\u0000\u000b\u0000\f\u00009\u0001\u0000\u0001\u0000\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002" +
                    "D\b\u0002\n\u0002\f\u0002G\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002" +
                    "K\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0005\u0002R\b\u0002\n\u0002\f\u0002U\t\u0002\u0001\u0003\u0003\u0003" +
                    "X\b\u0003\u0001\u0003\u0004\u0003[\b\u0003\u000b\u0003\f\u0003\\\u0001" +
                    "\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004c\b\u0004\n\u0004" +
                    "\f\u0004f\t\u0004\u0003\u0004h\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005" +
                    "\u0005\u0005m\b\u0005\n\u0005\f\u0005p\t\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005x\b\u0005" +
                    "\n\u0005\f\u0005{\t\u0005\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0006" +
                    "\u0004\u0006\u0081\b\u0006\u000b\u0006\f\u0006\u0082\u0001\u0007\u0001" +
                    "\u0007\u0003\u0007\u0087\b\u0007\u0001\u0007\u0003\u0007\u008a\b\u0007" +
                    "\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0090\b\b\n\b\f\b\u0093\t\b\u0003" +
                    "\b\u0095\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001" +
                    "\n\u0005\n\u009f\b\n\n\n\f\n\u00a2\t\n\u0001\n\u0001\n\u0001\u000b\u0001" +
                    "\u000b\u0003\u000b\u00a8\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005" +
                    "\f\u00ae\b\f\n\f\f\f\u00b1\t\f\u0003\f\u00b3\b\f\u0001\f\u0001\f\u0001" +
                    "\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
                    "\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c2\b\u000e\u0001\u000f" +
                    "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011" +
                    "\u0001\u0011\u0001\u0011\u0003\u0011\u00cd\b\u0011\u0001\u0012\u0001\u0012" +
                    "\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015" +
                    "\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018" +
                    "\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004" +
                    "\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"" +
                    "$&(*,.02\u0000\u0001\u0001\u0000\u0004\u0005\u00e1\u00007\u0001\u0000" +
                    "\u0000\u0000\u0002=\u0001\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000" +
                    "\u0006W\u0001\u0000\u0000\u0000\b^\u0001\u0000\u0000\u0000\nn\u0001\u0000" +
                    "\u0000\u0000\f}\u0001\u0000\u0000\u0000\u000e\u0084\u0001\u0000\u0000" +
                    "\u0000\u0010\u008b\u0001\u0000\u0000\u0000\u0012\u0098\u0001\u0000\u0000" +
                    "\u0000\u0014\u009c\u0001\u0000\u0000\u0000\u0016\u00a5\u0001\u0000\u0000" +
                    "\u0000\u0018\u00a9\u0001\u0000\u0000\u0000\u001a\u00b6\u0001\u0000\u0000" +
                    "\u0000\u001c\u00c1\u0001\u0000\u0000\u0000\u001e\u00c3\u0001\u0000\u0000" +
                    "\u0000 \u00c7\u0001\u0000\u0000\u0000\"\u00c9\u0001\u0000\u0000\u0000" +
                    "$\u00ce\u0001\u0000\u0000\u0000&\u00d0\u0001\u0000\u0000\u0000(\u00d2" +
                    "\u0001\u0000\u0000\u0000*\u00d4\u0001\u0000\u0000\u0000,\u00d6\u0001\u0000" +
                    "\u0000\u0000.\u00d8\u0001\u0000\u0000\u00000\u00da\u0001\u0000\u0000\u0000" +
                    "2\u00dc\u0001\u0000\u0000\u000048\u0003\u0002\u0001\u000058\u0003\u0004" +
                    "\u0002\u000068\u0003\n\u0005\u000074\u0001\u0000\u0000\u000075\u0001\u0000" +
                    "\u0000\u000076\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u000097\u0001" +
                    "\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000" +
                    ";<\u0005\u0000\u0000\u0001<\u0001\u0001\u0000\u0000\u0000=>\u0005\u0006" +
                    "\u0000\u0000>?\u00030\u0018\u0000?@\u0005\u0007\u0000\u0000@A\u0003$\u0012" +
                    "\u0000A\u0003\u0001\u0000\u0000\u0000BD\u0003&\u0013\u0000CB\u0001\u0000" +
                    "\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001" +
                    "\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000" +
                    "HJ\u0003$\u0012\u0000IK\u0003\b\u0004\u0000JI\u0001\u0000\u0000\u0000" +
                    "JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005\f\u0000\u0000" +
                    "MS\u0003\u0006\u0003\u0000NO\u0003 \u0010\u0000OP\u0003\u0006\u0003\u0000" +
                    "PR\u0001\u0000\u0000\u0000QN\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000" +
                    "\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0005\u0001" +
                    "\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VX\u0003\u001e\u000f\u0000" +
                    "WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000" +
                    "\u0000Y[\u0003\u001c\u000e\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000" +
                    "\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u0007" +
                    "\u0001\u0000\u0000\u0000^g\u0005\u0013\u0000\u0000_d\u0003*\u0015\u0000" +
                    "`a\u0005\u000f\u0000\u0000ac\u0003*\u0015\u0000b`\u0001\u0000\u0000\u0000" +
                    "cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000" +
                    "\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000g_\u0001\u0000" +
                    "\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005" +
                    "\u0014\u0000\u0000j\t\u0001\u0000\u0000\u0000km\u0003&\u0013\u0000lk\u0001" +
                    "\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000" +
                    "no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000" +
                    "\u0000qr\u0003$\u0012\u0000rs\u0005\r\u0000\u0000sy\u0003\f\u0006\u0000" +
                    "tu\u0003 \u0010\u0000uv\u0003\f\u0006\u0000vx\u0001\u0000\u0000\u0000" +
                    "wt\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000" +
                    "\u0000yz\u0001\u0000\u0000\u0000z\u000b\u0001\u0000\u0000\u0000{y\u0001" +
                    "\u0000\u0000\u0000|~\u0003\u001e\u000f\u0000}|\u0001\u0000\u0000\u0000" +
                    "}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007f\u0081" +
                    "\u0003$\u0012\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001" +
                    "\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001" +
                    "\u0000\u0000\u0000\u0083\r\u0001\u0000\u0000\u0000\u0084\u0086\u0003(" +
                    "\u0014\u0000\u0085\u0087\u0003\u0010\b\u0000\u0086\u0085\u0001\u0000\u0000" +
                    "\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000" +
                    "\u0000\u0088\u008a\u0003\u0014\n\u0000\u0089\u0088\u0001\u0000\u0000\u0000" +
                    "\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u000f\u0001\u0000\u0000\u0000" +
                    "\u008b\u0094\u0005\u0013\u0000\u0000\u008c\u0091\u0003\u0012\t\u0000\u008d" +
                    "\u008e\u0005\u000f\u0000\u0000\u008e\u0090\u0003\u0012\t\u0000\u008f\u008d" +
                    "\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f" +
                    "\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0095" +
                    "\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u008c" +
                    "\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096" +
                    "\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0014\u0000\u0000\u0097\u0011" +
                    "\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u009a" +
                    "\u0005\u000e\u0000\u0000\u009a\u009b\u0003\u001c\u000e\u0000\u009b\u0013" +
                    "\u0001\u0000\u0000\u0000\u009c\u00a0\u0005\u0017\u0000\u0000\u009d\u009f" +
                    "\u0003\u001c\u000e\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009f\u00a2" +
                    "\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1" +
                    "\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u00a0" +
                    "\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0018\u0000\u0000\u00a4\u0015" +
                    "\u0001\u0000\u0000\u0000\u00a5\u00a7\u0003\"\u0011\u0000\u00a6\u00a8\u0003" +
                    "\u0018\f\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000" +
                    "\u0000\u0000\u00a8\u0017\u0001\u0000\u0000\u0000\u00a9\u00b2\u0005\u0013" +
                    "\u0000\u0000\u00aa\u00af\u0003\u001a\r\u0000\u00ab\u00ac\u0005\u000f\u0000" +
                    "\u0000\u00ac\u00ae\u0003\u001a\r\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000" +
                    "\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000" +
                    "\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000" +
                    "\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00aa\u0001\u0000\u0000\u0000" +
                    "\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000" +
                    "\u00b4\u00b5\u0005\u0014\u0000\u0000\u00b5\u0019\u0001\u0000\u0000\u0000" +
                    "\u00b6\u00b7\u0003*\u0015\u0000\u00b7\u00b8\u0005\u000e\u0000\u0000\u00b8" +
                    "\u00b9\u0003\u001c\u000e\u0000\u00b9\u001b\u0001\u0000\u0000\u0000\u00ba" +
                    "\u00c2\u0003\u0016\u000b\u0000\u00bb\u00c2\u0003,\u0016\u0000\u00bc\u00c2" +
                    "\u0003.\u0017\u0000\u00bd\u00c2\u00030\u0018\u0000\u00be\u00c2\u00032" +
                    "\u0019\u0000\u00bf\u00c2\u0003*\u0015\u0000\u00c0\u00c2\u0003\u000e\u0007" +
                    "\u0000\u00c1\u00ba\u0001\u0000\u0000\u0000\u00c1\u00bb\u0001\u0000\u0000" +
                    "\u0000\u00c1\u00bc\u0001\u0000\u0000\u0000\u00c1\u00bd\u0001\u0000\u0000" +
                    "\u0000\u00c1\u00be\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000" +
                    "\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u001d\u0001\u0000\u0000" +
                    "\u0000\u00c3\u00c4\u0005\u0015\u0000\u0000\u00c4\u00c5\u0005\u0001\u0000" +
                    "\u0000\u00c5\u00c6\u0005\u0016\u0000\u0000\u00c6\u001f\u0001\u0000\u0000" +
                    "\u0000\u00c7\u00c8\u0005\u0011\u0000\u0000\u00c8!\u0001\u0000\u0000\u0000" +
                    "\u00c9\u00cc\u0005\u000b\u0000\u0000\u00ca\u00cb\u0005\u0012\u0000\u0000" +
                    "\u00cb\u00cd\u0005\u000b\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000" +
                    "\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd#\u0001\u0000\u0000\u0000\u00ce" +
                    "\u00cf\u0005\u000b\u0000\u0000\u00cf%\u0001\u0000\u0000\u0000\u00d0\u00d1" +
                    "\u0005\t\u0000\u0000\u00d1\'\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005" +
                    "\b\u0000\u0000\u00d3)\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\n\u0000" +
                    "\u0000\u00d5+\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0001\u0000\u0000" +
                    "\u00d7-\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0002\u0000\u0000\u00d9" +
                    "/\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0003\u0000\u0000\u00db1\u0001" +
                    "\u0000\u0000\u0000\u00dc\u00dd\u0007\u0000\u0000\u0000\u00dd3\u0001\u0000" +
                    "\u0000\u0000\u001779EJSW\\dgny}\u0082\u0086\u0089\u0091\u0094\u00a0\u00a7" +
                    "\u00af\u00b2\u00c1\u00cc";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}