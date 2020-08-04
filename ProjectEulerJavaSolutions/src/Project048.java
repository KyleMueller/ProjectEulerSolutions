import java.math.BigInteger;

public class Project048 {
	/**
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger sum = new BigInteger("0");
		for(int i = 1; i <= 1000; i++) {
			BigInteger eye = new BigInteger(i + "");
			eye = eye.pow(i);
			sum = sum.add(eye);
		}
		String str = sum.toString();
		str = str.substring(str.length()-10);
		System.out.println(str);
		//9110846700 is the correct answer
	}

}
