import java.math.BigDecimal;

public class Project040 {
	/**
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following 
expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String d1 = concat(187000);
		int j = 1;
		int prod = 1;
		for(int i = 1; i <= 7; i++) {
			char grab = d1.charAt(j + 1);
			int temp = Integer.parseInt(grab + "");
			prod = prod * temp;
			j = j * 10;
		}
		System.out.println(prod);
		//210 is the correct answer

	}
	public static String concat(int a) {
		String str = "0.";
		for(int i = 1; i <= a; i++) {
			str = str + i;
		}
		return str;
	}

}
