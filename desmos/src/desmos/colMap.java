package desmos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class colMap {
	
	public colMap() throws IOException {
		int arr[];
		int rounds = 0;
		FileWriter write = new FileWriter("/Users/aleks/Downloads/ColatzMap.txt");
		BufferedWriter out = new BufferedWriter(write);
		out.flush();
		int fourZero = 0;
		int fourOne = 0;
		
		for(int p = 1; p < 100000; p++) {
		if(prime(p) == false) {
			
		}
		
		int x = p;
		int pe = p;
		
		while(x != 1) {
			if(x % 2 == 1) {
				x = 3 * x + 1;
				rounds++;
			}else {
				x = x / 2;
				rounds++;
			}
		}
		
		arr = new int[rounds];
		
		while(pe != 1) {
			if(pe % 2 == 1) {
				arr[rounds - 1] = 0;
				pe = 3 * pe + 1;
				rounds--;
			}else {
				arr[rounds - 1] = 1;
				pe = pe / 2;
				rounds--;
			}
		}
		
		if(p < 10) {
			out.write(" ");
		}
		out.write(p + ":" + " ");
		for(int z = 0; z < arr.length; z++) {
			out.write("[" + arr[z] + "]" + " ");
		}
		
		/*if(arr.length > 6) {
			if (arr[6] == 0) {
				fourZero++;
			}else {
				fourOne++;
			}
		}
		*/ 
		
		out.newLine();
		
	}
		out.write("Even: " + fourOne + "\t" + "Odd: " + fourZero);
		out.close();
	}
	
	public boolean prime(int x) {
		
		for(int i = 2; i < x; i++) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	
	
	

}
