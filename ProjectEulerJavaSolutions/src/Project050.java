import java.util.HashMap;
import java.util.Map;

public class Project050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = sieve(1000000);
		int[] primes = new int[map.size()];
		int index = 0;
		for(int i = 2; i < 1000000; i++) {
			if(map.containsKey(i)) {
				primes[index] = i;
				index++;
			}
		}
		int max = 0;
		int maxPrime = 0;
		for(int i = 0; i < primes.length; i++) {
			int count = primes[i];
			for(int j = i + 1; j < primes.length; j++) {
				count = count + primes[j];
				if(count > 1000000) {
					break;
				}
				if(map.containsKey(count)) {
					if(j-i > max) {
						max = j-i;
						maxPrime = count;
					}
				}
			}
		}
		System.out.println(maxPrime);
	}
	public static Map<Integer, Integer> sieve(int n){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean prime[] = new boolean[n+1];
		for(int i = 0; i < n; i++) {
			prime[i] = true;
		}
		for(int p = 2; p*p <= n; p++) {
			if(prime[p] == true) {
				for(int i = p*p; i <= n; i = i + p) {
					prime[i] = false;
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			if(prime[i] == true) {
				map.put(i, 0);
			}
		}
		return map;
	}

}
