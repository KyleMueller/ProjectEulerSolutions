
public class Project002 {
	
	/**By considering the terms in the Fibonacci sequence whose 
	values do not exceed four million, find the sum of the 
	even-valued terms.
	**/
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int sum = 2;
		for(int i = 1; i <= 4000000;) {
			int temp = a + b;
			a = b;
			b = temp;
			i = temp;
			if (temp%2 == 0) {
				sum = sum + temp;
			}
		}
		System.out.println(sum);
		//solution of 4613732 is correct.

	}

}
