import java.math.BigInteger;
import java.math.*;
import java.util.Random;

//wolframalpha's answer is 6.818741802
//7 x (1 - (60 C 20)/(70 C 20)) is the prob formula
public class Project493 {
	public static void main(String[] args) {
		BigInteger A = choose(60,20);
		BigInteger B = choose(70,20);
		A = B.subtract(A);
		A = A.multiply(new BigInteger("7000000000"));
		B = A.divide(B);
		String ans = B.toString();
		System.out.println(ans.charAt(0) + "." + ans.substring(1));
		//correct answer of 6.818741802
		
	}
	public static BigInteger choose(int n, int r) {
		int nr = n - r;
		BigInteger N = new BigInteger("1");
		for(int i = 1; i <= n; i++) {
			N = N.multiply(new BigInteger(i + ""));
		}
		BigInteger R = new BigInteger("1");
		for(int i = 1; i <= r; i++) {
			R = R.multiply(new BigInteger(i + ""));
		}
		BigInteger NR = new BigInteger("1");
		for(int i = 1; i <= nr; i++) {
			NR = NR.multiply(new BigInteger(i + ""));
		}
		R = R.multiply(NR);
		N = N.divide(R);
		return N;
		
	}

}
