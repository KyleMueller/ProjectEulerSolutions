
public class Project045 {
/**
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		for(int i = 286; i< 30000000; i++) {
			long j = (long)i;
			long temp = j * (j + 1) / 2;
			if(checkPent(temp)) {
				if(checkHex(temp)) {
					System.out.println(temp);
					break;
				}
			}
		}
		//1533776805 is the correct answer

	}
	public static boolean checkPent(long a) {
		double temp = (Math.sqrt(1 + 24*a) + 1.0)/6.0;
		return temp == ((long)temp);
	}
	public static boolean checkHex(long a) {
		double temp = (Math.sqrt(1 + 8*a)+ 1.0)/4.0;
		return temp == ((long) temp);
	}

}
