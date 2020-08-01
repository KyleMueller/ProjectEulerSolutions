
public class Project028 {
	/**
	 * https://projecteuler.net/problem=28
	 * 
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 
spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed 
in the same way?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] spiral = new int[1001][1001];
		int farRight = 501;
		int farLeft = 499;
		int farTop = 499;
		int farBottom = 500;
		spiral[500][500] = 1;
		int direction = 1; //1 for right, 2 for down, 3 for left, 4 for up
		int currentR = 500;//row
		int currentC = 501;//col both for the next input
		
		//fill the spiral
		for(int i = 2; i < 1002002; i++) {
			spiral[currentR][currentC] = i;
			//System.out.println("Input: "+ i + " At R: "+ currentR + " C: "+ currentC);
			if(direction == 1) {
				if(currentC >= (farRight)) {//right
					//reached new top right, turn down
					direction = 2;
					farRight = currentC + 1;
					//same column, new row
					currentR++;
				}else {
					//continue right
					currentC++;
				}
			} else if(direction == 2) {//down
				if(currentR >= farBottom) {
					//reach new bottom right, turn left
					direction = 3;
					farBottom = currentR + 1;
					//same row, new col
					currentC--;
				} else {
					//continue down
					currentR++;
				}
			} else if(direction == 3) {//left
				if(currentC <= farLeft) {
					//reached new bottom left, turn up
					direction = 4;
					farLeft = currentC - 1;
					//same col,one less row
					currentR--;
				}
				else {
					//continue left
					currentC--;
				}
			} else {//turn up
				if(currentR <= farTop) {
					//reached new top, turn right
					direction = 1;
					farTop = currentR - 1;
					//one col right,
					currentC++;
				}
				else {
					//continue up
					currentR--;
				}
			}
			if(checkZero(spiral)) {
				break;
			}
			
		}
		int sum = -1;//1 is counted twice, start at -1 and not 0
		for(int i = 0; i < 1001; i++) {
			sum = sum + spiral[i][i];
			sum = sum + spiral[i][1000-i];
		}
		System.out.println(sum);
		//669171001 is the correct answer

	}
	public static boolean checkZero(int[][]A) {
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				if(A[i][j] == 0) {
					return false;
					
				}
			}
		}
		return true;
	}

}
