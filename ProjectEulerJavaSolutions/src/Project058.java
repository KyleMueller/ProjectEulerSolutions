import java.util.HashMap;
import java.util.Map;

public class Project058 {
	//https://projecteuler.net/problem=58

	static Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
	public static void main(String[] args) {
		int limit = 700000000;
		getPrimes(limit);
		int total = 1; //d (counts 1 at start)
		int primeCount = 0; //n
		int sideLength = 2; //interval
		int current = 1; //num I'm on
		while(true) {
			for(int i = 1; i < 5; i++) {
				current = current + sideLength;
				if(primes.containsKey(current)) {
					primeCount++;
				}
				total++;
			}
			if(check(primeCount,total)) {
				System.out.println("Answer: " + (sideLength + 1));
				break;
			}
			sideLength += 2; //side increases by 2 with each rung 
			if(current > limit) {
				System.out.println("increase limit.");
				break;
			}
		}

	}
	public static boolean check(int n, int d) {
		//checks for when the ratio falls below 10%
		double temp = ((double)n)/((double)d);
		if(temp < 0.1) {
			return true;
		}
		return false;
	}
	public static void getPrimes(int a) {
		//prime sieve into static map
		int limit = a;
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
	}

}
