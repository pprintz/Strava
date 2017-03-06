grammar SimpleParser ;

prog : setup? run functions? EOF ;
block : ':' stmt* ';' NEWLINE* ;
stmt : NEWLINE+ (defineFunction
    | behaviorFunction
    | functionCall
    | assignment
    | ifStatement
    | declaration
    | loop
    | dotAssigment
    | newDeclaration
    | dotCall
    | returnStatement)? NEWLINE*;

functions : (defineFunction | behaviorFunction)+ ;
defineFunction : 'define' ID '(' formalParams? ')' block;
behaviorFunction : 'behavior' ID '(' ID ')' block;
actualParams: expr (',' expr)* ;
formalParams: ID (',' ID)* ;
functionCall: ID '(' actualParams? ')' ;
expr :  '(' expr ')'
           | 'not' expr
           | '(' '-' expr ')'
           | <assoc=right> expr '^' expr
           | expr ('*'|'/'|'%') expr
           | expr ('+'|'-') expr
           | expr ('<='|'>='|'<'|'>') expr
           | expr ('!='|'=') expr
           | expr 'and' expr
           | expr 'or' expr
           | ('false' | 'true')
           | functionCall
           | ID
           | NUM
           | dotField
           | dotCall
           | STRING
           ;
ifStatement: 'if' expr block ('else if' expr block)* ('else' block)? ;
assignment : ID ':=' expr ;
declaration: 'var' (assignment | ID) ;
newDeclaration : 'new' (assignment | ID) ;
loop: 'loop' ('while' expr)? block ;
returnStatement : 'return' expr ;
run: 'behavior' 'onRun' '('')' block;
setup: 'behavior' 'onSetup' '('')' block;
dotField: ID ('.' (ID))+ ;
dotCall: ID ('.' (ID))* ('.' functionCall);
dotAssigment: dotField ':=' expr ;


// LEXER PART

ID : [a-zA-Z]+ ;
NUM : INT | FLOAT ;
INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;
STRING : '"' (ESC | .)*? '"' ;

COMMENT : '//' .*? ~[\r\n]* -> skip ;
WS : [ \t]+ -> skip ;
NEWLINE : '\r'? '\n' ;


fragment
DIGIT : [0-9] ;
ESC : '\\' [btnr"\\] ;





