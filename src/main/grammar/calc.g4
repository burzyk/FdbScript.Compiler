
// Define a grammar called Hello
grammar calc;



cmd : 'CALC' expr ;

expr : NUMBER  { System.out.println($NUMBER.text); }
	| expr '*' expr
	| expr '/' expr
	| expr '+' expr
	| expr '-' expr
	;



WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
NUMBER : [0-9]+ ;
ID : [a-z]+ ;

