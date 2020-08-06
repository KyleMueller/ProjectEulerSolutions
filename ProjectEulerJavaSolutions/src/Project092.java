
public class Project092 {
	/**
A number chain is created by continuously adding the square 
of the digits in a number to form a new number until it has 
been seen before.

For example,

44 → 32 → 13 → 10 → 1 → 1
85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89

Therefore any chain that arrives at 1 or 89 will become stuck 
in an endless loop. What is most amazing is that EVERY starting 
number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1; i < 10000000; i++) {
			if(chain(i) == 89) {
				count++;
			}
		}
		System.out.println(count);
		//8581146 is the correct answer;
		//first try!
	}
	public static int chain(int A) {
		while(A != 1 && A != 89) {
			String a = A + "";
			int sum = 0;
			for(int i = 0; i < a.length(); i++) {
				int temp = Integer.parseInt(a.charAt(i) + "");
				temp = temp * temp;
				sum = sum + temp;
			}
			A = sum;
		}
		
		return A;
	}

}
