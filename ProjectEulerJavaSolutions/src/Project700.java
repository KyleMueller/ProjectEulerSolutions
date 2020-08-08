import java.math.BigInteger;

public class Project700 {
	/**
Leonhard Euler was born on 15 April 1707.

Consider the sequence 1504170715041707n mod 4503599627370517.

An element of this sequence is defined to be an Eulercoin if it is 
strictly smaller than all previously found Eulercoins.

For example, the first term is 1504170715041707 which is the first Eulercoin. 
The second term is 3008341430083414 which is greater than 1504170715041707 so is 
not an Eulercoin. However, the third term is 8912517754604 which is small enough to 
be a new Eulercoin.

The sum of the first 2 Eulercoins is therefore 1513083232796311.

Find the sum of all Eulercoins
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coinCount = 1;
		BigInteger leo = new BigInteger("1504170715041707");
		BigInteger lastCoin = leo;
		BigInteger moddy = new BigInteger("4503599627370517");
		BigInteger sum = new BigInteger("0");
		sum = sum.add(leo);
		BigInteger current = new BigInteger("0");
		current = current.add(leo);
		BigInteger zero = new BigInteger("0");
		while(leo.compareTo(zero) == 1) {
			BigInteger rem = gcdRem(moddy, leo);
			coinCount++;
			moddy = leo;
			leo = rem;
			sum = sum.add(rem);
			System.out.println(rem);
		}		
		System.out.println("There are " + coinCount + " eulercoins.");
		System.out.println("They have a sum of " + sum.toString() + ".");
		//1517926517777556 is the correct sum
		
	}
	public static BigInteger gcdRem(BigInteger A, BigInteger B) {
		//return remainder
		BigInteger temp = B;
		int count = 1;
		while(A.compareTo(temp) == 1) {
			count++;
			temp = temp.add(B);
		}
		BigInteger c = new BigInteger(count + "");
		B = B.multiply(c);
		
		BigInteger rem = B.mod(A);
		return rem;
		
	}

}
