import java.util.HashMap;
import java.util.Map;

public class Project046 {
	//find the smallest odd composite that cannot be written as the sum
	//of a prime and twice a square
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//do prime sieve, have second array
		//find a prime, compute all not possible values from there
		int limit = 1000000;
		boolean prime[] = new boolean[limit+1];
		boolean nums[] = new boolean[limit + 1];
        for(int i=0; i < limit; i++) {
        	//OG values set to true
            prime[i] = true;
            nums[i] = true;
        }
        for(int p = 2; p*p <= limit; p++) {
        	//prime sieve
        	if(prime[p] == true) {
        		for(int i = p*p; i <= limit; i += p) {
        			prime[i] = false;
        		}
        	}
        }
        for(int i = 2; i <= limit; i++) {
        	if(prime[i] == true) {
        		//for all primes, remove all primes + 2 x (2^x) from nums
        		int squareBase = 0;
        		int current = i + 2 * (squareBase * squareBase);
        		while(current < limit) {
        			nums[current] = false;
        			squareBase++;
        			current = i + 2 * (squareBase * squareBase);
        		}
        	}
        }
        for(int i = 2; i <= limit; i++) {
        	if(nums[i] == true && i%2 == 1) {
        		//find smallest that is odd
        		System.out.println("Found: " + i + " to be the smallest.");
        		break;
        	}
        }
        //eyyo! first try, 5777 is the correct answer

	}

}
