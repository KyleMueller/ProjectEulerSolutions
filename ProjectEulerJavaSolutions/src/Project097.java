import java.math.BigInteger;

public class Project097 {
/**
However, in 2004 there was found a massive non-Mersenne prime 
which contains 2,357,207 digits: 28433×2^7830457+1.

Find the last ten digits of this prime number.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger sup = new BigInteger("2");
		sup = sup.pow(7830457);
		BigInteger hi = new BigInteger("28433");
		BigInteger one = new BigInteger("1");
		sup = sup.multiply(hi);
		sup = sup.add(one);
		System.out.println(sup.toString().substring(sup.toString().length() - 10));
		//8739992577 is the correct answer
	}

}
