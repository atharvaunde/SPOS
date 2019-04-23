package algorithm;

public class BankerAlgo 
{
		int m=3,n=5;
		int max[][]=new int[n][m];
		int alloc[][]=new int[n][m];
		int avail[]=new int[m];
		int need[][]=new int[n][m];
		public BankerAlgo(){
			
			  alloc = new int[][] { { 0, 1, 0 }, //P0    
								  { 2, 0, 0 }, //P1 
								  { 3, 0, 2 }, //P2 
								  { 2, 1, 1 }, //P3 
								  { 0, 0, 2 } }; //P4 
	            
              max = new int[][] { { 7, 5, 3 }, //P0 
				            	  { 3, 2, 2 }, //P1 
				            	  { 9, 0, 2 }, //P2 
				            	  { 2, 2, 2 }, //P3  
				            	  { 4, 3, 3 } }; //P4 
	      
			 avail = new int[] { 3, 3, 2 };  
		}

		private void calculateNeed() {
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)				{
					need[i][j]=max[i][j]-alloc[i][j];
				}
		}

		private void isSafe() {
			int count=0;
			int work[]=new int[m];
			boolean visited[]=new boolean[n];
			
			for(int i=0;i<n;i++) {
				visited[i]=false;
			}
			for(int i=0;i<m;i++) {
				work[i]=avail[i];
			}
			int safeSequence[] =new int[n];
			
			while(count<n) {
				boolean flage = false;

				for(int i=0;i<n;i++) {
					if(visited[i]==false) {
						int j;
						for(j=0;j<m;j++) {
							if(need[i][j] > work[j])
							{
								break;
							}
						}// end for ( j )
						if(j==m) {
							visited[i]=true;
							safeSequence[count++]=i;
							flage = true;
							for(int k=0;k<m;k++)
							{
								work[k]=work[k]+alloc[i][k];
							}
						}//end if()
					}//end if					
				}//for( i )
				if(flage == false)
					break;
			}//end While		
			if(count < n) {
				System.out.print("System not in safe mode");
			}
			else {
				System.out.println("safe sequence is =>");
				for(int i=0;i<n;i++)
				{
					System.out.print("->P"+safeSequence[i]);
				}
			}
		
		}//end of function Safe
		

		public static void main(String[] args) 
		{ 
			int i, j, k; 
			BankerAlgo B = new BankerAlgo(); 
				
			//Calculate the Need Matrix 
			B.calculateNeed();		 
					
			// Check whether system is in safe state or not 
			B.isSafe();	 
		}

} 

	
	
	
