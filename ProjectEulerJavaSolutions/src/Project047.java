import java.util.HashMap;
import java.util.Map;

//https://projecteuler.net/problem=47

public class Project047 {
	/**
	 * Idea.
	 * Get all primes.
	 * Go 644-limit: if the num is prime, skip it
	 * method for finding distinct primes
	 * if consecutive nums have 3 primes, check all primes up to lowest
	 * and see if any divide each other
	 */
	static Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
	static int[] arrPrimes;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 1000000;
		boolean prime[] = new boolean[limit+1]; 
        for(int i=0; i < limit; i++) { 
            prime[i] = true;
        }
        for(int p = 2; p*p <= limit; p++) {
        	if(prime[p] == true) {
        		for(int i = p*p; i <= limit; i += p) {
        			prime[i] = false;
        		}
        	}
        }
        for(int i = 2; i <= limit; i++) {
        	if(prime[i] == true) {
        		primes.put(i, true);
        	}
        }
        arrPrimes = new int[primes.size()];
        int index = 0;
        for(int i = 1; i < limit; i++) {
        	if(primes.containsKey(i)) {
        		arrPrimes[index] = i;
        		index++;
        	}
        	
        }
        //everything above, normal sieving
        //have unique factor method
        int consecutive = 0;
        for(int i = 1; i < limit; i++) {
        	if(uniqueFactors(i) == 4) {
        		consecutive++;
        	}else {
        		consecutive = 0;
        	}
        	if(consecutive == 4) {
        		//testing change this to 4 after
        		if(finalCheck(i - 3)) {
        			System.out.println((i-3));
        			//134043 is the correct answer
        			break;
        		}
        	}
        }
        
        
	}
	public static int uniqueFactors(int a) {
		//returns num of unique factors
		//goes through the primes until a = 1
		int factors = 0;
		int index = 0;
		while(a != 1) {
			if(a%arrPrimes[index] == 0) {
				a = a/arrPrimes[index];
				while(a%arrPrimes[index] == 0) {
					a = a/arrPrimes[index];
				}
				factors++;
			}
			index++;
		}
		return factors;
	}
	public static boolean finalCheck(int a) {
		//checks the four consecutive nums starting with a have all distinct factors
		//goes through all primes up to a
		//if the prime divides more than 1, return false
		//otherwise all of them are coprime, and returns true
		if(a < 5) {
			return false;
		}
		int index = 0;
		while(arrPrimes[index] < a ) {
			int temp = arrPrimes[index];
			int count = 0;
			if(a%temp == 0) {count++;}
			if(a+1%temp == 0) {count++;}
			if(a+2%temp == 0) {count++;}
			if(a+3%temp == 0) {count++;}
			if(count > 1){
				return false;
			}
			index++;
		}
		return true;
	}

}
