import java.math.BigInteger;

public class Project056 {
/**
A googol (10100) is a massive number: one followed by one-hundred zeros;
 100100 is almost unimaginably large: one followed by two-hundred zeros. 
 Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, 
what is the maximum digital sum?
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int highest = 0;
		for(int a = 1; a < 100; a++) {
			BigInteger bigA = new BigInteger(a+ "");
			for(int b = 1; b < 100; b++) {
				BigInteger bigB = bigA.pow(b);
				int dig = digSum(bigB.toString());
				if(dig > highest) {
					highest = dig;
				}
			}
		}
		System.out.println(highest);
		//972 is the correct answer
	}
	public static int digSum(String str) {
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum = sum + Integer.parseInt(str.charAt(i) + "");
		}
		if(sum < 0) {
			System.out.println("we have a negative problem");
		}
		return sum;
	}

}
