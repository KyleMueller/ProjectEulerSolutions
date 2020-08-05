import java.math.BigInteger;

public class Project206 {
	/**
Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
where each “_” is a single digit.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = 0;
		int percent = 0;
		for(int i = 0; i <= 999999999; i++) {
			BigInteger temp = new BigInteger(makeNum(i));
			BigInteger[] arr = temp.sqrtAndRemainder();
			if(arr[1].toString().equals("0")) {
				System.out.println("found.");
				ans = i;
				break;
			}
			if(i%10000000 == 0) {
				percent++;
				System.out.println("Loading: "+ percent + "%");
			}
		}
		BigInteger disp = new BigInteger(makeNum(ans));
		disp = disp.sqrt();
		System.out.println(disp);
		//1389019170 is the correct ans
		//long brute force (like 15 mins)

	}
	public static String makeNum(int a) {
		String temp = a + "";
		if(temp.length() < 9) {
			while(temp.length() < 9) {
				temp = "0" + temp;
			}
		}
		String ret = "1-2-3-4-5-6-7-8-9-0";
		for(int i = 0; i < 9; i++) {
			String sin = temp.charAt(i) + "";
			int ind = (2*i) + 1;
			ret = swapIn(ret, ind, sin);
		}	
		return ret;
	}
	public static String swapIn(String A, int i, String n) {
		A = A.substring(0,i) + n + A.substring(i+1);
		return A;
	}

}
