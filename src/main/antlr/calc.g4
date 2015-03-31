
// Define a grammar called Hello
grammar Calc;



cmd : 'CALC' expr ;

expr : NUMBER
	| expr MUL expr
	| expr DIV expr
	| expr PLUS expr
	| expr MINUS expr
	;



WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
NUMBER : [0-9]+ ;
ID : [a-z]+ ;
PLUS : '+' ;
MINUS : '-' ;
DIV : '/' ;
MUL : '*' ;

