import java.math.BigInteger;
public class Project016 {
	/**
	 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

		What is the sum of the digits of the number 2^1000?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger num = new BigInteger("2");
		num = num.pow(1000);
		String str = num.toString();
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			String sub = str.substring(i,i+1);
			sum = sum + Integer.parseInt(sub);
		}
		System.out.println(sum);
	}
	//1366 is the correct answer

}

