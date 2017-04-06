grammar Robocommande ;

prog : NEWLINE* setup? defaultStrategy (strategy | defineFunction)* EOF ;

setup: 'behavior' 'onSetup' '('')' setupBlock;
run: 'behavior' 'onRun' '('')' block;

functions : (defineFunction | behaviorFunction)* ;
defineFunction : 'define' type ID '(' formalParams? ')' block;
behaviorFunction : 'behavior' ID '(' ID ')' block;
formalParams: type ID (',' type ID)* ;
actualParams: expr (',' expr)* ;

strategy : 'strategy' ID strategyDefinition;
defaultStrategy : 'strategy' 'default' strategyDefinition;
strategyDefinition : ':' NEWLINE* run? functions? ';' NEWLINE*;

setupBlock : ':' (setupStmt)* ';' NEWLINE* ;
block : ':' (stmt)* ';' NEWLINE* ;

setupStmt : NEWLINE+ ( generalStmtPart
                 | newEvent )? NEWLINE*
                 ;

stmt : NEWLINE+ (  generalStmtPart
                 | returnStatement )? NEWLINE*
                 ;

generalStmtPart : declaration
                | structDefinition
                | assignment
                | fieldAssignment
                | ifStatement
                | functionCall
                | loop
                ;

structDefinition : ID '{' declaration (',' declaration)* '}' ;
declaration: type ID (':=' expr)? ;
type: 'num'
    | 'text'
    | 'bool'
    | ID
    ;

newEvent : 'new' 'event' ID block ;
fieldAssignment : fieldId ':=' expr ;
assignment : ID ':=' expr ;
ifStatement: 'if' expr block ('else if' expr block)* ('else' block)? ;
functionCall: (fieldId | ID) '(' actualParams? ')' ;
structInitialization: ID '(' assignment? (',' assignment)* ')' ;
loop: 'loop' ('while' expr)? block ;
returnStatement : 'return' expr ;

expr :     ('true' | 'false')               # literal
          | ID                              # literal
          | NUM                             # literal
          | STRING                          # literal
          | fieldId                         # fieldIdentifier
          | functionCall                    # fCall
          | structInitialization            # structInit
          |'(' expr ')'                     # groupedExpression
          | 'not' expr                      # negateBool
          | '-' expr                        # negateExpression
          | <assoc=right> expr '^' expr     # power
          | expr ('*'|'/'|'%') expr         # multDivMod
          | expr ('+'|'-') expr             # plusOrMinus
          | expr ('<='|'>='|'<'|'>') expr   # comparison
          | expr ('!='|'=') expr            # equality
          | expr 'and' expr                 # and
          | expr 'or' expr                  # or
          ;

fieldId : ID ('.' ID)+ ;


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

