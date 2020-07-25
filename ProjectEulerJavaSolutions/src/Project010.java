import java.math.BigInteger;

public class Project010 {
	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 * 
	 */

	public static void main(String[] args) {
		long sum = 0;
		int per = 5;
		for (int i = 2; i < 2000000; i++) {
			if(checkPrime(i)) {
				sum += i;
			}
			if(i%100000 == 0) {
				System.out.println("Done:" + per +"%");
				per = per + 5;
			}
		}
		System.out.println(sum);

	}
	public static boolean checkPrime(int A) {
		for(int i = 2; i < A; i++) {
			if (A%i == 0) {
				return false;
			}
			if( ((double)i)/((double)A) > 0.5) {
				return true;
			}
		}
		return true;
	}

}
//142913828922 is the correct solution at 5 minutes of runtime
//can be optimized using the < square root for finding primes

