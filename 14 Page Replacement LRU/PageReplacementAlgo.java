package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;


public class PageReplacementAlgo {

	private void optimal() {

		
		
	}

	
	
	
	private void lru() {
		int fsize=0,page_fault=0,page_hit=0,nop=15;
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter No. Of Pages :");
		//nop=sc.nextInt();

		HashSet <Integer> s =new HashSet<>(nop);
		HashMap <Integer,Integer> indexes =new HashMap<>();
		int pages[] = new int[] {7,0,1,2,0,3,0,4,2,3,0,3,1,2,0};
		
		System.out.println("Enter Frame Size :");
		fsize = sc.nextInt();
		
	/*	System.out.println("Enter Pages :");
		for(int i=0;i<nop;i++) {
			pages[i]=sc.nextInt();
		}*/
		
		for(int i=0;i<nop;i++) {
			if(s.size()<fsize) {
				if(!s.contains(pages[i])) {
					s.add(pages[i]);
					page_fault++;
				}else {
					page_hit++;
				}
				indexes.put(pages[i],i);
			}else {
				int lru=Integer.MAX_VALUE,val=Integer.MIN_VALUE;
				Iterator <Integer> itr = s.iterator();
				while(itr.hasNext()) {
					int temp = itr.next();
					if(indexes.get(temp)<lru) {
						lru = indexes.get(temp);
						val = temp;
					}
				}
				if(!s.contains(pages[i])) {
					s.add(pages[i]);
					page_fault++;
				}else {
					page_hit++;
				}

				s.remove(val);
				s.add(pages[i]);
				indexes.put(pages[i],i);
			}
			System.out.println(" "+s);
		}
		System.out.println("Faults "+page_fault);
		System.out.println("Hits "+page_hit);
		
}
		
	
	public static void main(String args[])
	{
		PageReplacementAlgo P =new PageReplacementAlgo();
		P.lru();
		//P.optimal();
				
	}
	
}
