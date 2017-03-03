grammar SimpleLexer ; 

prog : block+ EOF ;
block : 'bhead' ':' stmt* ';' NEWLINE* ;
stmt : NEWLINE* (ID | INT) NEWLINE+;




ID : [a-zA-Z]+ ;

INT : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT+ ;
STRING : '"' (ESC | .)*? '"' ;

COMMENT : '//' .*? ~[\r\n]* -> skip ;
WS : [ \t]+ -> skip ;
NEWLINE : '\r'? '\n' ; 


fragment 
DIGIT : [0-9] ;
ESC : '\\' [btnr"\\] ; 
