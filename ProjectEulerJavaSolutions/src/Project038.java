
public class Project038 {
	/**
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. 
We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, 
giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the 
concatenated product of an integer with (1,2, ... , n) where n > 1?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int largest = 0;
		for(int i = 1; i < 1000000; i++) {
			for(int j = 2; j < 10 ; j++) {
				String temp = createConcat(i,j);
				if(checkIt(temp)) {
					int intTemp = Integer.parseInt(temp);
					if(intTemp > largest) {
						largest = intTemp;
					}
				}
			}
		}
		System.out.println(largest);
		//932718654 is the correct answer

	}
	public static String createConcat(int i, int n) {
		String str = "";
		for(int k = 1; k <= n; k++) {
			str = str + (i*k);
		}
		return str;
	}
	public static boolean checkIt(String all) {
		if(all.length() != 9) {
			return false;
		}
		for(int i = 0; i < 9; i++) {
			if(all.charAt(i) == '0') {
				return false;
			}
			for(int j = i+1; j < 9; j++) {
				if(all.charAt(i) == all.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

}
