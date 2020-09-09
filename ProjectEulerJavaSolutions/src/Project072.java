import java.util.HashMap;
import java.util.Map;

public class Project072 {
	//https://projecteuler.net/problem=72
	//solve it with a sieve of course....
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long limit = 1000000;
		long[] nums = new long[(int) (limit + 1)];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		for(int i = 2; i <= limit; i++) {
			if(nums[i] == i) {
				for(int j = 1; j*i <= limit; j++) {
					nums[j*i] -= nums[j*i]/i;
				}
			}
		}
		Map<Long, Long> map = new HashMap<Long,Long>();
		map.put((long) 1,(long) 0);
		for(long i = 2; i <= limit; i++) {
			map.put(i, map.get(i-1) +  nums[(int) i]);
		}
		System.out.println(map.get(limit));
		//answer is 303963552391
	}

}
