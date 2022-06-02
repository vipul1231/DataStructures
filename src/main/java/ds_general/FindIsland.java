package ds_general;

public class FindIsland {


	/**
	 * 0  0  0  0  0
	 *
	 * @param input
	 */

	public static int doDFS(int[][] input) {

		int row = input.length;
		int column = input[0].length;

		boolean isIslandFound = false;

		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (input[i][j] == 1) {
					int val = dfs(input, i, j);
					System.out.println(val);
					max = Math.max(val, max);
				}
			}
		}

		return max;
	}

	/**
	 * Do DFS
	 *
	 * @param input
	 * @param row
	 * @param column
	 */

	public static int dfs(int[][] input, int row, int column) {

		int row1 = input.length;
		int column1 = input[0].length;

		if (row < 0 || column < 0 || row >= row1 || column >= column1 || input[row][column] == 0 || input[row][column] == -1) {
			return 0;
		}

		input[row][column] = -1;
		//Cover 4 ways
		int val = 1 + dfs(input, row + 1, column);
		int val1 = val + dfs(input, row, column + 1);
		int val2 = val1 + dfs(input, row - 1, column);
		return val2 + dfs(input, row, column - 1);
	}


	public static void main(String[] args) {

//		int[][] input = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//		[0,0,0,0,0,0,0,1,1,1,0,0,0],
//		[0,1,1,0,1,0,0,0,0,0,0,0,0],
//		[0,1,0,0,1,1,0,0,1,0,1,0,0],
//		[0,1,0,0,1,1,0,0,1,1,1,0,0],
////		[0,0,0,0,0,0,0,0,0,0,1,0,0],
////		[0,0,0,0,0,0,0,1,1,1,0,0,0],
////		[0,0,0,0,0,0,0,1,1,0,0,0,0]];


		int[][] input = {{0, 0, 1, 0, 0, 0},
				{0, 0, 1, 0, 0, 1},
				{0, 0, 1, 0, 0, 1}};

		System.out.println("Max: " + doDFS(input));

		int[][] input1 = {{1}};
		System.out.println("Max: " + doDFS(input1));

		int[][] input2 = {{0}};
		System.out.println("Max: " + doDFS(input2));

		int[][] input3 = {{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1}};
		System.out.println("Max: " + doDFS(input3));
	}
}
