import java.math.BigInteger;

public class Project719 {
	/**
https://projecteuler.net/problem=719

Not copy paste friendly

For every square number that's digits can be split to form the sqrt
i.e 9^2 = 81
9 = 8 + 1

Find the sum of all of them less than 10^12
-> Big Integer probably required -> should be fine with longs nvm
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long i = 0;
		BigInteger sum = new BigInteger("0");
		//doesn't work for 1, so we start with 1
		//nvm looks like we dont add 1
		BigInteger upper = new BigInteger("1000000000000");
		while(true) {
			if(i%9 > 1) {
				//optimization goes for 19min to 4min lol
				i++;
				continue;
			}
			BigInteger sq = new BigInteger(i + "");
			sq = sq.multiply(sq);
			//System.out.println("on: "+ sq.toString());
			if( sq.compareTo(upper) == 1) {
				break;
			}
			if(checkSquare(sq,i)) {
				sum = sum.add(sq);
				System.out.println("ding\t" + sq.toString());
			}
			i++;
		}
		System.out.println(sum.toString());
		//128088830547982 is the correct answer

	}
	public static boolean checkSquare(BigInteger sq, long n) {
		String [] poss = split(sq);
		for(int i = 0; i < poss.length; i++) {
			if(addFromSpaces(poss[i]) == n) {
				return true;
			}
		}
		return false;
	}
	public static long addFromSpaces(String a) {
		String[] temp = a.split(" ");
		long sum = 0;
		for(int i = 0; i < temp.length; i++ ) {
			sum = sum + Long.parseLong(temp[i]);
		}
		return sum;
	}
	public static String[] split(BigInteger A) {
		String str = A.toString();
		int totalCombo = (int) Math.pow(2, (str.length() - 1));
		int binLength = str.length() - 1;
		String[] arr = new String[totalCombo];
		int binary = 0;
		while(binary + 1 <= totalCombo) {
			String bin = Integer.toBinaryString(binary);
			arr[binary] = addSpaces(str,binLeadingZeroes(bin,binLength));
			binary++;
		}
		return arr;
	}
	public static String binLeadingZeroes(String bin, int len) {
		while(len > bin.length()) {
			bin = "0" + bin;
		}
		return bin;
	}
	public static String addSpaces(String num, String binary) {
		String out = "";
		for(int i = 0; i < binary.length(); i++) {
			out = out + num.charAt(i);
			if(binary.charAt(i) == '1') {
				out = out + " ";
			}
		}
		out = out + num.charAt(num.length() - 1);
		return out;
	}
	public static long digitSum(BigInteger a) {
		String temp = a.toString() + "";
		int sum = 0;
		for(int i = 0; i < temp.length(); i++) {
			sum = sum + Integer.parseInt(temp.charAt(i) + "");
		}
		return (long)sum;
	}

}
