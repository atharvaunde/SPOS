%{
	#include<stdio.h>
	void yyerror(char *s);
%}
	%token VERB ADVERB NOUN ADJECTIVE SPACE CONJUCTION PRONOUN ARTICLE PREPO
%%
	start: simple {printf("SIMPLE");} | compound {printf("COMPOUND");}
;
	simple:		SUBJECT SPACE VERB SPACE OBJECT 
;
	compound: simple SPACE CONJUCTION SPACE simple
;
	SUBJECT:NOUN | PRONOUN
;
	OBJECT:NOUN | PRONOUN
;
%%
void main(){
	yyparse();
}
void yyerror(char *s)
{
	printf("%s\n",s);
}
