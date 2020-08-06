import java.math.BigInteger;

public class Project063 {
	/**
The 5-digit number, 16807=75, is also a fifth power. 
Similarly, the 9-digit number, 134217728=89, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1; i <= 1000; i++) {
			BigInteger eye = new BigInteger(i + "");
			for(int j = 1; j <= 1000; j++) {
				BigInteger jay = eye.pow(j);
				if(jay.toString().length() == j) {
					count++;
				}
				
			}
		}
		System.out.println(count);
		//49 is the correct answer
	}

}
