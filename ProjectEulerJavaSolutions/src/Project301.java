
public class Project301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limitExp = 30;
		int limit = (int) Math.pow(2, limitExp);
		int count = 0;
		for(int i = 1; i <= limit; i++) {
			if(nimSum(i)) {
				count++;
			}
		}
		System.out.println(count);
		//2178309 is the correct answer
	}
	public static boolean nimSum(int a) {
		//bitwise XOR operator on a, 2a, and 3a
		int score = a ^ (2 * a) ^ (3 * a);
		if(score == 0) {
			//returns true if nimsum is zero
			return true;
		}
		return false;
	}

}
