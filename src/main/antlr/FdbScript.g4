// Difines grammar for fdb script
// sample application
/*
module Fib

    fibAcc = f(n, acc):
        x = 2 + 2 * 2
        y = (2 + 2) * 2
        z = x + y

        (n == -0 || n == 7) -> acc
        _ -> fibAcc(n - 1, acc * n)

    fib = f(n): fibAcc(n, 1)

    x = fib(10)

    x()
*/


grammar FdbScript;

programDeclaration : ('module' MODULEID)? (definitionExpression)* expression ;

definitionExpression : ID '=' expression ;

functionDeclaration : 'f' '(' (ID (',' ID)* )? ')' ':' (definitionExpression)* expression ;

invokeExpression : ID '(' (expression (',' expression)* )? ')' ;

ifExpression : (conditionClause)+ (elseClause)? ;

conditionClause : '(' booleanExpression ')' '->' expression ;

elseClause : '_' '->' expression ;

expression
    : computedExpression
    | mathExpression
    | stringExpression
    | booleanExpression
    | compareExpression
    ;

computedExpression
    : ifExpression
    | functionDeclaration
    | invokeExpression
    | ID
    ;

booleanExpression
    : '(' booleanExpression ')'
    | TRUE
    | FALSE
    | booleanExpression AND booleanExpression
    | booleanExpression OR booleanExpression
    | computedExpression
    | compareExpression
    | equalityExpression
    ;

equalityExpression
    : '(' equalityExpression ')'
    | equalityOperand EQ equalityOperand
    | equalityOperand NEQ equalityOperand
    ;

equalityOperand
    : TRUE
    | FALSE
    | stringExpression
    | computedExpression
    | mathExpression
    | compareExpression
    ;

compareExpression
    : '(' compareExpression ')'
    | mathExpression GT mathExpression
    | mathExpression LT mathExpression
    | mathExpression GE mathExpression
    | mathExpression LE mathExpression
    ;

mathExpression
    : '(' mathExpression ')'
    | NUMBER
    | mathExpression MUL mathExpression
    | mathExpression DIV mathExpression
    | mathExpression PLUS mathExpression
    | mathExpression MINUS mathExpression
    | computedExpression
    ;

stringExpression
    : STRING
    | stringExpression PLUS stringExpression
    | stringExpression PLUS mathExpression
    | mathExpression PLUS stringExpression
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
