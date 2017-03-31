grammar Robocommande ;

prog : NEWLINE* setup? defaultStrategy (strategy | defineFunction)* EOF ;

setup: 'behavior' 'onSetup' '('')' setupBlock;
run: 'behavior' 'onRun' '('')' block;

functions : (defineFunction | behaviorFunction)* ;
defineFunction : 'define' type id '(' formalParams? ')' block;
behaviorFunction : 'behavior' id '(' id ')' block;
formalParams: type id (',' type id)* ;
actualParams: expr (',' expr)* ;

strategy : 'strategy' id strategyDefinition;
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

structDefinition : id '{' declaration (',' declaration)* '}' ;
declaration: type id (':=' expr)? ;
type: 'num'
    | 'text'
    | 'bool'
    | id
    ;

newEvent : 'new' 'event' id block ;
fieldAssignment : fieldId ':=' expr ;
assignment : id ':=' expr ;
ifStatement: 'if' expr block ('else if' expr block)* ('else' block)? ;
functionCall: (fieldId | id) '(' actualParams? ')' ;
structInitialization: id '(' assignment? (',' assignment)* ')' ;
loop: 'loop' ('while' expr)? block ;
returnStatement : 'return' expr ;

expr :     ('true' | 'false')               # literal
          | id                              # literal
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

fieldId : id ('.' id)+ ;
id : ID;


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

