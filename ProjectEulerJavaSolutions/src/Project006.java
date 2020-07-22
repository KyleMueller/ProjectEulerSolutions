
public class Project006 {
	/**
	 * Find the difference between the sum of the 
	 * squares of the first one hundred natural numbers 
	 * and the square of the sum.
	 */

	public static void main(String[] args) {
		int difference = 0;
		int sumOfsquares = 0;
		int sum1to100 = 0;
		for(int i = 1; i <= 100; i++) {
			sumOfsquares += i*i;
			sum1to100 += i;
		}
		difference = sum1to100*sum1to100 - sumOfsquares;
		System.out.println(difference);
		//answer of 25164150 is correct.
	}

}
