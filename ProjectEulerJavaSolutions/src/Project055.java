import java.math.BigInteger;

public class Project055 {
	//https://projecteuler.net/problem=55
	//not copy and paste friendly :(
	
	//if not in 50 iterations --> L number
	//how many L nums below 10K

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1; i < 10000; i++) {
			if(checkL(i)) {
				count++;
			}
		}
		System.out.println(count);
		//249 is the correct answer, first try
	}
	public static boolean checkL(int A) {
		int count = 0;
		BigInteger a = new BigInteger(A + "");
		while(true) {
			a = reverseAdd(a);
			if(checkPalindrome(a.toString())) {
				return false;
			}
			count++;
			if(count >= 50) {
				break;
			}
		}
		return true;
	}
	public static BigInteger reverseAdd(BigInteger A) {
		String b = "";
		String a = A.toString();
		for(int i = a.length()-1; i > -1; i--) {
			b = b + a.charAt(i);
		}
		A = A.add(new BigInteger(b));
		return A;
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
