grammar Rulecode;

program: (isRule | rewriteRule)+ EOF;

// Is-rule: X := Y Z | ABC
isRule:
	annotationFn* ruleName isVars? IS_EQUALS isBranch (
		branchSep isBranch
	)*;
// Is-rule branch: elements!
isBranch: branchWeight? element+;
// Is-rule variables: A(_x, _y, _z) := ...
isVars: LPAREN (variable (COMMA variable)*)? RPAREN;

// Rewrite rule: X -> Y Z | ABC
rewriteRule:
	annotationFn* ruleName ARROW rewriteBranch (
		branchSep rewriteBranch
	)*;
// Rewrite branch: only rule names
rewriteBranch: branchWeight? moduleRuleName+;

// Annotation function call: @Fixed(...) {...}
annotationFn: annotation fnCallArgs? fnCallBody?;
// Builtin function call: $Random(...) {...}
builtinFn: builtin fnCallArgs? fnCallBody?;

// Function call arguments
fnCallArgs: LPAREN (fnCallArg (COMMA fnCallArg)*)? RPAREN;
fnCallArg: ID EQUALS element;
fnCallBody: LBRACE element* RBRACE;

// Single element
element:
	moduleRuleName
	| number
	| color
	| string
	| variable
	| builtinFn;

// Branch weight: [42] [0.5]
branchWeight: LBRACKET NUMBER RBRACKET;
// Branch separator
branchSep: BAR;

// Modular rule name (no nested modules!!)
moduleRuleName: ID (DOT ID)?;
// General rule name (no module specifier)
ruleName: ID;

annotation: ANNOTATION;
builtin: BUILTIN;
variable: VARIABLE;

number: NUMBER;
color: HEXCOLOR;
string: STRING;

NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
HEXCOLOR: '#' [0-9a-fA-F]+;
STRING:
	'"' (~('"' | '\\' | '\r' | '\n') | '\\' ('"' | '\\'))* '"';

BUILTIN: '$' ID;
ANNOTATION: '@' ID;
VARIABLE: '_' ID;
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