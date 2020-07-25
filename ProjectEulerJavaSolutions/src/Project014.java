
public class Project014 {

	/**
	 * The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] backlog = new int[1500000];
		for(int i = 0; i < 1500000; i++) {
			backlog[i] = -1;
		}
		backlog[1] = 1;
		int chain = 0;
		int start = 0;
		long sequence = 0;
		for (int i = 2; i < 1000000; i++) {
			sequence = i;
			int k = 0;
			while(sequence != 1 && sequence >= i) {
				k++;
				if((sequence % 2) == 0) {
					sequence = sequence / 2;
				} 
				else {
					sequence = sequence*3 + 1;
				}
			}
			backlog[i] = k + backlog[(int) sequence];
			if(backlog[i] > chain) {
				chain = backlog[i];
				start = i;
			}
		}
		System.out.println(start);
		//837799 is the correct answer
	}


}
