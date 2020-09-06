
public class Project112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		int count = 0;
		double per = 0.99;
		
		int i = 1;
		while(true) {
			if(isBouncy(i)) {
				count++;
			}
			total++;
			if(isPer(count, total, per)) {
				break;
			}
			i++;
		}
		System.out.println(i);
		//1587000 is the correct answer
	}
	public static boolean isPer(int a, int b, double per) {
		double c = ((double)a)/((double)b);
		if(c == per) {
			return true;
		}
		return false;
	}
	public static boolean isBouncy(int a) {
		if(isIncreasing(a) || isDecreasing(a)) {
			return false;
		}
		return true;
	}
	public static boolean isIncreasing(int a) {
		String A = a + "";
		for(int i = 0; i < A.length() - 1; i++) {
			if(Integer.parseInt(A.charAt(i+1) + "") < 
					Integer.parseInt(A.charAt(i) + "")) {
				return false;
			}
		}
		return true;
	}
	public static boolean isDecreasing(int a) {
		String A = a + "";
		for(int i = 0; i < A.length() - 1; i++) {
			if(Integer.parseInt(A.charAt(i+1) + "") > 
					Integer.parseInt(A.charAt(i) + "")) {
				return false;
			}
		}
		return true;
	}

}
