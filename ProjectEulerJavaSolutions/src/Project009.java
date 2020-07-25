
public class Project009 {
	/**
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c,
	 *  for which, a2 + b2 = c2
	 *  For example, 32 + 42 = 9 + 16 = 25 = 52.
	 *  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 *  Find the product abc.
	 */

	public static void main(String[] args) {
		int ans = 0;
		boolean flag = false;
		for(int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				if((i)+(j) > 1000) {
					break;
				}
				if(flag) {
					break;
				}
				for (int k = 1; k < 1000; k++) {
					if((i)+(j)+(k) > 1000) {
						break;
					}
					else if ((i)+(j)+(k) == 1000) {
						if((i*i)+(j*j) == (k*k)) {
							ans = i*j*k;
							flag = true;
						}
					}
					
				}
			}
			if(flag) {
				break;
			}
		}
		System.out.println(ans);
	}

}
