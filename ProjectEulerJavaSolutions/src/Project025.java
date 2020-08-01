import java.math.BigInteger;

public class Project025 {
	//What is the index of the first term in the
	//Fibonacci sequence to contain 1000 digits?

	public static void main(String[] args) {
		BigInteger a =  new BigInteger("1");
		BigInteger b =  new BigInteger("1");
		int count = 2;
		while(true) {
			count++;
			BigInteger temp = b;
			b = b.add(a);
			a = temp;
			if(numDig(b) >= 1000) {
				break;
			}
		}
		System.out.println(count);
		//boo yah 4782 is the correct answer
	}
	public static int numDig(BigInteger A) {
		String str = A + "";
		return str.length();
	}
}
