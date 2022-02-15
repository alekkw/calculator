package desmos;

public class betterCalc {


	public int[] betterPow(int power) {
		int[] num = {2};
		int[] finarr = new int[0];
		
		for(int x = 0; x <= power; x++) {
			for(int z = num.length - 1; z >= 0; z--) {
				if((num[z] * 2) > 9) {
					if(num.length - 1 == z) {
						num = addRow(num);	
					}
					num[z] = (((num[z] * 2) % 10));
					num[z + 1] = (((num[z + 1])) + 1);
				}else {
					num[z] = (((num[z] * 2)));
				}
			}
		}
		
		for(int y = num.length - 1; y >= 0; y--) {
			finarr = addRow(finarr);
			finarr[finarr.length - 1] = num[y];
		}
		
		for(int x = 0; x < finarr.length; x++) {
			//System.out.print(finarr[x]);
		}
		//System.out.println();
		return finarr;
		
	}
	
	public int[] evenBetterPow(int[] startingNum ,int power) {
		int[] finNum = startingNum;
		for(int x = 0; x < power; x++) {
			finNum = betterMult(finNum, 2);
		}
		return finNum;
		
		
	}
	
	public int[] betterDiv(int arr[], int divisor) {
		int[] divArr = new int[1];
		int remaind = 0;
		int dividend = 0;
		
		for(int x = 0; x < arr.length; x++) {
			dividend = 0;
			arr[x] = arr[x] + (10 * remaind);
			if(((double) arr[x] / divisor) != Math.round((double) arr[x] / divisor)) {
				while(arr[x] > divisor) {
					arr[x] = arr[x] - (divisor);
					dividend++;
				}
				remaind = arr[x];
				if((x == arr.length - 1) && remaind > 0) {
					System.err.println("Number not divisible by " + divisor);
					System.exit(0);
				}
				divArr[x] = dividend;
				if(x != arr.length - 1) {
					divArr = addRow(divArr);
				}
				
			}else {
				remaind = 0;
				divArr[x] = arr[x] / divisor;
				if(x != arr.length - 1) {
					divArr = addRow(divArr);
				}
			}
		}
		
		for(int x = 0; x < divArr.length; x++) {
			//System.out.print(divArr[x]);
		}
		//System.out.println();
		
		return divArr;
	}
	
	public int[] betterMult(int arr[], int mult) {
		int[] num = new int[0];
		int[] finarr = new int[0];
		for(int y = arr.length - 1; y >= 0; y--) {
			num = addRow(num);
			num[num.length - 1] = arr[y];
		}
		for(int z = num.length - 1; z >= 0; z--) {
			if((num[z] * mult) > 9) {
				if(num.length - 1 == z) {
					num = addRow(num);	
				}
				num[z] = (((num[z] * mult) % 10));
				num[z + 1] = (((num[z + 1])) + 1);
			}else {
				num[z] = (((num[z] * mult)));
			}
		}
		
		for(int y = num.length - 1; y >= 0; y--) {
			finarr = addRow(finarr);
			finarr[finarr.length - 1] = num[y];
		}
		
		for(int x = 0; x < finarr.length; x++) {
			//System.out.print(finarr[x]);
		}
		//System.out.println();
		return finarr;
	}
	
	public int[] betterSub(int arr[], int diff) {
		int carry = 0;
		for(int x = arr.length - 1; x >= 0; x--) {
			arr[x] = arr[x] + carry;
			if(arr[x] - diff < 0) {
				arr[x] = 10 - diff;
				
			}else {
				arr[x] = arr[x] - diff;
				break;
			}
		}
		
		for(int x = 0; x < arr.length; x++) {
			//System.out.print(arr[x]);
		}
		//System.out.println();
		return arr;
	}
	
	public int[] betterAdd(int[] arr, int add) {
		arr[arr.length - 1] = arr[arr.length - 1] + add;
		for(int x = arr.length - 1; x >=0; x--) {
			if(arr[x] > 9 && x != 0) {
				arr[x] = arr[x] - 10;
				arr[x - 1] = arr[x - 1] + 1;
			}else if(arr[x] > 9 && x == 0) {
				arr[x] = arr[x] - 10;
				arr = addRow(arr);
				arr[x] = arr[x] + 1;
			}
		}
		
		for(int x = 0; x < arr.length; x++) {
			//System.out.print(arr[x]);
		}
		//System.out.println();
		return arr;
	}
	
	public int[] addRow(int arr[]) {
		int[] finarr = new int[arr.length + 1];
		
		for(int x = 0; x < arr.length; x++) {
			finarr[x] = arr[x];
		}
		
		return finarr;
	}
	
	public int[] cleanArr(int[] arr) {
		for(int x = 0; x < arr.length; x++) {
			if(arr[x] != 0) {
				break;
			}
			arr = remRow(arr);
			if(arr[x] != 0) {
				break;
			}
		}
		return arr;
	}
	
	public int[] remRow(int[] arr) {
		int[] finarr = new int[arr.length - 1];
		for(int x = finarr.length - 1; x >= 0; x--) {
			finarr[x] = arr[x + 1];
		}
		return finarr;
	}
	
	public boolean divCheck(int arr2[], int divisor) {
		int[] arr = main.powerSaves.clone();
		for(int x = 0; x < arr.length; x++) {
			System.out.print(arr[x]);
		}
		System.out.println();
		for(int x = main.trialNum; x < arr2.length - 1; x++) {
			switch(arr2[x]) {
			case 1:
				arr = betterMult(arr, 2);
				break;
			case 0:
				arr = betterSub(arr, 1);
				arr = betterDiv(arr, 3);
				break;
			}
		}
		arr = betterSub(arr, 1);
		int[] divArr = new int[1];
		int remaind = 0;
		int dividend = 0;
		for(int x = 0; x < arr.length; x++) {
			dividend = 0;
			arr[x] = arr[x] + (10 * remaind);
			if(((double) arr[x] / 3) != Math.round((double) arr[x] / 3)) {
				while(arr[x] > divisor) {
					arr[x] = arr[x] - (divisor);
					dividend++;
				}
				remaind = arr[x];
				if((x == arr.length - 1) && remaind > 0) {
					return false;
				}
				divArr[x] = dividend;
				if(x != arr.length - 1) {
					divArr = addRow(divArr);
				}
			}else {
				remaind = 0;
				divArr[x] = arr[x] / 3;
				if(x != arr.length - 1) {
					divArr = addRow(divArr);
				}
			}
		}
		for(int x = 0; x < divArr.length; x++) {
		}
		return true;
	}
	
	

}
