//Java Class Header in EBNF:

<class-header> ::= ["public" | "private" | "protected"] "class" <class-name> ["extends" <superclass>] ["implements" <interface-list>]
<class-name> ::= <identifier>
<superclass> ::= <identifier>
<interface-list> ::= <identifier> {"," <identifier>}
<identifier> ::= <letter> {<letter> | <digit> | "_"}
<letter> ::= "a" | "b" | ... | "z" | "A" |  "B" | ... | "Z"
<digit> ::= "0" | "1" | ... | "9"


//Java Method Call Statement
<method-call> ::= <method-name> "(" [<argument-list>] ")"
<method-name> ::= <identifier>
<argument-list> ::= <expression> {"," <expression>}
<expression> ::= <identifier> | <literal> | <method-call>

// C switch Statement

<switch-statement> ::= "switch" "(" <expression> ")" "{" { <case> } [ <default> ] "}"
<case> ::= "case" <constant-expression> ":" {<statement>}
<default> ::= "default:" {<statement>}
<expression> ::= <identifier> | <literal> | <operation>
<constant-expression> ::= <literal> | <constant-identifier>


// C union Definition
<union-definition> ::= "union" <identifier> "{" {<union-member>} "}" [<variable-name>]
<union-member> ::= <type> <identifier> ";"
<type> ::= "int" | "float" | "char" | <custom-type> | ...


// C float literal
<float-literal> ::= <digits> "." <digits> [ <exponent> ]
<exponent> ::= ("e" | "E") [ "+" | "-" ] <digits>
<digits> ::= <digit> { <digit> }
<digit> ::= "0" | "1" | ... | "9"


