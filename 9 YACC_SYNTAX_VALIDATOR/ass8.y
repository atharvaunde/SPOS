%{
	#include<stdio.h>
	void yyerror(char *s);
%}
%token DATATYPE IDENTIFIER SEMICOLON COMMA SPACE ACCESS COLON
%%
start:sent start |sent
;

	sent:ACCESS COLON DATATYPE SPACE varlist SEMICOLON {printf("VALID \n");} |
	ACCESS SPACE DATATYPE SPACE varlist SEMICOLON {printf("VALID \n");} | 
	DATATYPE SPACE varlist SEMICOLON {printf("VALID \n");}
;
	varlist:varlist COMMA IDENTIFIER| IDENTIFIER
;                       
%%
void main(){
yyparse();
}
void yyerror(char *s)
{
	printf("%s\n",s);
}
