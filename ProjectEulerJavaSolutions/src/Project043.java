import java.math.BigInteger;
import java.util.ArrayList;

public class Project043 {
	/**
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of 
each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string 
divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> nums = getPermutation("0123456789");
		BigInteger sum = new BigInteger("0");
		int count = 0;
		for(int i = 0; i < nums.size(); i++) {
			String a = nums.get(i);
			if(checkDiv(a)) {
				BigInteger A = new BigInteger(a);
				sum = sum.add(A);
				count++;
			}
		}
		System.out.println(sum.toString());
		System.out.println(count);
		//16695334890 is the correct answer

	}
	public static boolean checkDiv(String str) {
		String by2 = str.substring(1,4);
		String by3 = str.substring(2,5);
		String by5 = str.substring(3,6);
		String by7 = str.substring(4,7);
		String by11 = str.substring(5,8);
		String by13 = str.substring(6,9);
		String by17 = str.substring(7);
		if(Integer.parseInt(by2)% 2 != 0) {return false;}
		if(Integer.parseInt(by3)% 3 != 0) {return false;}
		if(Integer.parseInt(by5)% 5 != 0) {return false;}
		if(Integer.parseInt(by7)% 7 != 0) {return false;}
		if(Integer.parseInt(by11)% 11 != 0) {return false;}
		if(Integer.parseInt(by13)% 13 != 0) {return false;}
		if(Integer.parseInt(by17)% 17 != 0) {return false;}
		return true;
	}
	public static ArrayList<String> getPermutation(String str) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
  
            // Return an empty arraylist 
            ArrayList<String> empty = new ArrayList<>(); 
            empty.add(""); 
            return empty; 
        } 
  
        // Take first character of str 
        char ch = str.charAt(0); 
  
        // Take sub-string starting from the 
        // second character 
        String subStr = str.substring(1); 
  
        // Recurvise call 
        ArrayList<String> prevResult = getPermutation(subStr); 
  
        // Store the generated permutations 
        // into the resultant arraylist 
        ArrayList<String> Res = new ArrayList<>(); 
  
        for (String val : prevResult) { 
            for (int i = 0; i <= val.length(); i++) { 
                Res.add(val.substring(0, i) + ch + val.substring(i)); 
            } 
        } 
  
        // Return the resultant arraylist 
        return Res; 
    } 

}
