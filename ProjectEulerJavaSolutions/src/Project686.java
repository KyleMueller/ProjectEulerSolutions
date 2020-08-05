import java.math.BigInteger;

public class Project686 {
	//https://projecteuler.net/problem=686
	//doesn't copy and paste nicely, read it there
	
	//basically using 2^j notation in base 10, find the 678910th number to have "123" at 
	//it's front, return j;
	
	//attack strat: big integer to strings

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger two = new BigInteger("2");
		BigInteger go = new BigInteger("2");
		BigInteger sixteen = new BigInteger("64");
		int count = 0;
		int i = 1;
		int ans = 0;
		boolean isFound = false;
		while(!isFound) {
			i++;
			go = go.multiply(two);
			if(go.toString().startsWith("123")) {
				count++;
				//System.out.println(count + "@\t" + i);
				//i = i + 6;
				//go = go.multiply(sixteen);
				if(count == 678910) {
					//678910
					//i = i - 6;
					ans = i;
					isFound = true;
				}
				
			}
			if(go.toString().length() > 25) {
				go = new BigInteger(go.toString().substring(0,14));
			}
		}
		System.out.println("Simon says: "+ ans);
		//193060223 is the correct answer
	}
	/**
	 * 193055656
	 * 193055662
	 * 
	 * 193060223
	 * 50@	13876
	 * 1239xx
	 * 2478xx
	 * 496xxx
	 * 123xxxpossibly
	 */
}
