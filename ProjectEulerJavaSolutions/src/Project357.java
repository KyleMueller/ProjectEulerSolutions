import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Project357 {
	/**
Consider the divisors of 30: 1,2,3,5,6,10,15,30.
It can be seen that for every divisor d of 30, d+30/d is prime.

Find the sum of all positive integers n not exceeding 100 000 000
such that for every divisor d of n, d+n/d is prime.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger sum = new BigInteger("0");
		for(int i = 1; i < 100000000; i++) {
			if (isPrime(i)) {
				if (isPrimeGen(i - 1)) {
					sum = sum.add(new BigInteger((i - 1) + ""));
				}
			}
			if (i % 1000000 == 0) {
				System.out.println("Percent: " + i / 1000000);
			}
		}
		System.out.println("answer: " + sum);
		//answer is 1739023853137 (long long bruteforce)
		//might revamp this later
	}
	
	public static boolean isPrimeGen(int a) {
		for(int i = 1; i <= a/2 + 1; i++) {
			if(a%i == 0) {
				if(isPrime(i + (a/i))) {
					continue;
				}else {
					return false;
				}
			}
		}
		if(isPrime(a + 1)) {
			return true;
		}
		return false;
	}
	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
