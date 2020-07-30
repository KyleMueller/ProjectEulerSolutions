
public class Project023 {
	/**
	 * Find the sum of all the positive integers which cannot be 
	 * written as the sum of two abundant numbers.
	 * @param args
	 */

	public static void main(String[] args) {
		int[] allNums = new int[28124]; // all <28123 can be written
		for(int i = 0; i < 28124; i++) {
			allNums[i] = i;
		}
		//find all abundant nums and put in array
		int count = 0;
		int[] aBunDance = new int[30000];
		for(int i = 11; i < 28123; i++) {
			if(isAbun(i)) {
				aBunDance[count] = i;
				count++;
			}
		}
		//cycle through all pairs of the array and set allNums to 0 where
		//it lands
		for(int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {
				int temp = aBunDance[i] + aBunDance[j];
				if (temp < 28124) {
					allNums[temp] = 0;
				}
				//forgot about doubles
				temp = aBunDance[i]*2;
				if (temp < 28124) {
					allNums[temp] = 0;
				}
			}
		}
		//sum allNums
		int sum = 0;
		for(int i = 0; i <= 28123; i++) {
			sum = sum + allNums[i];
		}
		System.out.println(sum);
		//answer of 4179871 is correct
	}
	public static boolean isAbun(int A) {
		int sum = 0;
		for(int i = 1; i < A; i++) {
			if(A%i == 0) {
				sum = sum + i;
			}
		}
		if(sum > A) {
			return true;
		}
		return false;
	}

}
