%option noyywrap
%{
#include<stdio.h>
%}
%%
"public"|"static"|"void"|"main"|"class"|"String"|"args"|"int"|"float"|"char"|"System.out.println"|"return"	{printf("%s:\tkeYWORDS\n",yytext);}
"{"		{printf("%s:\tOpening curly bracket\n",yytext);}
"}"		{printf("%s:\tClosing curly bracket\n",yytext);}
"("		{printf("%s:\tOpening round bracket\n",yytext);}
")"		{printf("%s:\tClosing round bracket\n",yytext);}
"["		{printf("%s:\tOpening square bracket\n",yytext);}
"]"		{printf("%s:\tClosing square bracket\n",yytext);}
[0-9]+	{printf("%s:\tInteger Number\n",yytext);}
";"|","	{printf("%s:\tdelimiter\n",yytext);}
"+"|"-"|"*"|"/"|"%" 	{printf("%s:\tArithmatic Operators\n",yytext);}
"++"|"--""=="|"!="|">"|"<"|">="|"<="|"&&"|"||"|"!"		{printf("%s:\tLogical Operators\n",yytext);}
"&"|"|"|"^"|"~"|">>"|"<<" {printf("%s:\tBitwise Operators\n",yytext);}
"="		{printf("%s:\tAssignment Operator\n",yytext);}
'.'		{printf("%s:\tCharacter constant\n",yytext);}
\"([^\\\"]|\\.)*\"
"."	{printf("%s:\tDot\n",yytext);}
[a-zA-Z][a-zA-Z0-9]* 	{printf("%s:\tUserdefined Variable\n",yytext);}
"//"[^\n]*[/][*][^*]*[*]+([^*/][^*]*[*]+)*[/] 	{printf("%s:\tMulti Line Comment\n",yytext);}

%%
int main()
{
FILE *f;
f=fopen("sample.java","r");
if (f==NULL)
{
	printf("\nError in Opening file\n");
}
else
{
	yyin=f;
}
yylex();
return 1;
}
