grammar Robocommande ;

prog : NEWLINE* setup? defaultStrategy (strategy | defineFunction)* EOF ;

setup: 'behavior' 'onSetup' '('')' setupBlock;
run: 'behavior' 'onRun' '('')' block;
functions : (defineFunction | behaviorFunction)* ;
strategy : 'strategy' ID strategyDefinition;
defaultStrategy : 'strategy' 'default' strategyDefinition;
strategyDefinition : ':' NEWLINE* run? functions? ';' NEWLINE*;

setupBlock : ':' (setupStmt)* ';' NEWLINE* ;
block : ':' (stmt)* ';' NEWLINE* ;

setupStmt : NEWLINE+ (  declaration
                 | structDeclaration
                 | assignment
                 | fieldAssignment
                 | ifStatement
                 | functionCall
                 | loop
                 | structDeclaration
                 | newEvent
                 | changeStrategy )? NEWLINE*
                 ;
stmt : NEWLINE+ (  declaration
                 | structDeclaration
                 | assignment
                 | fieldAssignment
                 | ifStatement
                 | functionCall
                 | loop
                 | structDeclaration
                 | newDeclaration
                 | changeStrategy
                 | returnStatement )? NEWLINE*
                 ;

defineFunction : 'define' ID '(' formalParams? ')' block;
behaviorFunction : 'behavior' ID '(' ID ')' block;


structDeclaration : ID '{' (ID | assignment) (',' (ID | assignment))* '}' ;

declaration: 'var' ID (':=' expr)? ;
newDeclaration : 'new' ID (':=' expr)? ;
newEvent : 'new' 'behavior' ID block ;
fieldAssignment : fieldId ':=' expr ;
assignment : ID ':=' expr ;
changeStrategy : 'changeStrategy' '('ID')' ;

ifStatement: 'if' expr block ('else if' expr block)* ('else' block)? ;
functionCall: (fieldId | ID) '(' actualParams? ')' ;
structInitialization: ID '(' assignment* ')' ;
loop: 'loop' ('while' expr)? block ;
returnStatement : 'return' expr ;

formalParams: ID (',' ID)* ;
actualParams: expr (',' expr)* ;


expr :     ('true' | 'false')               # literal
          | ID                              # literal
          | NUM                             # literal
          | STRING                          # literal
          | fieldId                         # fieldIdentifier
          | functionCall                    # fCall
          | structInitialization            # structInitializator
          |'(' expr ')'                     # groupedExpression
          | 'not' expr                      # negateBool
          | '-' expr                        # negateNum
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

