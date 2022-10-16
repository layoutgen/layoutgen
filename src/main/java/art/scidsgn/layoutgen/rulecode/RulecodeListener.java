package art.scidsgn.layoutgen.rulecode;

// Generated from java-escape by ANTLR 4.11.1

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RulecodeParser}.
 */
public interface RulecodeListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link RulecodeParser#program}.
     *
     * @param ctx the parse tree
     */
    void enterProgram(RulecodeParser.ProgramContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#program}.
     *
     * @param ctx the parse tree
     */
    void exitProgram(RulecodeParser.ProgramContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#isRule}.
     *
     * @param ctx the parse tree
     */
    void enterIsRule(RulecodeParser.IsRuleContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#isRule}.
     *
     * @param ctx the parse tree
     */
    void exitIsRule(RulecodeParser.IsRuleContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#isBranch}.
     *
     * @param ctx the parse tree
     */
    void enterIsBranch(RulecodeParser.IsBranchContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#isBranch}.
     *
     * @param ctx the parse tree
     */
    void exitIsBranch(RulecodeParser.IsBranchContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#isVars}.
     *
     * @param ctx the parse tree
     */
    void enterIsVars(RulecodeParser.IsVarsContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#isVars}.
     *
     * @param ctx the parse tree
     */
    void exitIsVars(RulecodeParser.IsVarsContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#rewriteRule}.
     *
     * @param ctx the parse tree
     */
    void enterRewriteRule(RulecodeParser.RewriteRuleContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#rewriteRule}.
     *
     * @param ctx the parse tree
     */
    void exitRewriteRule(RulecodeParser.RewriteRuleContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#rewriteBranch}.
     *
     * @param ctx the parse tree
     */
    void enterRewriteBranch(RulecodeParser.RewriteBranchContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#rewriteBranch}.
     *
     * @param ctx the parse tree
     */
    void exitRewriteBranch(RulecodeParser.RewriteBranchContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#annotationFn}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationFn(RulecodeParser.AnnotationFnContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#annotationFn}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationFn(RulecodeParser.AnnotationFnContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#builtinFn}.
     *
     * @param ctx the parse tree
     */
    void enterBuiltinFn(RulecodeParser.BuiltinFnContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#builtinFn}.
     *
     * @param ctx the parse tree
     */
    void exitBuiltinFn(RulecodeParser.BuiltinFnContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#fnCallArgs}.
     *
     * @param ctx the parse tree
     */
    void enterFnCallArgs(RulecodeParser.FnCallArgsContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#fnCallArgs}.
     *
     * @param ctx the parse tree
     */
    void exitFnCallArgs(RulecodeParser.FnCallArgsContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#fnCallArg}.
     *
     * @param ctx the parse tree
     */
    void enterFnCallArg(RulecodeParser.FnCallArgContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#fnCallArg}.
     *
     * @param ctx the parse tree
     */
    void exitFnCallArg(RulecodeParser.FnCallArgContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#fnCallBody}.
     *
     * @param ctx the parse tree
     */
    void enterFnCallBody(RulecodeParser.FnCallBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#fnCallBody}.
     *
     * @param ctx the parse tree
     */
    void exitFnCallBody(RulecodeParser.FnCallBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#element}.
     *
     * @param ctx the parse tree
     */
    void enterElement(RulecodeParser.ElementContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#element}.
     *
     * @param ctx the parse tree
     */
    void exitElement(RulecodeParser.ElementContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#branchWeight}.
     *
     * @param ctx the parse tree
     */
    void enterBranchWeight(RulecodeParser.BranchWeightContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#branchWeight}.
     *
     * @param ctx the parse tree
     */
    void exitBranchWeight(RulecodeParser.BranchWeightContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#branchSep}.
     *
     * @param ctx the parse tree
     */
    void enterBranchSep(RulecodeParser.BranchSepContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#branchSep}.
     *
     * @param ctx the parse tree
     */
    void exitBranchSep(RulecodeParser.BranchSepContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#moduleRuleName}.
     *
     * @param ctx the parse tree
     */
    void enterModuleRuleName(RulecodeParser.ModuleRuleNameContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#moduleRuleName}.
     *
     * @param ctx the parse tree
     */
    void exitModuleRuleName(RulecodeParser.ModuleRuleNameContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#ruleName}.
     *
     * @param ctx the parse tree
     */
    void enterRuleName(RulecodeParser.RuleNameContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#ruleName}.
     *
     * @param ctx the parse tree
     */
    void exitRuleName(RulecodeParser.RuleNameContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#annotation}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotation(RulecodeParser.AnnotationContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#annotation}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotation(RulecodeParser.AnnotationContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#builtin}.
     *
     * @param ctx the parse tree
     */
    void enterBuiltin(RulecodeParser.BuiltinContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#builtin}.
     *
     * @param ctx the parse tree
     */
    void exitBuiltin(RulecodeParser.BuiltinContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#variable}.
     *
     * @param ctx the parse tree
     */
    void enterVariable(RulecodeParser.VariableContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#variable}.
     *
     * @param ctx the parse tree
     */
    void exitVariable(RulecodeParser.VariableContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#number}.
     *
     * @param ctx the parse tree
     */
    void enterNumber(RulecodeParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#number}.
     *
     * @param ctx the parse tree
     */
    void exitNumber(RulecodeParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#color}.
     *
     * @param ctx the parse tree
     */
    void enterColor(RulecodeParser.ColorContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#color}.
     *
     * @param ctx the parse tree
     */
    void exitColor(RulecodeParser.ColorContext ctx);

    /**
     * Enter a parse tree produced by {@link RulecodeParser#string}.
     *
     * @param ctx the parse tree
     */
    void enterString(RulecodeParser.StringContext ctx);

    /**
     * Exit a parse tree produced by {@link RulecodeParser#string}.
     *
     * @param ctx the parse tree
     */
    void exitString(RulecodeParser.StringContext ctx);
}