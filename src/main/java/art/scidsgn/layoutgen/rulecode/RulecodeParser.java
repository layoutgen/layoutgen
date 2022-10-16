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
            NUMBER = 1, HEXCOLOR = 2, STRING = 3, BUILTIN = 4, ANNOTATION = 5, VARIABLE = 6, ID = 7,
            IS_EQUALS = 8, ARROW = 9, EQUALS = 10, COMMA = 11, SEMI = 12, BAR = 13, DOT = 14, LPAREN = 15,
            RPAREN = 16, LBRACKET = 17, RBRACKET = 18, LBRACE = 19, RBRACE = 20, WS = 21;
    public static final int
            RULE_program = 0, RULE_isRule = 1, RULE_isBranch = 2, RULE_isVars = 3,
            RULE_rewriteRule = 4, RULE_rewriteBranch = 5, RULE_annotationFn = 6, RULE_builtinFn = 7,
            RULE_fnCallArgs = 8, RULE_fnCallArg = 9, RULE_fnCallBody = 10, RULE_element = 11,
            RULE_branchWeight = 12, RULE_branchSep = 13, RULE_moduleRuleName = 14,
            RULE_ruleName = 15, RULE_annotation = 16, RULE_builtin = 17, RULE_variable = 18,
            RULE_number = 19, RULE_color = 20, RULE_string = 21;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "isRule", "isBranch", "isVars", "rewriteRule", "rewriteBranch",
                "annotationFn", "builtinFn", "fnCallArgs", "fnCallArg", "fnCallBody",
                "element", "branchWeight", "branchSep", "moduleRuleName", "ruleName",
                "annotation", "builtin", "variable", "number", "color", "string"
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
                setState(46);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        setState(46);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                            case 1: {
                                setState(44);
                                isRule();
                            }
                            break;
                            case 2: {
                                setState(45);
                                rewriteRule();
                            }
                            break;
                        }
                    }
                    setState(48);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == ANNOTATION || _la == ID);
                setState(50);
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

        public List<AnnotationFnContext> annotationFn() {
            return getRuleContexts(AnnotationFnContext.class);
        }

        public AnnotationFnContext annotationFn(int i) {
            return getRuleContext(AnnotationFnContext.class, i);
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
        enterRule(_localctx, 2, RULE_isRule);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(55);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ANNOTATION) {
                    {
                        {
                            setState(52);
                            annotationFn();
                        }
                    }
                    setState(57);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(58);
                ruleName();
                setState(60);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(59);
                        isVars();
                    }
                }

                setState(62);
                match(IS_EQUALS);
                setState(63);
                isBranch();
                setState(69);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == BAR) {
                    {
                        {
                            setState(64);
                            branchSep();
                            setState(65);
                            isBranch();
                        }
                    }
                    setState(71);
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
        enterRule(_localctx, 4, RULE_isBranch);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(73);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(72);
                        branchWeight();
                    }
                }

                setState(76);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(75);
                                element();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(78);
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

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
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
        enterRule(_localctx, 6, RULE_isVars);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(80);
                match(LPAREN);
                setState(89);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == VARIABLE) {
                    {
                        setState(81);
                        variable();
                        setState(86);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(82);
                                    match(COMMA);
                                    setState(83);
                                    variable();
                                }
                            }
                            setState(88);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(91);
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

        public List<AnnotationFnContext> annotationFn() {
            return getRuleContexts(AnnotationFnContext.class);
        }

        public AnnotationFnContext annotationFn(int i) {
            return getRuleContext(AnnotationFnContext.class, i);
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
        enterRule(_localctx, 8, RULE_rewriteRule);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(96);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ANNOTATION) {
                    {
                        {
                            setState(93);
                            annotationFn();
                        }
                    }
                    setState(98);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(99);
                ruleName();
                setState(100);
                match(ARROW);
                setState(101);
                rewriteBranch();
                setState(107);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == BAR) {
                    {
                        {
                            setState(102);
                            branchSep();
                            setState(103);
                            rewriteBranch();
                        }
                    }
                    setState(109);
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

        public List<ModuleRuleNameContext> moduleRuleName() {
            return getRuleContexts(ModuleRuleNameContext.class);
        }

        public ModuleRuleNameContext moduleRuleName(int i) {
            return getRuleContext(ModuleRuleNameContext.class, i);
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
        enterRule(_localctx, 10, RULE_rewriteBranch);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(111);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(110);
                        branchWeight();
                    }
                }

                setState(114);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(113);
                                moduleRuleName();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(116);
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
    public static class AnnotationFnContext extends ParserRuleContext {
        public AnnotationContext annotation() {
            return getRuleContext(AnnotationContext.class, 0);
        }

        public FnCallArgsContext fnCallArgs() {
            return getRuleContext(FnCallArgsContext.class, 0);
        }

        public FnCallBodyContext fnCallBody() {
            return getRuleContext(FnCallBodyContext.class, 0);
        }

        public AnnotationFnContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_annotationFn;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterAnnotationFn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitAnnotationFn(this);
        }
    }

    public final AnnotationFnContext annotationFn() throws RecognitionException {
        AnnotationFnContext _localctx = new AnnotationFnContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_annotationFn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(118);
                annotation();
                setState(120);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(119);
                        fnCallArgs();
                    }
                }

                setState(123);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACE) {
                    {
                        setState(122);
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
    public static class BuiltinFnContext extends ParserRuleContext {
        public BuiltinContext builtin() {
            return getRuleContext(BuiltinContext.class, 0);
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
                setState(125);
                builtin();
                setState(127);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(126);
                        fnCallArgs();
                    }
                }

                setState(130);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACE) {
                    {
                        setState(129);
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
                setState(132);
                match(LPAREN);
                setState(141);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ID) {
                    {
                        setState(133);
                        fnCallArg();
                        setState(138);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(134);
                                    match(COMMA);
                                    setState(135);
                                    fnCallArg();
                                }
                            }
                            setState(140);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(143);
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
                setState(145);
                match(ID);
                setState(146);
                match(EQUALS);
                setState(147);
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
                setState(149);
                match(LBRACE);
                setState(153);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((_la) & ~0x3f) == 0 && ((1L << _la) & 222L) != 0) {
                    {
                        {
                            setState(150);
                            element();
                        }
                    }
                    setState(155);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(156);
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
    public static class ElementContext extends ParserRuleContext {
        public ModuleRuleNameContext moduleRuleName() {
            return getRuleContext(ModuleRuleNameContext.class, 0);
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

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
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
        enterRule(_localctx, 22, RULE_element);
        try {
            setState(164);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case ID:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(158);
                    moduleRuleName();
                }
                break;
                case NUMBER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(159);
                    number();
                }
                break;
                case HEXCOLOR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(160);
                    color();
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(161);
                    string();
                }
                break;
                case VARIABLE:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(162);
                    variable();
                }
                break;
                case BUILTIN:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(163);
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
        enterRule(_localctx, 24, RULE_branchWeight);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(166);
                match(LBRACKET);
                setState(167);
                match(NUMBER);
                setState(168);
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
        enterRule(_localctx, 26, RULE_branchSep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(170);
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
        enterRule(_localctx, 28, RULE_moduleRuleName);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(172);
                match(ID);
                setState(175);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DOT) {
                    {
                        setState(173);
                        match(DOT);
                        setState(174);
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
        enterRule(_localctx, 30, RULE_ruleName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(177);
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
    public static class AnnotationContext extends ParserRuleContext {
        public TerminalNode ANNOTATION() {
            return getToken(RulecodeParser.ANNOTATION, 0);
        }

        public AnnotationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_annotation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterAnnotation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitAnnotation(this);
        }
    }

    public final AnnotationContext annotation() throws RecognitionException {
        AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_annotation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(179);
                match(ANNOTATION);
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
    public static class BuiltinContext extends ParserRuleContext {
        public TerminalNode BUILTIN() {
            return getToken(RulecodeParser.BUILTIN, 0);
        }

        public BuiltinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_builtin;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterBuiltin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitBuiltin(this);
        }
    }

    public final BuiltinContext builtin() throws RecognitionException {
        BuiltinContext _localctx = new BuiltinContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_builtin);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(181);
                match(BUILTIN);
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
    public static class VariableContext extends ParserRuleContext {
        public TerminalNode VARIABLE() {
            return getToken(RulecodeParser.VARIABLE, 0);
        }

        public VariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).enterVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RulecodeListener) ((RulecodeListener) listener).exitVariable(this);
        }
    }

    public final VariableContext variable() throws RecognitionException {
        VariableContext _localctx = new VariableContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_variable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(183);
                match(VARIABLE);
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
        enterRule(_localctx, 38, RULE_number);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(185);
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
        enterRule(_localctx, 40, RULE_color);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(187);
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
        enterRule(_localctx, 42, RULE_string);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(189);
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

    public static final String _serializedATN =
            "\u0004\u0001\u0015\u00c0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007" +
                    "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007" +
                    "\u0015\u0001\u0000\u0001\u0000\u0004\u0000/\b\u0000\u000b\u0000\f\u0000" +
                    "0\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u0001" +
                    "9\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001D\b\u0001\n\u0001" +
                    "\f\u0001G\t\u0001\u0001\u0002\u0003\u0002J\b\u0002\u0001\u0002\u0004\u0002" +
                    "M\b\u0002\u000b\u0002\f\u0002N\u0001\u0003\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0005\u0003U\b\u0003\n\u0003\f\u0003X\t\u0003\u0003\u0003Z\b\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004_\b\u0004\n\u0004\f\u0004" +
                    "b\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0005\u0004j\b\u0004\n\u0004\f\u0004m\t\u0004\u0001\u0005" +
                    "\u0003\u0005p\b\u0005\u0001\u0005\u0004\u0005s\b\u0005\u000b\u0005\f\u0005" +
                    "t\u0001\u0006\u0001\u0006\u0003\u0006y\b\u0006\u0001\u0006\u0003\u0006" +
                    "|\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u0080\b\u0007\u0001\u0007" +
                    "\u0003\u0007\u0083\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0089" +
                    "\b\b\n\b\f\b\u008c\t\b\u0003\b\u008e\b\b\u0001\b\u0001\b\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n\u0098\b\n\n\n\f\n\u009b\t\n" +
                    "\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0003\u000b\u00a5\b\u000b\u0001\f\u0001\f\u0001\f\u0001" +
                    "\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b0" +
                    "\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001" +
                    "\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001" +
                    "\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0000\u0002" +
                    "\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e" +
                    " \"$&(*\u0000\u0000\u00c3\u0000.\u0001\u0000\u0000\u0000\u00027\u0001" +
                    "\u0000\u0000\u0000\u0004I\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000" +
                    "\u0000\b`\u0001\u0000\u0000\u0000\no\u0001\u0000\u0000\u0000\fv\u0001" +
                    "\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000" +
                    "\u0000\u0000\u0012\u0091\u0001\u0000\u0000\u0000\u0014\u0095\u0001\u0000" +
                    "\u0000\u0000\u0016\u00a4\u0001\u0000\u0000\u0000\u0018\u00a6\u0001\u0000" +
                    "\u0000\u0000\u001a\u00aa\u0001\u0000\u0000\u0000\u001c\u00ac\u0001\u0000" +
                    "\u0000\u0000\u001e\u00b1\u0001\u0000\u0000\u0000 \u00b3\u0001\u0000\u0000" +
                    "\u0000\"\u00b5\u0001\u0000\u0000\u0000$\u00b7\u0001\u0000\u0000\u0000" +
                    "&\u00b9\u0001\u0000\u0000\u0000(\u00bb\u0001\u0000\u0000\u0000*\u00bd" +
                    "\u0001\u0000\u0000\u0000,/\u0003\u0002\u0001\u0000-/\u0003\b\u0004\u0000" +
                    ".,\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000" +
                    "\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0001\u0000" +
                    "\u0000\u000023\u0005\u0000\u0000\u00013\u0001\u0001\u0000\u0000\u0000" +
                    "46\u0003\f\u0006\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u0000" +
                    "75\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000" +
                    "\u000097\u0001\u0000\u0000\u0000:<\u0003\u001e\u000f\u0000;=\u0003\u0006" +
                    "\u0003\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001" +
                    "\u0000\u0000\u0000>?\u0005\b\u0000\u0000?E\u0003\u0004\u0002\u0000@A\u0003" +
                    "\u001a\r\u0000AB\u0003\u0004\u0002\u0000BD\u0001\u0000\u0000\u0000C@\u0001" +
                    "\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000" +
                    "EF\u0001\u0000\u0000\u0000F\u0003\u0001\u0000\u0000\u0000GE\u0001\u0000" +
                    "\u0000\u0000HJ\u0003\u0018\f\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000" +
                    "\u0000\u0000JL\u0001\u0000\u0000\u0000KM\u0003\u0016\u000b\u0000LK\u0001" +
                    "\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000" +
                    "NO\u0001\u0000\u0000\u0000O\u0005\u0001\u0000\u0000\u0000PY\u0005\u000f" +
                    "\u0000\u0000QV\u0003$\u0012\u0000RS\u0005\u000b\u0000\u0000SU\u0003$\u0012" +
                    "\u0000TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000" +
                    "\u0000\u0000VW\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001" +
                    "\u0000\u0000\u0000YQ\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000" +
                    "Z[\u0001\u0000\u0000\u0000[\\\u0005\u0010\u0000\u0000\\\u0007\u0001\u0000" +
                    "\u0000\u0000]_\u0003\f\u0006\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000" +
                    "\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001" +
                    "\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0003\u001e\u000f\u0000" +
                    "de\u0005\t\u0000\u0000ek\u0003\n\u0005\u0000fg\u0003\u001a\r\u0000gh\u0003" +
                    "\n\u0005\u0000hj\u0001\u0000\u0000\u0000if\u0001\u0000\u0000\u0000jm\u0001" +
                    "\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000" +
                    "l\t\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000np\u0003\u0018\f" +
                    "\u0000on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000" +
                    "\u0000\u0000qs\u0003\u001c\u000e\u0000rq\u0001\u0000\u0000\u0000st\u0001" +
                    "\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000" +
                    "u\u000b\u0001\u0000\u0000\u0000vx\u0003 \u0010\u0000wy\u0003\u0010\b\u0000" +
                    "xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000" +
                    "\u0000z|\u0003\u0014\n\u0000{z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000" +
                    "\u0000|\r\u0001\u0000\u0000\u0000}\u007f\u0003\"\u0011\u0000~\u0080\u0003" +
                    "\u0010\b\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000" +
                    "\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u0083\u0003\u0014" +
                    "\n\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000" +
                    "\u0000\u0083\u000f\u0001\u0000\u0000\u0000\u0084\u008d\u0005\u000f\u0000" +
                    "\u0000\u0085\u008a\u0003\u0012\t\u0000\u0086\u0087\u0005\u000b\u0000\u0000" +
                    "\u0087\u0089\u0003\u0012\t\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089" +
                    "\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a" +
                    "\u008b\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c" +
                    "\u008a\u0001\u0000\u0000\u0000\u008d\u0085\u0001\u0000\u0000\u0000\u008d" +
                    "\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f" +
                    "\u0090\u0005\u0010\u0000\u0000\u0090\u0011\u0001\u0000\u0000\u0000\u0091" +
                    "\u0092\u0005\u0007\u0000\u0000\u0092\u0093\u0005\n\u0000\u0000\u0093\u0094" +
                    "\u0003\u0016\u000b\u0000\u0094\u0013\u0001\u0000\u0000\u0000\u0095\u0099" +
                    "\u0005\u0013\u0000\u0000\u0096\u0098\u0003\u0016\u000b\u0000\u0097\u0096" +
                    "\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097" +
                    "\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c" +
                    "\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009d" +
                    "\u0005\u0014\u0000\u0000\u009d\u0015\u0001\u0000\u0000\u0000\u009e\u00a5" +
                    "\u0003\u001c\u000e\u0000\u009f\u00a5\u0003&\u0013\u0000\u00a0\u00a5\u0003" +
                    "(\u0014\u0000\u00a1\u00a5\u0003*\u0015\u0000\u00a2\u00a5\u0003$\u0012" +
                    "\u0000\u00a3\u00a5\u0003\u000e\u0007\u0000\u00a4\u009e\u0001\u0000\u0000" +
                    "\u0000\u00a4\u009f\u0001\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000\u0000" +
                    "\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000" +
                    "\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u0017\u0001\u0000\u0000" +
                    "\u0000\u00a6\u00a7\u0005\u0011\u0000\u0000\u00a7\u00a8\u0005\u0001\u0000" +
                    "\u0000\u00a8\u00a9\u0005\u0012\u0000\u0000\u00a9\u0019\u0001\u0000\u0000" +
                    "\u0000\u00aa\u00ab\u0005\r\u0000\u0000\u00ab\u001b\u0001\u0000\u0000\u0000" +
                    "\u00ac\u00af\u0005\u0007\u0000\u0000\u00ad\u00ae\u0005\u000e\u0000\u0000" +
                    "\u00ae\u00b0\u0005\u0007\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000" +
                    "\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u001d\u0001\u0000\u0000\u0000" +
                    "\u00b1\u00b2\u0005\u0007\u0000\u0000\u00b2\u001f\u0001\u0000\u0000\u0000" +
                    "\u00b3\u00b4\u0005\u0005\u0000\u0000\u00b4!\u0001\u0000\u0000\u0000\u00b5" +
                    "\u00b6\u0005\u0004\u0000\u0000\u00b6#\u0001\u0000\u0000\u0000\u00b7\u00b8" +
                    "\u0005\u0006\u0000\u0000\u00b8%\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005" +
                    "\u0001\u0000\u0000\u00ba\'\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u0002" +
                    "\u0000\u0000\u00bc)\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u0003\u0000" +
                    "\u0000\u00be+\u0001\u0000\u0000\u0000\u0016.07<EINVY`kotx{\u007f\u0082" +
                    "\u008a\u008d\u0099\u00a4\u00af";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}