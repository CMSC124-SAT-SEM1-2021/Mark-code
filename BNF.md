<assign> 	::= 'begin' <statement> 'end'
<statement> 	::= <var> '=' <expression> ';' | <var> '=' <expression>; <equality>
<expression>	::= <expression> <operaton> <expression> | <expression> | '(' <expression> ')' |<var>
<var>		::= 'A' | 'B' | 'C' | 'D' | 'E' | 'F'
<operation> 	::= '+' | '-' | '/' | '*' | '%' 


