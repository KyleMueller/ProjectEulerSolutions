
public class Project039 {
	/**
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, 
there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int largestP = 0;
		int largestnum = 0;
		for(int p = 1; p <= 1000; p++) {
			int sols = 0;
			for(int a = 1; a < p; a++) {
				for(int b = 1; b < (p-a); b++) {
					int c = p - a - b;
					if(c*c == a*a + b*b) {
						sols++;
					}
				}
			}
			if(sols > largestnum) {
				largestnum = sols;
				largestP = p;
			}
		}
		System.out.println(largestP);
		//840 is the correct answer
	}
}
