grammar Robocommande ;

prog : NEWLINE* setup? defaultStrategy (strategy | defineFunction)* EOF ;

setup: 'behavior' 'onSetup' '('')' setupBlock;
run: 'behavior' 'onRun' '('')' block;

functions : (defineFunction | behaviorFunction)* ;
defineFunction : 'define' id '(' formalParams? ')' block;
behaviorFunction : 'behavior' id '(' id ')' block;
formalParams: id (',' id)* ;
actualParams: expr (',' expr)* ;

strategy : 'strategy' id strategyDefinition;
defaultStrategy : 'strategy' 'default' strategyDefinition;
strategyDefinition : ':' NEWLINE* run? functions? ';' NEWLINE*;

setupBlock : ':' (setupStmt)* ';' NEWLINE* ;
block : ':' (stmt)* ';' NEWLINE* ;

setupStmt : NEWLINE+ ( declaration
                 | structDeclaration
                 | assignment
                 | fieldAssignment
                 | ifStatement
                 | functionCall
                 | loop
                 | newEvent )? NEWLINE*
                 ;
stmt : NEWLINE+ (  declaration
                 | structDeclaration
                 | assignment
                 | fieldAssignment
                 | ifStatement
                 | functionCall
                 | loop
                 | newDeclaration
                 | returnStatement )? NEWLINE*
                 ;

structDeclaration : id '{' (id | assignment) (',' (id | assignment))* '}' ;
declaration: 'var' id (':=' expr)? ;
newDeclaration : 'new' id (':=' expr)? ;
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

