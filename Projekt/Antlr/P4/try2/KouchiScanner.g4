lexer grammar KouchiScanner;

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
Return: 'return';

Noiseword: ('Teitur') -> skip;

Newline: ('\r'? '\n');

Whitespace: [ \t] -> skip;

SetupIdentifier: 'onSetup';
RunIdentifier: 'onRun';



Reserved: (Keyword
        | And
        | Or);

Double: Digit+ '.' Digit+;
Int: Digit+;
String: Quote (Letter|Digit)* Quote;

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

Comment: '\\' (Letter|Digit)* Newline -> skip;
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


Identifier: Letter (Letter | Digit)*; // (Letter ('_'? (Letter|Digit))*)|('_' ((Letter|Digit)'_'?)*);
