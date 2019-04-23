package algorithms;

import java.util.Scanner;

public class Schedule {

	
	Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		Schedule A =new Schedule();
		//A.FCFS();
		//A.SJF();
		A.Priority();
	}
	
	private void Priority() {
		System.out.println("Enter No. Of process :");
		int nop = sc.nextInt();
		
		String pname[]=new String[]{"p1","p2","p3","p4","p5"};
		int arr_time[]=new int[]{0,1,2,3,4};
		int burst_time[]=new int[]{4,3,1,5,2};
		int priority[]=new int[]{2,3,4,5,5};

		int[] completion_time = new int[nop];
		int[] turn_around_time = new int[nop];
		int[] waiting_time = new int[nop];

		
		/*for(int i=0;i<nop;i++)
		{
			System.out.println("Enter Process | Enter Arrival Time | Enter Burst Time ");
			pname[i]=sc.next();
			arr_time[i]=sc.nextInt();
			burst_time[i]=sc.nextInt();
		}
*/
		
		for(int i=0;i<nop-1;i++)
		{
			for(int j=i+1;j<nop;j++)
			{
				if(arr_time[i] > arr_time[j])
				{
					int temp = arr_time[i];
					arr_time[i]=arr_time[j];
					arr_time[j]=temp;

					temp = burst_time[i];
					burst_time[i]=burst_time[j];
					burst_time[j]=temp;

					temp = priority[i];
					priority[i]=priority[j];
					priority[j]=temp;
					
					String tem = pname[i];
					pname[i]=pname[j];
					pname[j]=tem;
				}
			}
		}
		for(int i=1;i<nop-1;i++)
		{
			for(int j=i+1;j<nop;j++)
			{
				if(priority[i] < priority[j])
				{
					int temp = arr_time[i];
					arr_time[i]=arr_time[j];
					arr_time[j]=temp;

					temp = burst_time[i];
					burst_time[i]=burst_time[j];
					burst_time[j]=temp;
					
					temp = priority[i];
					priority[i]=priority[j];
					priority[j]=temp;

					String tem = pname[i];
					pname[i]=pname[j];
					pname[j]=tem;
				}
			}
		}
		
		
		for(int i=0;i<nop;i++)
		{
			if(i==0)
			completion_time[i]=arr_time[i]+burst_time[i];
			else {
				completion_time[i]=completion_time[i-1]+burst_time[i];
			}
			turn_around_time[i]=completion_time[i]-arr_time[i];
			waiting_time[i]=turn_around_time[i]-burst_time[i];
		}
		
		System.out.println("Process "+"Arrival Time "+"Burst Time "+"turn_around_time "+"waiting_time");
		for(int i=0;i<nop;i++)
		{
			System.out.println(pname[i]+"\t"+arr_time[i]+"\t"+burst_time[i]+"\t"+completion_time[i]+"\t"+turn_around_time[i]+"\t"+waiting_time[i]);
		}

		
	}

	private void SJF() {
		System.out.println("Enter No. Of process :");
		int nop = sc.nextInt();
		
		String pname[]=new String[]{"p1","p2","p3","p4","p5"};
		int arr_time[]=new int[]{3,1,4,0,2};
		int burst_time[]=new int[]{1,4,2,6,3};

		int[] completion_time = new int[nop];
		int[] turn_around_time = new int[nop];
		int[] waiting_time = new int[nop];

		
		/*for(int i=0;i<nop;i++)
		{
			System.out.println("Enter Process | Enter Arrival Time | Enter Burst Time ");
			pname[i]=sc.next();
			arr_time[i]=sc.nextInt();
			burst_time[i]=sc.nextInt();
		}
*/
		
		for(int i=0;i<nop-1;i++)
		{
			for(int j=i+1;j<nop;j++)
			{
				if(arr_time[i] > arr_time[j])
				{
					int temp = arr_time[i];
					arr_time[i]=arr_time[j];
					arr_time[j]=temp;

					temp = burst_time[i];
					burst_time[i]=burst_time[j];
					burst_time[j]=temp;
					
					String tem = pname[i];
					pname[i]=pname[j];
					pname[j]=tem;
				}
			}
		}
		for(int i=1;i<nop-1;i++)
		{
			for(int j=i+1;j<nop;j++)
			{
				if(burst_time[i] > burst_time[j])
				{
					int temp = arr_time[i];
					arr_time[i]=arr_time[j];
					arr_time[j]=temp;

					temp = burst_time[i];
					burst_time[i]=burst_time[j];
					burst_time[j]=temp;
					
					String tem = pname[i];
					pname[i]=pname[j];
					pname[j]=tem;
				}
			}
		}
		
		
		for(int i=0;i<nop;i++)
		{
			if(i==0)
			completion_time[i]=arr_time[i]+burst_time[i];
			else {
				completion_time[i]=completion_time[i-1]+burst_time[i];
			}
			turn_around_time[i]=completion_time[i]-arr_time[i];
			waiting_time[i]=turn_around_time[i]-burst_time[i];
		}
		
		System.out.println("Process "+"Arrival Time "+"Burst Time "+"turn_around_time "+"waiting_time");
		for(int i=0;i<nop;i++)
		{
			System.out.println(pname[i]+"\t"+arr_time[i]+"\t"+burst_time[i]+"\t"+completion_time[i]+"\t"+turn_around_time[i]+"\t"+waiting_time[i]);
		}

	}

	private void FCFS() {
		
		System.out.println("Enter No. Of process :");
		int nop = sc.nextInt();
		
		String pname[]=new String[nop];
		int arr_time[]=new int[nop];
		int burst_time[]=new int[nop];

		int[] completion_time = new int[nop];
		int[] turn_around_time = new int[nop];
		int[] waiting_time = new int[nop];

		
		for(int i=0;i<nop;i++)
		{
			System.out.println("Enter Process | Enter Arrival Time | Enter Burst Time ");
			pname[i]=sc.next();
			arr_time[i]=sc.nextInt();
			burst_time[i]=sc.nextInt();
		}

		for(int i=0;i<nop-1;i++)
		{
			for(int j=i+1;j<nop;j++)
			{
				if(arr_time[i] > arr_time[j])
				{
					int temp = arr_time[i];
					arr_time[i]=arr_time[j];
					arr_time[j]=temp;

					temp = burst_time[i];
					burst_time[i]=burst_time[j];
					burst_time[j]=temp;
					
					String tem = pname[i];
					pname[i]=pname[j];
					pname[j]=tem;
				}
			}
		}
		
		for(int i=0;i<nop;i++)
		{
			if(i==0)
			{
				completion_time[i]=arr_time[i]+burst_time[i];
				turn_around_time[i]=completion_time[i]-arr_time[i];
				waiting_time[i]=turn_around_time[i]-burst_time[i];
			}
			else {
				if(arr_time[i] > completion_time[i])
				{
					completion_time[i]=arr_time[i]+burst_time[i];
				}
				else
				{
					completion_time[i]=completion_time[i-1]+burst_time[i];
				}
			}
			turn_around_time[i]=completion_time[i]-arr_time[i];
			waiting_time[i]=turn_around_time[i]-burst_time[i];

		}
		
		System.out.println("Process "+"Arrival Time "+"Burst Time "+"turn_around_time "+"waiting_time");
		for(int i=0;i<nop;i++)
		{
			System.out.println(pname[i]+"\t"+arr_time[i]+"\t"+burst_time[i]+"\t"+turn_around_time[i]+"\t"+waiting_time[i]);
		}

	}
}
