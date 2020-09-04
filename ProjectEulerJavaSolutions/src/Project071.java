public class Project071 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cap = 1000000;
		long a = 3;
		long b = 7;
		long r = 1;
		long s = 8;
		
		for(int q = cap; q > 2; q--) {
			//p is the highest numerator possible such that
			//p/q < a/b or 3/7
			long p = (a * q - 1) / b;
			//p/q has to be greater than r/s
			//mult each by qs
			//ps > rq
			if(p * s > r * q) {
				//new closest
				s = q;
				r = p;
			}
			if(q%10000 == 0) {
				System.out.println("Percent: " + q/10000);
			}
		}
		System.out.println(r + "/" + s);
	}
}

