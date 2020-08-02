import java.util.ArrayList;

public class Project041 {
	/**
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int largest = 0;
		int listcount = 0;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 1; i < 10; i++) {
			ArrayList<String> temp = getPermutation((concats(i)));
			for(int j = 0; j < temp.size(); j++) {
				list.add(temp.get(j));
				listcount++;
			}
		}
		for(int i = 0; i < listcount; i++) {
			int funnyLikeAClown = Integer.parseInt(list.get(i));
			if(funnyLikeAClown > largest) {
				if(checkPrime(funnyLikeAClown)) {
					largest = funnyLikeAClown;
				}
			}
		}
		System.out.println(largest);
		//7652413 is the correct answer

	}
	public static String concats(int a) {
		String str = "";
		for(int i = 1; i <= a; i++) {
			str = str + i;
		}	
		return str;
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


	public static boolean checkPrime(int A) {
		int a = (int) Math.sqrt(A);
		for(int i = 2; i < a; i++) {
			if (A%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkIt(String all, int n) {
		if(all.length() != n) {
			return false;
		}
		for(int i = 0; i < n; i++) {
			if(all.charAt(i) == '0') {
				return false;
			}
			for(int j = i+1; j < n; j++) {
				if(all.charAt(i) == all.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

}
