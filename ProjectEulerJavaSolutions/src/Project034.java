
public class Project034 {
	/**
	 * https://projecteuler.net/problem=34
	 * 
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 3; i < 1000000; i++) {
			if(check(i)) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
		//40730 is the correct answer

	}
	public static boolean check(int a) {
		String strA = a + "";
		int sum = 0;
		for(int i = 0; i < strA.length(); i++) {
			int temp = Integer.parseInt(strA.charAt(i) + "");
			sum = sum + fact(temp);
		}
		if(sum == a) {
			return true;
		}
		
		return false;
	}
	public static int fact(int a) {
		int prod = 1;
		for(int i = a; i > 1; i--) {
			prod = prod*i;
		}
		return prod;
	}

}
