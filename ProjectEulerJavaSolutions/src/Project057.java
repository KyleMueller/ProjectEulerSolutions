import java.math.BigInteger;

public class Project057 {
	//In the first one-thousand expansions, 
	//how many fractions contain a numerator with more digits than the denominator?

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		BigInteger firstNum = new BigInteger("3");		
		BigInteger firstDen = new BigInteger("2");	
		BigInteger currNum = new BigInteger("7");	
		BigInteger currDen = new BigInteger("5");
		int count = 2;
		int numMore = 0;
		while(count < 1000) {
			BigInteger newDen = currDen.add(currNum);
			BigInteger newNum = newDen.add(currDen);
			if((newDen.toString()).length() < (newNum.toString()).length()) {
				//System.out.println("ding");
				numMore++;
			}
			count++;
			currDen = newDen;
			currNum = newNum;
			//System.out.println(count);
			//System.out.println(currNum + "/" + currDen);
		}
		System.out.println(numMore);
		//153 is the correct answer

	}

}
