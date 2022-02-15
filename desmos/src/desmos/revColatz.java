package desmos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class revColatz {
	public revColatz(BufferedWriter out, int[] groups, int trial, int ... seq) throws IOException {
		
		int[] fin = {1};
		fin = main.getPowers();
		betterCalc calc = new betterCalc();
		int[] getGroups = main.getGroup;
		
		
		String Str = new String();
		
		for(int x = trial; x < seq.length; x++) {
			Str = Str + String.valueOf(seq[x]);
			if(seq[x] == 0) {
				fin = calc.betterSub(fin, 1);
				fin = calc.betterDiv(fin, 3);
			}else {
				fin = calc.betterMult(fin, 2);
			}
			
		}
		String[] arrStr = Str.split("0");
		
		
			boolean hasGroup = false;
			int groupNum = arrStr.length;
			for(int x = 0; x < groups.length; x++) {
				if(groups[x] == groupNum) {
					hasGroup = true;
				}
			}
			if(!hasGroup) {
				calc.addRow(groups);
				groups[groups.length - 1] = groupNum;
				main.addGroupID(groupNum);
			}
			for(int x = 0; x < groups.length; x++) {
				if(arrStr.length == groups[x]) {
					int pos = trial / 2;
					main.allGroups[pos][0] = groups[x];
					out.write("eRCC : " + Str.length() + "\t" + "eS: " + arrStr.length + "\t" + "Group: " + groups[x]);
					if(getGroups.length != 1) {
						calc.addRow(getGroups);
					}
					getGroups[getGroups.length - 1] = groups[x];
				}
			}
			out.newLine();
			
			
			
				
		
		
			
		
		
	}
	
	
	public revColatz(int ... seq) throws IOException {
		int[] fin = {1};
		betterCalc calc = new betterCalc();
		
		String Str = new String();
		
		for(int x = 0; x < seq.length; x++) {
			Str = Str + String.valueOf(seq[x]);
			if(seq[x] == 0) {
				fin = calc.betterSub(fin, 1);
				fin = calc.betterDiv(fin, 3);
			}else {
				fin = calc.betterMult(fin, 2);
			}
			
		}
		fin = calc.cleanArr(fin);
		for(int z = 0; z < fin.length; z++) {
			System.out.print(fin[z]);
		}
		
		
	}
	
	public static boolean stu(double test, double ... seq2) {
		betterCalc calc = new betterCalc();
		int[] fin = {1};
		double[] seq = new double[seq2.length + 1];
		for(int z = 0; z < seq2.length; z++) {
			seq[z] = seq2[z];
		}
		seq[seq.length - 1] = test;
		
		String Str = new String();
		
		for(int x = 0; x < seq.length; x++) {
			Str = Str + String.valueOf(seq[x]);
			if(seq[x] == 0) {
				fin = calc.betterSub(fin, 1);
				if(calc.divCheck(fin, 3)) {
					return false;
				}else {
					try {
						fin = calc.betterDiv(fin, 3);
					}catch(Exception e) {
						System.out.println("Very sad, program crash");
					}
					
				}
				
			}else {
				fin = calc.betterMult(fin, 2);
			}
			
		}
		String[] arrStr = Str.split("0");
			return true;
		
		
	}

}
