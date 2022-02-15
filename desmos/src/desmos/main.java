package desmos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
	public static double[][] coord = new double[2][0];
	public static int[] bugArr;
	public static int[] saveGroups = {2};
	public static int[] getGroup = new int[1];
	public static int[][] allGroups = new int[501][1];
	public static int[] powerSaves = {4};
	public static int trialNum = 4;
	public static int[] listBases = {1,1};

	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		FileWriter write2 = new FileWriter("/Users/aleks/Downloads/revColMapData.txt");
		BufferedWriter out2 = new BufferedWriter(write2);
		out2.flush();
		
		
		FileWriter write = new FileWriter("/Users/aleks/Downloads/revColMap.txt");
		BufferedWriter out = new BufferedWriter(write);
		FileWriter write3 = new FileWriter("/Users/aleks/Downloads/groupDocs.txt");
		BufferedWriter out3 = new BufferedWriter(write3);
		out3.flush();
		out.flush();
		for(int x = 4; x <= 1000; x += 2) {
			trialNum = x;
			updatePowers();
			increaseBase();
			out.write("Trial " + x + "-> "); 
			revColMap col = new revColMap(x, out);
			out2.write("Trial " + x + "-> ");
			revColatz col2 = new revColatz(out2, saveGroups, x, bugArr);
		}
		
			for(int y = 0; y < saveGroups.length; y++) {
				System.out.println(saveGroups[y]);
				int priorVal = 0;
				for(int x = 0; x < allGroups.length; x++) {
				if(allGroups[x][0] == saveGroups[y]) {
					out3.write("Group ");
					out3.write(String.valueOf(allGroups[x][0]));
					out3.write(" found at Number ");
					out3.write(String.valueOf(x));
					out3.write(" With a difference of ");
					out3.write(String.valueOf(x - priorVal));
					out3.newLine();
					priorVal = x;
				}
				}
				out3.newLine();
				out3.newLine();
				out3.newLine();
			}
		out3.close();
		out2.close();
		out.close();
		
	

		
		
		//revColatz col = new revColatz(1,1,1,1,0,1,1,1,1,1,0);
		
	}
	public void saveArr(int[][] arr) {
		allGroups = arr;
	}
	public static void addGroupID(int x) {
		int[] groups = new int[saveGroups.length + 1];
		for(int z = 0; z < saveGroups.length; z++) {
			groups[z] = saveGroups[z];
		}
		groups[groups.length - 1] = x;
		saveGroups = groups;
		
	}
	
	public static void getArr(int[] arr) {bugArr = arr;}
	
	public static void increaseBase() {
		betterCalc calc = new betterCalc();
		listBases = calc.addRow(listBases);
		listBases[listBases.length - 1] = 1;
		listBases = calc.addRow(listBases);
		listBases[listBases.length - 1] = 1;
	}
	public static int[] getBase() {return listBases;}
	
	public static void updatePowers() {
		betterCalc calc = new betterCalc();
		powerSaves = calc.betterMult(powerSaves, 2);
		powerSaves = calc.betterMult(powerSaves, 2);
		
	}
	
	public static int[] getPowers() {int[] test = powerSaves;return test;}
	
	public static void revColGraph(int... seq) throws AWTException, InterruptedException {
		Robot r = new Robot();
		Thread.sleep(5000);
		for(int x = 0; x < seq.length; x++) {
			char f = (char) x;
			char s = (char) seq[x];
			r.keyPress(KeyEvent.getExtendedKeyCodeForChar(s));
			r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(s));
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			Thread.sleep(10);
			r.keyPress(KeyEvent.getExtendedKeyCodeForChar(f));
			r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(f));
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(10);
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
			Thread.sleep(50);
		}
	}
	
	
	public static void desmos() throws AWTException, InterruptedException {
		coord = hypotenuse(7, coord, 7	, 0, 2);
		
		coord = addMArr(coord);
		coord[0][coord[0].length - 1] = 2;
		coord[1][coord[1].length - 1] = 0;
		
		addData(coord);
	}
	
	//cycles starts at -1;
	public static double[][] hypotenuse(double cycles, double[][] coords, double scale, double x, double y) {
		double length = Math.pow(0.5, scale);
		coords = addMArr(coords);
		
		if(scale % 2 == 0) {
			if(Math.abs(cycles) % 2 == 1 && cycles != scale) {
				x += length;
			}
			if(Math.abs(cycles) % 2 == 0 && cycles != scale) {
				y -= length;
			}
		}else if(scale % 2 == 1) {
			if(Math.abs(cycles) % 2 == 0 && cycles != scale) {
				x += length;
			}
			if(Math.abs(cycles) % 2 == 1 && cycles != scale) {
				y -= length;
			}
		}
		coords[0][(int) (scale - cycles)] = x;
		coords[1][(int) (scale - cycles)] = y;
		
		if(x != 2 && y != 0) {
			coords = hypotenuse(cycles - 1, coords, scale, x, y);
		}
		
		return coords;
		
	}
	
	public static double[][] addMArr(double arr[][]) {
		double[][] returnArr = new double[arr.length][];
		for(int x = 0; x < arr.length; x++) {
			returnArr[x] = new double[arr[x].length + 1];
		}
		for(int x = 0; x < arr.length; x++) {
			for(int y = 0; y < arr[x].length; y++) {
				returnArr[x][y] = arr[x][y];
			}
		}
		return returnArr;
	}
	
	public static void addData(double[][] arr) throws AWTException, InterruptedException {
		Robot r = new Robot();
		char c;
		
		Thread.sleep(5000);
		
		for(int x = 0; x < arr.length; x++) {
			for(int y = 0; y < arr[x].length; y++) {
				
				int e = 0, f = 0;
				
				String a = String.valueOf(arr[x][y]);
				int d = a.length();
				
				while(e < d) {
					c = a.charAt(e);
					f = (int) c;
					r.keyPress(KeyEvent.getExtendedKeyCodeForChar(f));
				     e++;
				    r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(f));
				    Thread.sleep(20);
				}
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				
				
			}
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			for(int z = 0; z < arr[1].length; z++) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}
		
		}
		
	}

}


