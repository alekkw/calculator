package desmos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class revColMap{
	
	public revColMap(int ider, BufferedWriter out) throws IOException {
		int[] arr = new int[0];
		arr = main.getBase();
		arr = addRow(arr);
		arr[arr.length - 1] = 0;
		arr = findMax(arr, ider);
		//arr = remRow(arr);
		//arr = remRow(arr);
		//arr = remRow(arr);
		int[] arr2 = new int[arr.length];
		
		for(int p = 0; p < arr.length; p++) {
			arr2[p] = (int)arr[p];
		}
		desmos.main.getArr(arr2);
		
		
		for(int z = 0; z < arr.length; z++) {
			out.write((int) arr[z] + ",");
		}
		out.newLine();
		
	}
	
	public int[] findMax(int arr[], int ider) {
		if(checkDigits(arr, 1, 1, 0) == true) {
			arr = addRow(arr);
			arr[arr.length - 1] = 1;
			arr = addRow(arr);
			arr[arr.length - 1] = 1;
			arr = addRow(arr);
			arr[arr.length - 1] = 0;
			arr = findMax(arr,ider);
		}else if(checkDigits(arr, 1, 0) == true) {
			arr = addRow(arr);
			arr[arr.length - 1] = 1;
			arr = addRow(arr);
			arr[arr.length - 1] = 0;
			arr = findMax(arr,ider);
		}
	
		
		
		
		/*while(stu((double)0, arr) == true || (arr[arr.length - 1] == 0 || arr[arr.length - 2] == 0 || arr[arr.length - 3] == 0 || arr.length == ider)) {
		if(stu((double)0, arr) == true && arr[arr.length - 1] != 0) {
			arr = addRow(arr);
			arr[arr.length - 1] = 0;
			arr = findMax(arr, ider);
		}else {
			arr = addRow(arr);
			arr[arr.length - 1] = 1;
			arr = findMax(arr, ider);
		}
		}
		
		*/
		
		return arr;
	}
	
	public int[] addRow(int[] arr) {
		int[] finarr = new int[arr.length + 1];
		for(int x = 0; x < arr.length; x++) {
			finarr[x] = arr[x];
		}
		return finarr;
	}
	public int[] remRow(int[] arr) {
		int[] finarr = new int[arr.length - 1];
		for(int x = 0; x < finarr.length; x++) {
			finarr[x] = arr[x];
		}
		return finarr;
	}
	
	public static boolean stu(double test, int ... seq2) {
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
				
				
				int[] fin2 = fin.clone();
				if(!calc.divCheck(fin2, 3)) {
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
	
	public boolean checkDigits(int[] seq, int... addedAttemptDigits) {
		betterCalc calc = new betterCalc();
		for(int x = 0; x < addedAttemptDigits.length; x++) {
			seq = calc.addRow(seq);
			switch((int)addedAttemptDigits[x]) {
			case 1:
				seq[seq.length - 1] = 1;
				break;
			case 0:
				int[] seq2 = seq.clone();
				if(calc.divCheck(seq2, 3)) {
					seq[seq.length - 1] = 0;
				}else {
					return false;
				}
				break;
			}
		}
		return true;
	}

}


