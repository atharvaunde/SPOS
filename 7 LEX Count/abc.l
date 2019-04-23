%{
#include<stdio.h>
int wcnt=0;
int ccnt=0;
int lcnt=0;
int ncnt=0;
int dcnt=0;
%}

%%
[0-9]+ {ncnt++;dcnt=dcnt+yyleng;}
[^ \t\n]+ {wcnt++;ccnt=ccnt+yyleng;}
["\n"] {lcnt++;}

%%

void main()
{
FILE *fp;
fp= fopen("input.txt","r");
yyin=fp;
yylex();
printf("no of lines : %d",lcnt);
printf("\n no of words : %d",wcnt);
printf("\n no of charac : %d",ccnt);
printf("\n no of numbers : %d",ncnt);
printf("\n no of digits : %d",dcnt);

}
 
int yywrap()
{
return(1);
}
