package pass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Macro {

	String MDT[]=new String[30];
	int MNTP=0,MDTP=0;
	MacroNameTable MNT[]=new MacroNameTable[2];
	//HashMap <String,Integer> MNT[] = new HashMap<>();
	private void pass1() throws Exception {
		
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String line="";
		while((line=br.readLine())!=null) {
			//if(!line.equalsIgnoreCase("MEND")) {
				if(line.equalsIgnoreCase("MACRO")) {
					line = br.readLine();
					String keys[] = line.split(" ");
					int len = keys.length;
					MNT[MNTP] = new MacroNameTable(keys[0],MDTP,len-1);
					MNTP++;
				}
				else {
					MDT[MDTP]=line;
					MDTP++;
				}
			//}
		}
		/*System.out.println("Macro Defination :");
		for(int i=0;i<MDT.length;i++)
		{
			System.out.println(i+"Macro Name :"+MDT[i]);
		}
		for(int i=0;i<MNT.length-2;i++)
		{
			System.out.println("Macro Name :"+MNT[i].name);
			System.out.println("Macro Index :"+MNT[i].index);
			System.out.println("Macro Parameters :"+MNT[i].parameters);
		}*/
		
	}

	
	private void pass2() throws Exception {
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("output.txt");
		BufferedWriter wr = new BufferedWriter(fw);
		String line="",line1="";
		while((line=br.readLine())!=null) {
			String split[] = line.split(" ");
			if(split[0].equalsIgnoreCase("START")) {
				
				while((line1=br.readLine())!=null) {
					String split1[] = line1.split(" ");					
					for(int i=0;i<MNT.length;i++) {
						if((MNT[i].name).equalsIgnoreCase(split1[0])) {
							int mdtindex = MNT[i].index;
							int paralen = MNT[i].parameters;
							
							while(!MDT[mdtindex].equalsIgnoreCase("MEND")) {
								
								wr.write(MDT[mdtindex]+"\n");
								System.out.println(MDT[mdtindex]);
								
								mdtindex++;
							}
						}
					}
					wr.write(line1+"\n");
				}
			}
			else if(split[0].equalsIgnoreCase("END")) {
				break;
			}
			else {
				//wr.write(line+"\n");
			}

		}
		wr.close();
		fw.close();
		
	}
	
	
	public static void main(String args[]) throws Exception {
		Macro M = new Macro();
		M.pass1();
		M.pass2();
	}
}
