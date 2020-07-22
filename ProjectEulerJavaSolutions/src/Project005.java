
public class Project005 {
	/**
	 * What is the smallest positive number that is evenly 
	 * divisible by all of the numbers from 1 to 20?
	 */

	public static void main(String[] args) {
		boolean searching = true;
		int i = 1;
		while(searching) {
			boolean valid = true;
			for (int j = 1; j <= 20; j++) {
				if (i%j != 0) {
					valid = false;
					break;
				}
			}
			if(valid) {
				searching = false;
				break;
			}
			else {
				i++;
			}
		}
		System.out.println(i);
	}
	//solution of 232792560 is correct.
}
