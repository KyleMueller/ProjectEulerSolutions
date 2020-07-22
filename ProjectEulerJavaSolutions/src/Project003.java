import java.math.BigInteger;
//tried, couldn't get a solution that wouldn't take ages atm
//better way is to keep dividing it by the first prime you find that
//divides evenly

public class Project003 {
	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * What is the largest prime factor of the number 600851475143 ?
	 */

	public static void main(String[] args) {
		BigInteger a = new BigInteger("2");
		BigInteger b = new BigInteger("600851475143");
		BigInteger ans = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		int i = 1;
		while(true) {
			if(checkPrime(b)) {
				break;
			}
			else {
				while(true) {
					
				}
			}
		}
			

	}

	public static boolean checkPrime(BigInteger A) {
		BigInteger i = new BigInteger("2");
		while(!i.equals(A)) {
			if(A.mod(i).equals("0")) {
				return false;
			}
			BigInteger one = new BigInteger("1");
			i = new BigInteger(i.add(one).toString());
		}
		return true;
	}
}
