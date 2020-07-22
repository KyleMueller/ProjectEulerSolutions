
public class Project004 {
	/**
	 * A palindromic number reads the 
	 * same both ways. The largest palindrome made from the 
	 * product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 
	 * 3-digit numbers.
	 */

	public static void main(String[] args) {
		int largest = 0;
		for(int i = 100; i <= 999; i++) {
			for(int j = 100; j <= 999; j++) {
				int temp = i*j;
				if(temp > largest) {
					if(checkPalindrome(temp)) {
						largest = temp;
					}
				}
			}
		}
		System.out.println(largest);

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

}
