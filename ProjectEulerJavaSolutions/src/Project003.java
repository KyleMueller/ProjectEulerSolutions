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
		BigInteger b = new BigInteger("600851475143");
		int largest = 0;
		for(int i = 2; i< 10000; i++) {
			BigInteger j = new BigInteger(i + "");
			//System.out.println(j);
			BigInteger zero = new BigInteger("0");
			BigInteger one = new BigInteger("1");
			if(b.mod(j).equals(zero)) {
				//found a prime
				//check if largest
				if(i > largest) {largest = i;}
				//set new b
				b = b.divide(j);
				//System.out.println(b);
				if(b.equals(one)) {
					//if we found last prime, break out
					break;
				}
				
				//set i back to 1 (2 when for loop starts again)
				i = 1;
			}
		}
		System.out.println(largest);
	}

	//from failed idea, maybe reasourceful later
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
