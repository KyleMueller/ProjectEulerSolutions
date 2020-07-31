
public class Project030 {
	/**
	 * https://projecteuler.net/problem=30
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 2; i < 1000000; i++) {
			if(sumCheck(i)) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}
	public static boolean sumCheck(int a) {
		String str = a + "";
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			int dig = Integer.parseInt(str.charAt(i) + "");
			int power = (int) Math.pow(dig, 5);
			sum = sum + power;
		}
		if(sum == a) {
			return true;
		}
		
		return false;
	}

}
