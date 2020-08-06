import java.math.BigInteger;

public class Project053 {
	//https://projecteuler.net/problem=53
	/**
1 <= n <= 100
n! / (n!(n-r)!)
how many combinations are > 1000000
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= i; j++) {
				if(combo(i,j).length() > 6) {
					count++;
				}
			}
			System.out.println(count + " after\t" + i);
		}
		System.out.println(count);
		//4075 is the correct answer
	}
	public static String combo(int n, int r) {
		BigInteger nFact = new BigInteger(fact(n) + "");
		BigInteger rFact = new BigInteger(fact(r) + "");
		BigInteger nrFact = new BigInteger(fact(n - r) + "");
		rFact = rFact.multiply(nrFact);
		return nFact.divide(rFact).toString();
	}
	public static String fact(int A) {
		BigInteger total = new BigInteger("1");
		while(A > 1) {
			total = total.multiply(new BigInteger(A + ""));
			A--;
		}
		return total.toString();
	}

}
