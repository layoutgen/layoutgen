grammar Rulecode;

program: (importStatement | isRule | rewriteRule)+ EOF;

// Import statement: import "icons.scirc" as Icons
importStatement: IMPORT_KEYWORD string AS_KEYWORD ruleName;

// Is-rule: X := Y Z | ABC
isRule:
	annotationName* ruleName isVars? IS_EQUALS isBranch (
		branchSep isBranch
	)*;
// Is-rule branch: elements!
isBranch: branchWeight? element+;
// Is-rule variables: A(_x, _y, _z) := ...
isVars: LPAREN (variableName (COMMA variableName)*)? RPAREN;

// Rewrite rule: X -> Y Z | ABC
rewriteRule:
	annotationName* ruleName ARROW rewriteBranch (
		branchSep rewriteBranch
	)*;
// Rewrite branch: only rule names
rewriteBranch: branchWeight? ruleName+;

// Builtin function call: $Random(...) {...}
builtinFn: builtinName fnCallArgs? fnCallBody?;

// Function call arguments
fnCallArgs: LPAREN (fnCallArg (COMMA fnCallArg)*)? RPAREN;
fnCallArg: ID EQUALS element;
fnCallBody: LBRACE element* RBRACE;

// Rule call
ruleFn: moduleRuleName ruleCallArgs?;
ruleCallArgs: LPAREN (ruleCallArg (COMMA ruleCallArg)*)? RPAREN;
ruleCallArg: variableName EQUALS element;

// Single element
element:
// TODO: rule calls?
	ruleFn
	| number
	| color
	| string
	| boolean
	| variableName
	| builtinFn;

// Branch weight: [42] [0.5]
branchWeight: LBRACKET NUMBER RBRACKET;
// Branch separator
branchSep: BAR;

// Modular rule name (no nested modules!!)
moduleRuleName: ID (DOT ID)?;
// General rule name (no module specifier)
ruleName: ID;

annotationName: ANNOTATION_ID;
builtinName: BUILTIN_ID;
variableName: VARIABLE_ID;

number: NUMBER;
color: HEXCOLOR;
string: STRING;
boolean: TRUE | FALSE;

NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
HEXCOLOR: '#' [0-9a-fA-F]+;
STRING:
	'"' (~('"' | '\\' | '\r' | '\n') | '\\' ('"' | '\\'))* '"';

TRUE: 'true';
FALSE: 'false';

IMPORT_KEYWORD: 'import';
AS_KEYWORD: 'as';

BUILTIN_ID: '$' ID;
ANNOTATION_ID: '@' ID;
VARIABLE_ID: '_' ID;
ID: [a-zA-Z][a-zA-Z0-9_]*;

IS_EQUALS: ':=';
ARROW: '->';

EQUALS: '=';
COMMA: ',';
SEMI: ';';
BAR: '|';
DOT: '.';

LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';

WS: [ \t\n\r\f]+ -> skip;