import java.util.ArrayList;

public class Project079 {
	//initally did this one by hand because it was easier
	//I think I have a way of doing this, no good way tbh
	//concat all of them, then delete nums that violate keylogs

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "319" + "680" + "180" + "690" + 				"129" + 			"620" + 				"762" + 				"689" + 				"762" + 				"318" + 				"368" + 				"710" + 				"720" + 				"710" + 				"629" + 				"168" +				"160" + 				"689" + 				"716" + 				"731" + 				"736" + 				"729" + 				"316" + 				"729" + 				"729" + 				"710" + 				"769" + 				"290" + 				"719" + 				"680" + 				"318" + 				"389" + 				"162" + 				"289" + 				"162" + "718" + 				"729" + 				"319" + 				"790" + 				"680" + 				"890" + 				"362" + 				"319" + 				"760" + 				"316" + 				"729" + 				"380" + 				"319" + 				"728" + 				"716";
		String uniques = "01236789";
		String[] keys = getKeys();
		ArrayList<String> arrL = getPermutation(uniques);
		String[] perms = new String[arrL.size()];
		for(int i = 0; i < arrL.size(); i++) {
			perms[i] = arrL.get(i);
		}
		String ans = "";
		int validC = 0;
		for(int i = 0; i < perms.length; i++) {
			boolean isValid = true;
			for(int j = 0; j < keys.length; j++) {
				if(!doKey(perms[i], keys[j])) {
					isValid = false;
					break;
				}
			}
			if(isValid) {
				ans = perms[i];
				validC++;
			}
		}
		System.out.println("Valid Combos: "+ validC);
		System.out.println("Possible passcode: "+ ans);
		//73162890 is the correct answer
	}


	public static boolean doKey(String str, String key) {
		char first = key.charAt(0);
		int firI = str.indexOf(first);
		char sec = key.charAt(1);
		int secI = str.indexOf(sec);
		char thir = key.charAt(2);
		int thirI = str.indexOf(thir);
		if(secI < firI) {
			return false;
		}
		if(thirI < firI) {
			return false;
		}
		if(thirI < secI) {
			return false;
		}	
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
	public static String[] getKeys() {
		String str = "319\r\n" + 
				"680\r\n" + 
				"180\r\n" + 
				"690\r\n" + 
				"129\r\n" + 
				"620\r\n" + 
				"762\r\n" + 
				"689\r\n" + 
				"762\r\n" + 
				"318\r\n" + 
				"368\r\n" + 
				"710\r\n" + 
				"720\r\n" + 
				"710\r\n" + 
				"629\r\n" + 
				"168\r\n" + 
				"160\r\n" + 
				"689\r\n" + 
				"716\r\n" + 
				"731\r\n" + 
				"736\r\n" + 
				"729\r\n" + 
				"316\r\n" + 
				"729\r\n" + 
				"729\r\n" + 
				"710\r\n" + 
				"769\r\n" + 
				"290\r\n" + 
				"719\r\n" + 
				"680\r\n" + 
				"318\r\n" + 
				"389\r\n" + 
				"162\r\n" + 
				"289\r\n" + 
				"162\r\n" + 
				"718\r\n" + 
				"729\r\n" + 
				"319\r\n" + 
				"790\r\n" + 
				"680\r\n" + 
				"890\r\n" + 
				"362\r\n" + 
				"319\r\n" + 
				"760\r\n" + 
				"316\r\n" + 
				"729\r\n" + 
				"380\r\n" + 
				"319\r\n" + 
				"728\r\n" + 
				"716";
		String[] ret = str.split("\r\n");
		return ret;
	}

}
