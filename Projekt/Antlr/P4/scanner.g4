lexer grammar scanner;
Keyword: ('define'
  | 'behavior'
  | 'loop'
  | 'return'
  | 'while'
  | 'if'
  | 'else'
  | 'var');

Noiseword: ('Teitur') -> skip;

Newline: ('\r'? '\n');

Whitespace: [ \t] -> skip;

Identifier: (Letter ('_'? (Letter|Digit))*)|('_' ((Letter|Digit)'_'?)*);

Reserved: (Keyword
        | And
        | Or);

Double: Digit+ '.' Digit+;
Int: Digit+;
String: Quote .* Quote;

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

BooleanOperator: Equal
        | LessEqual
        | GreaterEqual
        | NotEqual
        | And
        | Or;

Comment: '\\' .* Newline -> skip;
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

Letter: ('[a-zA-Z]');
Digit: ('[0-9]');
Number: Double
    |   Int;
