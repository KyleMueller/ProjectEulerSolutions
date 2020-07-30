import java.math.BigInteger;

public class Project024 {
	//What is the millionth lexicographic permutation of the digits 
	//0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] arr = new String[10000000];
		int count = 0;
		BigInteger i = new BigInteger("100000000");
		BigInteger one = new BigInteger("1");
		while(true) {
			String temp = i.toString() + "";
			if(temp.length() < 10) { //add leading zeros
				int a = 10 - temp.length();
				String zero = "0";
				temp = zero.repeat(a) + temp;
			}
			boolean flag = false;
			if(hasRepeat(temp) == false) {
				count = count + 1;
				//System.out.println("count:" + count);
				if(count == 1000000) {
					System.out.println(temp);
					flag = true;
				}
			}
			if(flag) {
				break;
			}
			i = i.add(one);
		}
		//2783915460 is the correct answer. brute force for about 90 seconds
		//faster method of making a permutation maker and then sorting it but eh.

	}
	public static boolean hasRepeat(String A) {
		String str = A + "";
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

}
