
public class Project073 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tre = 3;
		long two = 2;
		int count = 0;
		for(long i = 1; i < 12000; i++) {
			for(long j = i+1; j <= 12000; j++) {
				if(hasNoCommons(i,j)) {
					if(tre * i > j) {
						if(two * i < j) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
		//7295372 is the correct answer
	}
	public static boolean hasNoCommons(long a, long b) {
		while(b != 0) {
			if(a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		if(a == 1) {
			return true;
		}
		return false;
	}
	
}
