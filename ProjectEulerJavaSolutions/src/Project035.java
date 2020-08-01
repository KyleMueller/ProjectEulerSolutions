import java.util.Random;

public class Project035 {
	/**
	 * https://projecteuler.net/problem=35
	 * 
The number, 197, is called a circular prime because all rotations of the digits:
 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;		
		for(int i = 2; i < 1000000; i++) {
			if(!checkPrime(i)) {
				continue;
			}
			else {
				//System.out.println("checking prime: " + i);
				String[] permutes = perms(i);
				boolean flag = true;
				for(int j = 0; j < permutes.length; j++) {
					if(!checkPrime(Integer.parseInt(permutes[j]))) {
						flag = false;
						break;
					}
				}
				if(flag) {
					count++;
				}
			}
		}
		System.out.println(count);
		//55 is the correct answer. long bruteforce though

	}
	public static String[] perms(int A) {
		int[] perms = new int[10000];
		int n = (A + "").length();
		int num = A;
		int count = 0;
		while(true) {
			perms[count] = num;
			count++;
			int rem = num%10;
			int dev = num/10;
			num = (int)((Math.pow(10, n - 1)) * rem + dev);
			
			if(num == A) {
				break;
			}
		}
		String[] fina = new String[count];
		for(int i = 0; i < count; i++) {
			fina[i] = perms[i] + "";
		}
		return fina;
	}
	public static String swap(String A, int i, int j) {
		//swap indexes i and j of String A
		if(i < j) {
			String first = A.charAt(i) + "";
			String seccond = A.charAt(j) + "";
			return A.substring(0, i) + seccond + A.substring(i + 1, j) + first + A.substring(j + 1);
		}
		else if(i == j) {
			return A;
		}
		else {
			//j > i
			String first = A.charAt(j) + "";
			String seccond = A.charAt(i) + "";
			return A.substring(0, j) + first + A.substring(j + 1, i) + seccond + A.substring(i + 1);
		}
		
	}
	public static int fact(int a) {
		int prod = 1;
		for(int i = a; i > 1; i--) {
			prod = prod*i;
		}
		return prod;
	}
	public static boolean checkPrime(int A) {
		for(int i = 2; i < A; i++) {
			if (A%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static int distinctDig(String A) {
		int count = A.length();
		for(int i = 0; i < A.length(); i++) {
			for(int j = i+1; j < A.length(); j++) {
				if(A.charAt(i) == A.charAt(j)) {
					count--;
				}
			}
		}
		return count;
	}

}
