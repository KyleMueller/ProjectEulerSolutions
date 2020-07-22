
public class Project007 {
	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, 
	 * and 13, we can see that the 6th prime is 13. 
	 * What is the 10 001st prime number?
	 */

	public static void main(String[] args) {
		int primes = 0;
		int answer = 0;
		for (int i = 2; i >= 0; i++) {
			if (checkPrime(i)) {
				primes = primes + 1;
			}
			if(primes == 10001) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
		//answer of 104743 is correct.

	}

	public static boolean checkPrime(int A) {
		for(int i = 2; i < A; i++) {
			if (A%i == 0) {
				return false;
			}
		}
		return true;
	}
}
