// Difines grammar for fdb script
// sample application
/*
module Fib

    fibAcc = f(n, acc):
        (n == -0 || n == 7) -> acc
        _ -> fibAcc(n - 1, acc * n)

    fib = f(n): fibAcc(n, 1)

    x = fib(10)

    x()
*/


grammar FdbScript;

program : ('module' MODULEID)? (assign)* expr ;

assign : ID '=' expr ;

function : 'f' '(' (ID (',' ID)* )? ')' ':' (assign)* expr ;

invoke : ID '(' (expr (',' expr)* )? ')' ;

if : (condition)+ (else)? ;

condition : '(' boolean ')' '->' expr ;

else : '_' '->' expr ;

expr
    : computed
    | math
    | string
    | boolean
    | compare
    ;

computed
    : if
    | function
    | invoke
    | ID
    ;

boolean
    : '(' boolean ')'
    | TRUE
    | FALSE
    | boolean AND boolean
    | boolean OR boolean
    | computed
    | compare
    | equality
    ;

equality
    : '(' equality ')'
    | equality_operand EQ equality_operand
    | equality_operand NEQ equality_operand
    ;

equality_operand
    : TRUE
    | FALSE
    | string
    | computed
    | math
    ;

compare
    : '(' compare ')'
    | math GT math
    | math LT math
    | math GE math
    | math LE math
    ;

math
    : '(' math ')'
    | NUMBER
    | math MUL math
    | math DIV math
    | math PLUS math
    | math MINUS math
    | computed
    ;

string
    : STRING
    | string PLUS string
    | string PLUS math
    | math PLUS string
    ;

EQ : '==' ;
GT : '>' ;
LT : '<' ;
GE : '>=' ;
LE : '<=' ;
NEQ : '!=' ;

AND : '&&' ;
OR : '||' ;

PLUS : '+' ;
MINUS : '-' ;
DIV : '/' ;
MUL : '*' ;

TRUE : 'true' ;
FALSE : 'false' ;

STRING : '"' ~('\r' | '\n' | '"')* '"' ;
NUMBER : [+-]?[0-9]+('.'[0-9])? ;
ID : [a-z][a-zA-Z]* ;
MODULEID : [A-Z][a-zA-Z]* ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

