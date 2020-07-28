public class Project015 {
/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move 
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 */
	public static void main(String[] args) {
		//quick google search gave this formula....
		//It's from the binomial coeffecient formula
		int gridSize = 20;
		long paths = 1;
		 
		for (int i = 0; i < gridSize; i++) {
		    paths = paths* ((2 * gridSize) - i);
		    paths = paths/(i + 1);
		}
		System.out.println(paths);
		
		//137846528820 is the correct solution.
	}

}
