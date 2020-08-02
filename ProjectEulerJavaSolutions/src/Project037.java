
public class Project037 {
	/**
The number 3797 has an interesting property. Being prime itself, it is 
possible to continuously remove digits from left to right, and remain prime at each 
stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left 
to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int sum = 0;
		int i = 5;
		int[] PrePrimes = new int[100000];
		int primecount = 0;
		for(int k = 1; k < 800000; k++) {
			if(checkPrime(k)) {
				PrePrimes[primecount] = k;
				primecount++;
			}
		}
		int[] primes = new int[primecount];
		for(int k = 0; k < primecount; k++) {
			primes[k] = PrePrimes[k];
		}
		while(count < 11) {
			int right = primes[i];
			int left = 0;
			int mult = 1;
			boolean isTrunk = true;
			while(right > 0 && isTrunk) {
				left += mult*(right%10);
				isTrunk = isFound(primes, right) && isFound(primes,left);
				right = right / 10;
				mult = mult * 10;			
			}
			if(isTrunk) {
				count++;
				sum = sum + primes[i];
			}
			i++;
			if(i - 1> primecount) {
				break;
			}
		}	
		System.out.println(sum);
		//748317 is the correct answer

	}
	public static boolean isFound(int[] arr, int a) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == a) {
				return true;
			}
		}
		return false;
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
