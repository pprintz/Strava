grammar parse;
Keyword: ('define'
  | 'behavior'
  | 'loop'
  | 'return'
  | 'while'
  | 'if'
  | 'else'
  | 'var');

Define: 'define';
Behavior: 'behavior';
While: 'while';

Noiseword: ('Teitur') -> skip;

Newline: ('\r'? '\n');

Whitespace: [ \t] -> skip;

SetupIdentifier: 'onSetup';
RunIdentifier: 'onRun';

Identifier: Letter (Letter | Digit)*; // (Letter ('_'? (Letter|Digit))*)|('_' ((Letter|Digit)'_'?)*);

Reserved: (Keyword
        | And
        | Or);

Double: Digit+ '.' Digit+;
Int: Digit+;
String: Quote .* Quote;

If: 'if';
Else: 'else';
Loop: 'loop';
Var: 'var';

Comma: ',';
Colon: ':';
Semicolon: ';';
Quote: '"';
LParenthesis: '(';
RParenthesis: ')';

Comment: '\\' .* Newline -> skip;
Plus: '+';
Minus: '-';
Multiply: '*';
Divide: '/';
Modulo: '%';
Assign: ':=';
Equal: '=';
LessEqual: '<=';
GreaterEqual: '>=';
NotEqual: '!=';
And: 'and';
Or: 'or';
Not: 'not';

Letter: [a-zA-Z];
Digit: [0-9];
Number: Double
    |   Int;
Return: 'return';


/* PARSER STUFF! */
prog: setup? run functions EOF;
setup: setupHeader block;
block: Colon statements? Semicolon;
statements: statement (Newline+ statements);
statement: assignment
    | declaration
    | functionCall
    | controlStructure
    | returnStatement;

assignment: Identifier Assign expression;
declaration: Var Identifier
    | Var assignment;
functionCall: Identifier LParenthesis params RParenthesis ;
params: (expression (Comma expression)*)?;
controlStructure: Loop block
    | Loop While expression block
    | ifStatement;
ifStatement: If expression block
    | If expression block Else block;
expression: factor
    | factor binaryOperation expression
    | Not expression
    | LParenthesis Minus expression RParenthesis;
factor: Identifier
    | functionCall;

binaryOperation: Multiply | Plus | Minus | Divide | Modulo | Equal | LessEqual | GreaterEqual | NotEqual | And | Or;

returnStatement: Return expression;

run: runHeader block;
functions: (defineFunction | behaviorFunction)*;
defineFunction: Define Identifier LParenthesis params RParenthesis block;
behaviorFunction: Behavior Identifier LParenthesis Identifier+ RParenthesis block;
setupHeader: Behavior SetupIdentifier LParenthesis RParenthesis block;
runHeader: Behavior RunIdentifier LParenthesis RParenthesis block;

test: LParenthesis Define RParenthesis;











