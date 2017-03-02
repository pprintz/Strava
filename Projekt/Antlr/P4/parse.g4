parser grammar parse;
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

binaryOperation: Times | Plus | Minus | Divide | Modulo | Equal | LessEqual | GreaterEqual | NotEqual | And | Or;

returnStatement: Return expression;

run: runHeader block;
functions: (defineFunction | behaviorFunction)*;
defineFunction: Define Identifier LParanthesis params RParenthesis block;
behaviorFunction: Behavior Identifier LParanthesis Identifier+ RParenthesis block;
setupHeader: SetupIdentifier LParenthesis RParenthesis block;
runHeader: RunIdentifier LParenthesis RParenthisis block;