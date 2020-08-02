
public class Project036 {
	/**
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in
 base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 1; i < 1000000; i++) {
			if(checkPalindrome(i)) {
				if(checkPalindrome(Integer.toBinaryString(i))) {
					sum = sum + i;
				}
			}
		}
		System.out.println(sum);
		//872187 is the correct answer
	}
	public static boolean checkPalindrome(int A) {
		String aStr = A + "";
		for (int i = 0; i < aStr.length(); i++) {
			char front = aStr.charAt(i);
			char back = aStr.charAt(aStr.length()-i-1);
			if (front != back) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkPalindrome(String A) {
		String aStr = A + "";
		for (int i = 0; i < aStr.length(); i++) {
			char front = aStr.charAt(i);
			char back = aStr.charAt(aStr.length()-i-1);
			if (front != back) {
				return false;
			}
		}
		return true;
	}

}
