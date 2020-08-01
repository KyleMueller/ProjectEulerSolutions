
public class Project033 {
	/**https://projecteuler.net/problem=33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct,
is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value,
 and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of 
the denominator.
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		int prodNumer = 1;
		int prodDenom = 1;
		for(int i = 10; i < 100; i++) {
			for(int j = i+1; j <100; j++) {
				if(check(i,j)) {
					int[] simp = simplify(i,j);
					prodNumer = prodNumer*simp[0];
					prodDenom = prodDenom*simp[1];
				}
			}
		}
		int [] finSim = simplify(prodNumer, prodDenom);
		System.out.println("Final Answer: " + finSim[0] + "/" +
				finSim[1]);
		//100 is the correct answer, pretty anticlimatic imo

	}
	public static boolean check(int a, int b) {
		String strA = a + "";
		String strB = b + "";
		boolean flag = true;
		int locA = -1;
		int locB = -1;
		for(int i = 0; i < strA.length(); i++) {
			for(int j = 0; j < strB.length(); j++) {
				//check for something to cancel
				if (strA.charAt(i) == strB.charAt(j)) {
					if (strA.charAt(i) != '0') {
						//trivial case avoidance
						flag = false;
						locA = i;
						locB = j;
					}
				}
			}
		}
		if(flag) {
			//nothing to cancel
			return false;
		}
		Double A = Double.parseDouble(strA);
		Double B = Double.parseDouble(strB);
		strA = removeIndex(strA, locA);
		strB = removeIndex(strB, locB);
		Double newA = Double.parseDouble(strA);
		Double newB = Double.parseDouble(strB);
		A = A/B;
		newA = newA/newB;
		if(Math.abs(A - newA) < 0.001) {
			return true;
		}
		return false;
	}
	public static String removeIndex(String A, int index) {
		if (index == 0) {
			//first index
			return A.substring(1);
		}else if(index == A.length()- 1) {
			//last index
			return A.substring(0,A.length()-1);
		}
		else {
			//middle
			return A.substring(0,index) + A.substring(index+ 1);
		}
	}
	public static int[] simplify(int A, int B) {
		for(int i = 2; i <= A; i++) {
			if(A%i == 0 && B%i == 0) {
				A = A/i;
				B = B/i;
				i = 1;
			}
			if(A == 1) {
				break;
			}
		}
		int[] ret = {A,B};
		return ret;
		
	}

}
