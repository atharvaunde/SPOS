#include<stdio.h>
void main()
{
	int c;
	while(1)
	{
		printf("1 : Running processes\n2 : Join processes\n3 : Create process\nEnter your choice\n");
		scanf("%d",&c);
		switch(c)
		{
			case 1:
			{
				system("ps");
			}break;
			case 2:
			{
				system("join text1.txt text2.txt > text3.txt");
			}break;
			case 3:
			{
				int pid;
				pid=fork();
				if(pid==0)
				{
					sleep(2);
					printf("child process\n");
					execl("/bin/ps","/bin/ps",NULL);
				}
				else
				{
					printf("parent process\n");
					wait();
				}
			}break;
		}		
	}
	
	
}

