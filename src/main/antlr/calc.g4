
// Define a grammar called Hello
grammar Calc;



cmd : 'CALC' expr ;

expr : NUMBER
	| expr '*' expr
	| expr '/' expr
	| expr '+' expr
	| expr '-' expr
	;



WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
NUMBER : [0-9]+ ;
ID : [a-z]+ ;

