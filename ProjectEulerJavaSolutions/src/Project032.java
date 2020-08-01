
public class Project032 {
	/** https://projecteuler.net/problem=32
	 * 
We shall say that an n-digit number is pandigital if it makes use of all the digits 
1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, 
multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written 
as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once
 in your sum.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int[] backlog = new int[100];
		for(int i = 0; i < 100; i++) {
			backlog[i] = 0;
		}
		int count = 0;
		for(int i = 1; i < 10000; i++) {
			for(int j = i+1; j <10000; j++) {
				if(checkIt(i,j)) {
					int k = i*j;
					if(checkBackLog(k,backlog)) {
						sum = sum + k;
						backlog[count] = k;
						count++;
						System.out.println("A: " + i + "\tB: "+ j);
					}
				}
			}
		}
		System.out.println(sum);
		//45228 is the correct answer.

	}
	public static boolean checkBackLog(int a, int[]backlog) {
		for(int i = 0; i < backlog.length; i++) {
			if(a == backlog[i]) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkIt(int a, int b) {
		String strA = a + "";
		String strB = b + "";
		int c = a*b;
		String strC = c + "";
		String all = strA + strB + strC;
		if(all.length() != 9) {
			return false;
		}
		for(int i = 0; i < 9; i++) {
			if(all.charAt(i) == '0') {
				return false;
			}
			for(int j = i+1; j < 9; j++) {
				if(all.charAt(i) == all.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

}
