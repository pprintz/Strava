parser grammar parse;
prog: setup? run functions? EOF;
setup: setupHeader block?;
block: Colon statements Semicolon;
statements: statement (Newline+ statements)?;
statement: assignment
    | declaration
    | functionCall
    | controlStructure
    | returnExpression;

assignment: Identifier Assign expression;
declaration: Var Identifier
           | Var assignment;
functionCall: Identifier LParenthesis params? RParenthesis ;
params: param (Comma params)+;
param: functionCall
     | Identifier
     | expression;
controlStructure: csKeyword;
csKeyword: Loop
     | Loop While
     | ifStatement;
ifStatement: If booleanExpression block
     | If booleanExpression block Else block;
booleanExpression: ;
returnExpression: ;

run: ;
functions: ;
setupHeader: ;
expression: ;