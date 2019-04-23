%{
#include<stdio.h>
#include "y.tab.h"
%}
%%
int|float|char|boolean 	{return DATATYPE;}
[a-zA-Z] {return IDENTIFIER;}
"," {return COMMA;}
";" {return SEMICOLON;}
":" {return COLON;}
[" "] {return SPACE;}
private|protected|default|public {return ACCESS;}
%%
int yywrap()
{
	return 1;
}
