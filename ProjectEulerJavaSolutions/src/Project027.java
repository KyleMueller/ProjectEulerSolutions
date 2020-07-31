
public class Project027 {
	//description @ https://projecteuler.net/problem=27
	//too long to copy and past
	
	//n^2 + an + b
	//a goes from -999 to 999
	//b goes from -1000 to 1000

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int longestA = 0;
		int longestB = 0;
		int longestChain = 0;
		
		for(int i = -999; i < 1000; i++) {
			//current A is i
			for(int j = -1000; j < 1001; j++) {
				//current B is j
				int n = 0;
				int count = 0;
				while(true) {
					int val = n*n + i*n + j;
					if(val >= 0) {
						if(checkPrime(val)) {
							count++;
							n++;
							if(count >= longestChain) {
								longestA = i;
								longestB = j;
								longestChain = count;
							}
						}else {
							break;
						}
					}
					else {
						break;
					}
				}
				
				
			}
		}
		System.out.println("Longest A:" + longestA);
		System.out.println("Longest B:" + longestB);
		System.out.println("A x B = " + (longestA * longestB));
		/**
		 * correct outpuet
		 * Longest A:-61
		 * Longest B:971
		 * A x B = -59231
		 */
		
	}
	
	public static boolean checkPrime(int A) {
		for(int i = 2; i < A; i++) {
			if (A%i == 0) {
				return false;
			}
		}
		return true;
	}

}
