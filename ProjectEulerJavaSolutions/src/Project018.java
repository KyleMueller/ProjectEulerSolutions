
public class Project018 {

	/**
	 * Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
	 * 
	 * 
	 * Attack plan: R-E-C-U-R-S-I-O-N
	 */
	public static void main(String[] args) {
		int[][]A = new int[15][15];
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				A[i][j] = 0;
			}
		}
		//first two rows
		A[0][0] = 75;
		A[1][0] = 95; A[1][1] =64;
		//row 3+
		String temp = "17 47 82";
		String[] a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[2][i] = Integer.parseInt(a[i]);
		}
		
		temp = "18 35 87 10";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[3][i] = Integer.parseInt(a[i]);
		}
		
		temp = "20 04 82 47 65";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[4][i] = Integer.parseInt(a[i]);
		}
		
		temp = "19 01 23 75 03 34";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[5][i] = Integer.parseInt(a[i]);
		}
		
		temp = "88 02 77 73 07 63 67";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[6][i] = Integer.parseInt(a[i]);
		}
		
		temp = "99 65 04 28 06 16 70 92";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[7][i] = Integer.parseInt(a[i]);
		}
		
		temp = "41 41 26 56 83 40 80 70 33";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[8][i] = Integer.parseInt(a[i]);
		}
		
		temp = "41 48 72 33 47 32 37 16 94 29";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[9][i] = Integer.parseInt(a[i]);
		}
		
		temp = "53 71 44 65 25 43 91 52 97 51 14";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[10][i] = Integer.parseInt(a[i]);
		}
		
		temp = "70 11 33 28 77 73 17 78 39 68 17 57";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[11][i] = Integer.parseInt(a[i]);
		}
		
		temp = "91 71 52 38 17 14 91 43 58 50 27 29 48";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[12][i] = Integer.parseInt(a[i]);
		}
		
		temp = "63 66 04 68 89 53 67 30 73 16 69 87 40 31";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[13][i] = Integer.parseInt(a[i]);
		}
		
		temp = "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		a = temp.split(" ");
		for(int i = 0; i < a.length; i ++) {
			A[14][i] = Integer.parseInt(a[i]);
		}
		
		System.out.println(doTheRecursion(0,0,A));
		//1074 is the correct answer
		
	}
	public static int doTheRecursion (int startR, int startC, int[][]A) {
		if(startR == 14) {
			return A[startR][startC];
		}
		else {
			int a = doTheRecursion(startR + 1, startC + 1, A);
			int b = doTheRecursion(startR + 1, startC, A);
			if(a >= b) {
				return A[startR][startC] + a;
			}
			else {
				return A[startR][startC] + b;
			}	
		}
	}

}
