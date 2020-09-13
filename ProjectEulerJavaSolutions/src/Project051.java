import java.util.HashMap;
import java.util.Map;

public class Project051 {
	//https://projecteuler.net/problem=51
	static Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
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
        for(int i = 10; i < limit; i++) {
        	if(primes.containsKey(i)) {
        		if(check(i)) {
        			System.out.println(i);
        			break;
        		}
        	}
        }
        //i don't agree with the wording of this question
        //but replace 1's in where 1 is in the binary and you
        //get the right answer of 121313
        
        //simply put, it want's the smallest prime of the family
        //program outputs the smallest prime that can produce the family
        
	}
	public static boolean check(int A) {
		int len = (A + "").length();
		String ones = "1".repeat(len);
		int upperBinLim = Integer.parseInt(ones, 2);
		for(int i = 1; i <= upperBinLim; i++) {
			String tempBin = getBinary(i);
			int trueCount = 0;
			int count1s = 0;
			boolean firstDigOne = false;
			for(int k = 0; k < tempBin.length(); k++) {
				//can't have a number that only swaps 1 value
				if(tempBin.charAt(k) == '1') {
					count1s++;
				}
				if(k == 0 && tempBin.charAt(k) == '1') {
					firstDigOne = true;
				}
			}
			if(count1s < 2) {
				continue;
			}
			for(int j = 0; j < 10; j++) {
				if(j == 0 && firstDigOne) {
					continue;
				}
				if(primes.containsKey(convert(A, tempBin, j))) {
					trueCount++;
				}
				if(trueCount + (10 - j) < 8) {
					break;
				}
			}
			if(trueCount == 8) {
				System.out.println(tempBin);
				return true;
			}
		}	
		return false;
	}
	public static String getBinary(int A) {
		return Integer.toBinaryString(A);
	}
	public static int convert(int A, String bin, int input) {
		String ret = "";
		String a = A + "";
		while(a.length() > bin.length()) {
			//ensures binary will accounts for all digits
			bin = "0" + bin;
		}
		for(int i = 0; i < bin.length(); i++) {
			if(bin.charAt(i) == '1') {
				ret = ret + input;
			}else {
				ret = ret + a.charAt(i);
			}
		}
		return Integer.parseInt(ret);
	}

}
