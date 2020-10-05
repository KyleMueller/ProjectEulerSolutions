import java.util.HashMap;
import java.util.Map;

public class Project026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int longestChain = 0;
		int longInd = 0;
		for(int i = 2; i < 1000; i++) {
			int temp = eval(i);
			if(temp > longestChain) {
				longestChain = temp;
				longInd = i;
			}
		}
		System.out.println("Denom: " + longInd);
		System.out.println("Chain: " + longestChain);
		//answer is 983 with a chain of 982
	}
	public static int eval(int denom) {
		int zero = 0;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i <= denom; i++) {
			//had original mistake where i only make this the singular digits
			//needs to go all the way to the denom
			map.put(i, zero);
		}
		int count = 1;
		int rem = 1;
		while(true) {
			int curr = rem % denom;
			if(curr == 0) {
				return 0;
			}
			if(map.get(curr) != 0) {
				return count - map.get(curr);
			}
			map.put(curr, count);
			count++;
			rem = curr * 10;
		}
	}

}
