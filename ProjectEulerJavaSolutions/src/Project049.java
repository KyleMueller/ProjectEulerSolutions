
public class Project049 {
/**
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, 
is unusual in two ways: (i) each of the three terms are prime, and, 
(ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first = 0;
		int second = 0;
		int third = 0;
		int i = 1000;
		boolean isFound = false;
		while(!isFound) {
			char[] temp = toDigArray(i);
			if(compare(temp, toDigArray(i + 3330)) &&
					compare(temp, toDigArray(i + 6660))){
				if(isPrime(i) && isPrime(i + 3330) && isPrime(i + 6660)) {
					if(i != 1487) {
						System.out.println("ding!");
						first = i;
						second = i + 3330;
						third = i + 6660;
						isFound = true;
					}
				}
			}
			
			
			i++;
		}
		System.out.println("Answer = " + first + "" + second + "" + third);
		//296962999629 is the correct answer

	}
	public static boolean isPrime(int A) {
		if(A == 2) {
			return true;
		}
		for(int i = 2; i < A; i++) {
			if(A%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean compare(char[]A, char[]B) {
		if(A.length != B.length) {
			return false;
		}
		for(int i = 0; i < A.length; i++) {
			if(A[i] != B[i]) {
				return false;
			}
		}
		return true;
	}
	public static char[] toDigArray(int A) {
		String b = A + "";
		char[] a = new char[b.length()];
		for(int i = 0; i < b.length(); i++) {
			a[i] = b.charAt(i);
		}
		a = sort(a);	
		return a;
	}
	public static char[] sort(char[]a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = i + 1; j < a.length; j++) {
				if(Integer.parseInt(a[i] + "") > Integer.parseInt(a[j] + "") ) {
					char temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

}
