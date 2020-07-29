import java.math.BigInteger;

public class Project020 {

	/**
	 * n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("100");
		for(int i = 99; i > 1; i--) {
			String str = i + "";
			BigInteger temp = new BigInteger(str);
			sum = sum.multiply(temp);
		}
		String bigStr = sum.toString();
		int finSum = 0;
		for(int i = 0; i < bigStr.length(); i++) {
			finSum = finSum + Integer.parseInt(bigStr.charAt(i) + "");
		}
		System.out.println(finSum);
		//648 is the correct answer
	}

}
