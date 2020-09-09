
public class Project069 {

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
		double biggest = 2.0;
		int index = 2;
		for(int i = 2; i <= limit; i++) {
			if (biggest < ((double)i)/nums[i]) {
				index = i;
				biggest = ((double)i)/nums[i];
			}
		}
		System.out.println(index + " with " + biggest);
		//510510 is the correct answer
	}

}
