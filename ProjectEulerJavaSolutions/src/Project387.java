import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project387 {
	//*https://projecteuler.net/problem=387
	/**
	 * plan: recurisve method returning truncate
	 * cache all primes to move faster (maybe nah)
	 * big integers...yup
	 * 
	 * that plan sucked, new plan
	 * start with all single digits, use them to find 
	 * all two digit harshad nums and so on
	 */
	static Map<String, Integer> primes = new HashMap<String, Integer>();
	static List<String> hNums = new ArrayList<String>();
	public static void main(String[] args) {
		BigInteger one = new BigInteger("1");
		BigInteger oneAnother = new BigInteger("1");
		BigInteger sum = new BigInteger("0");
		hNums.clear();
		for(int i = 1; i < 10; i++) {
			hNums.add(oneAnother.toString());
			oneAnother = oneAnother.add(one);
		}
		for(int i = 2; i < 14; i++) {
			propHnums(i);
		}
		for(int i = 0; i < hNums.size(); i++) {
			BigInteger temp = new BigInteger(hNums.get(i));
			if(isStrong(temp)) {
				for (int j = 0; j < 10; j++) {
					BigInteger temp2 = new BigInteger(temp.toString() + j);
					if (isPrime(temp2)) {
						sum = sum.add(temp2);
					}
				}
			}
		}
		System.out.println(sum);
		//696067597313468 is the correct answer
	}
	public static void propHnums(int a) {
		//take all keys of len a-1, and use them to find all keys of len a
		for(int ind = 0; ind < hNums.size(); ind++) {
			if(hNums.get(ind).length() == a-1) {
				for(int i = 0; i < 10; i++) {
					BigInteger temp = new BigInteger(hNums.get(ind) + i);
					if(isTrunc(temp)) {
						hNums.add(temp.toString());
					}
				}
			}
		}
	}
	public static boolean isPrime(BigInteger a) {
		if(primes.containsKey(a.toString())) {
			return true;
		}else {
			if(a.isProbablePrime(5)) {
				primes.put(a.toString(), 0);
				return true;
			}
			return false;
		}
	}
	public static boolean isStrong(BigInteger a) {
		a = a.divide(new BigInteger(digSum(a) + ""));
		return isPrime(a);
	}
	public static int digSum(BigInteger a) {
		String A = a.toString();
		int sum = 0;
		for(int i = 0; i < A.length(); i++) {
			sum = sum + Integer.parseInt(A.charAt(i) + "");
		}
		return sum;
	}
	public static boolean isTrunc(BigInteger a) {
		if(a.compareTo(new BigInteger("10")) == -1) {
			return true;
		}else {
			BigInteger dig = new BigInteger(digSum(a) + "");
			BigInteger rem = a.mod(dig);
			if(rem.toString().equals("0")) {
				return isTrunc(a.divide(new BigInteger("10")));
			} else {
				return false;
			}
		}
	}

}
