
public class Project052 {
/**
It can be seen that the number, 125874, and its double, 251748, 
contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
contain the same digits.
 * @param args
 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isFound = false;
		int ans = 0;
		int i = 1;
		while(!isFound) {
			char[] x = toDigArray(i);
			if(compare(x,toDigArray(2 * i))) {
				if(compare(x,toDigArray(3 * i))) {
					if(compare(x,toDigArray(4 * i))) {
						if(compare(x,toDigArray(5 * i))) {
							if(compare(x,toDigArray(6 * i))) {
								ans = i;
								isFound = true;
							}	
						}	
					}
				}
			}
			
			i++;
		}
		System.out.println("Answer = " + ans);
		//142857 is the correct answer

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
