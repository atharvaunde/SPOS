%{
	#include<stdio.h>
	#include "y.tab.h"
%}
%%
	"and"|"or"|"but" 							{return CONJUCTION;}
	"sita"|"gita"|"teacher"|"english"|"mangoes" { return NOUN;}
	"he"|"she"|"it"|"they"|"we" 				{return PRONOUN;}
	"eats"|"eat"|"walks"|"walk"|"teaches"|"teach"|"is" {return VERB;}
	"a"|"an"|"the" 								{return ARTICLE;}
	"slow"|"fast" 								{return ADJECTIVE;}
	"slowly"|"plenty" 							{return ADVERB;}
	"of" 										{return PREPO;}
	[" "] {return SPACE;}
%%
int yywrap()
{
	return 1;
}