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

ifExpression : (conditionClause)+ (elseClause) ;

conditionClause : '(' expression ')' '->' expression ;

elseClause : '_' '->' expression ;

expression
    : valueExpression
    | mathExpression
    | compareExpression
    | logicalExpression
    ;

valueExpression
    : ifExpression
    | functionDeclaration
    | invokeExpression
    | '(' expression ')'
    | NOT expression
    | ID
    | TRUE
    | FALSE
    | NUMBER
    | STRING
    ;

mathExpression
    : multiplicativeExpression
    | additiveExpression
    ;

additiveExpression
    : additiveExpression PLUS multiplicativeExpression
    | additiveExpression MINUS multiplicativeExpression
    | multiplicativeExpression
    ;

multiplicativeExpression
    : multiplicativeExpression MUL valueExpression
    | multiplicativeExpression DIV valueExpression
    | valueExpression
    ;

compareExpression
    : compareExpression EQ mathExpression
    | compareExpression NEQ mathExpression
    | compareExpression GT mathExpression
    | compareExpression LT mathExpression
    | compareExpression GE mathExpression
    | compareExpression LE mathExpression
    | mathExpression
    ;

logicalExpression
    : logicalExpression AND compareExpression
    | logicalExpression OR compareExpression
    | compareExpression
    ;

EQ : '==' ;
GT : '>' ;
LT : '<' ;
GE : '>=' ;
LE : '<=' ;
NEQ : '!=' ;

AND : 'and' ;
OR : 'or' ;

NOT : '!' ;

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
