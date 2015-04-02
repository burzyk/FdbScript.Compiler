
// Define a grammar called Hello
grammar FdbScript;

program : ('module' MODULEID)? (assign*) expr ;

assign : ID '=' expr ;

function : 'f' '(' (ID (',' ID)* )? ')' ':' (assign*) expr ;

invoke : ID '(' (expr (',' expr)* )? ')' ;

if : (condition)+ (else)? ;

condition : '(' boolean ')' '->' expr ;

else : '_' '->' expr ;

expr
    : computed
    | math
    | STRING
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
    | STRING
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

