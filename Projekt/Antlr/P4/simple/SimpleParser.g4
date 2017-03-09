grammar SimpleParser ;

prog : NEWLINE* setup? run functions? EOF ;
block : ':' stmt* ';' NEWLINE* ;
stmt : NEWLINE+ (defineFunction
    | behaviorFunction
    | functionCall
    | assignment
    | ifStatement
    | declaration
    | loop
    | newDeclaration
    | returnStatement)? NEWLINE*;

functions : (defineFunction | behaviorFunction)+ ;
defineFunction : 'define' ID '(' formalParams? ')' block;
behaviorFunction : 'behavior' ID '(' ID ')' block;
actualParams: expr (',' expr)* ;
formalParams: ID (',' ID)* ;
functionCall: fieldId '(' actualParams? ')' ;
expr :      ('false' | 'true')
           | functionCall
           | fieldId
           | ID
           | NUM
           | STRING
           |'(' expr ')'
           | 'not' expr
           | '(' '-' expr ')'
           | <assoc=right> expr '^' expr
           | expr ('*'|'/'|'%') expr
           | expr ('+'|'-') expr
           | expr ('<='|'>='|'<'|'>') expr
           | expr ('!='|'=') expr
           | expr 'and' expr
           | expr 'or' expr

           ;
ifStatement: 'if' expr block ('else if' expr block)* ('else' block)? ;
assignment : fieldId ':=' expr ;
declaration: 'var' (assignment | ID) ;
newDeclaration : 'new' (assignment | ID) ;
loop: 'loop' ('while' expr)? block ;
returnStatement : 'return' expr ;
run: 'behavior' 'onRun' '('')' block;
setup: 'behavior' 'onSetup' '('')' block;
fieldId : ID ('.' ID)* ;


// LEXER PART

ID : LETTER (LETTER | DIGIT)* ;
NUM : INT | FLOAT ;
INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;
STRING : '"' (ESC | .)*? '"' ;

COMMENT : '//' .*? ~[\r\n]* -> skip ;
WS : [ \t]+ -> skip ;
NEWLINE : '\r'? '\n' ;


fragment
DIGIT : [0-9] ;
LETTER : [a-zA-Z] ;
ESC : '\\' [btnr"\\] ;





