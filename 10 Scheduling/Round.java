//package round_robin;

import java.util.Scanner;

public class Round {

	int burst[],run[],np,quantom=0,wait[],time=0,rp=0,ta[];

	public Round(){
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter the number of pro: ");
		np=sc.nextInt();
		rp=np;
		burst=new int[np];
		run=new int[np];
		wait=new int[np];
		ta=new int[np];
		System.out.println("Enter their burst times: ");
		for(int i=0;i<np;i++){
			burst[i]=sc1.nextInt();
			run[i]=burst[i];
			wait[i]=0;
		}
		System.out.println("Enter Quantom: ");
		quantom=sc.nextInt();
		logic();
	}
	public void logic(){
		int i=0;
		while(rp!=0){
			if(run[i]>quantom){
				run[i]=run[i]-quantom;
				time=time+quantom;
				/*if(run[i]==0){
					ta[i]=time;
					rp--;
				}*/
				System.out.println("Process: "+i+"time: "+time);
			}
			else if(run[i]<=quantom && run[i]>0){
				time=time+run[i];
				run[i]=run[i]-run[i];
				ta[i]=time;
				rp--;
				System.out.println("Process: "+i+"time: "+time);
			}
			i++;
			if(i==np){
				i=0;
			}
		}
		for(int j=0;j<np;j++){
			wait[j]=ta[j]-burst[j];
			System.out.println(ta[j]);
			System.out.println(" ");
			System.out.println(wait[j]);
		}

	}
	public static void main(String[] args) {
		new Round();
	}
}
