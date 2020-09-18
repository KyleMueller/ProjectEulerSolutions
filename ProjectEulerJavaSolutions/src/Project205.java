
public class Project205 {
	//how many times does the 4-dice beat the 6-dice
	static int[] P = new int[37];
	static int[] C = new int[37];
	public static void main(String[] args) {
		roll(6,6,false, 0);
		roll(9,4, true, 0);
		int cubesum = 0;
		for(int i = 1; i < 37; i++) {
			cubesum = cubesum  + C[i];
		}
		int pyrsum = 0;
		for(int i = 1; i < 37; i++) {
			pyrsum = pyrsum + P[i];
		}
		
		double winPyr = 0.0;
		for(int sum = 1; sum <= 36; sum++) {
			int numWins = 0;
			for(int j = 1; j < sum; j++ ) {
				numWins += C[j];
			}
			double beats = numWins / (double) cubesum;
			winPyr += beats * P[sum]/ pyrsum;
		}
		System.out.println(winPyr);
		//correct rounded answer is 0.5731441
	}
	public static void roll(int dies, int sides, boolean pyr, int sum) {
		if (dies == 0) {
			if(pyr) {
				P[sum] = P[sum] + 1;
			} else {
				C[sum] = C[sum] + 1;
			}
			return;
		}
		for(int i = 1; i <= sides; i++) {
			roll(dies - 1, sides, pyr, sum +i);
		}
	}

	


}
