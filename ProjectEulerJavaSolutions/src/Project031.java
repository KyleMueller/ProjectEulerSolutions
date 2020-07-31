
public class Project031 {
/**https://projecteuler.net/problem=31
 * 
In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int a = 0; a <= 1; a++) {//200 = a
			for(int b = 0; b <= 2; b++) {//100 = b
				for(int c = 0; c <= 4; c++) {//50 = c
					for(int d = 0; d <= 10; d++) {//20 = d
						for(int e = 0; e <= 20; e++) {//10 = e
							for(int f = 0; f <= 40; f++) {//5 = f
								for(int g = 0; g <= 100; g++) {//2 = g
									for(int h = 0; h <= 200; h++) {//1 = h
										int val = 200*a + 100*b + 50*c + 20*d + 10*e + 5*f +
												2*g + 1*h;
										if(val == 200) {
											count++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		//73682 is the right answer
		//first try mate.
	}

}
