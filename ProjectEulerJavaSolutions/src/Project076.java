

public class Project076 {
	/**
It is possible to write five as a sum in exactly six different ways:

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

How many different ways can one hundred be written as a sum of at 
least two positive integers?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
		int[] ways = new int[num + 1];
		ways[0] = 1;
		 
		for (int i = 1; i <= num - 1; i++) {
		    for (int j = i; j <= num; j++) {
		        ways[j] += ways[j - i];
		    }
		}
		System.out.println("ways: "+ ways[ways.length-1]);
		
	}


}
