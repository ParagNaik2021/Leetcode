// Leetcode- 1091. Shortest Path in Binary Matrix
// GFG Shortest Distance in a Binary Maze

class tuple {
	int first, second, third;

	tuple(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
}

class Solution {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] != 0)
			return -1;
		int n = grid.length;
		int m = grid[0].length;

		// source and destination is same
		if (grid[0][0] == grid[n - 1][n - 1] && n == 1)
			return 1;

		Queue<tuple> Q = new LinkedList<>();

		int[][] dist = new int[n][m];

		// populating distance array with infinity
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = (int) 1e9;
			}
		}

		// add the source node in Q and mark its distance in dist[][] as 0
		dist[0][0] = 0;
		Q.add(new tuple(1, 0, 0));

		int drow[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
		int dcol[] = { 0, 0, 1, -1, -1, 1, -1, 1 };

		while (!Q.isEmpty()) {
			tuple it = Q.peek();
			Q.remove();
			int dis = it.first;
			int row = it.second;
			int col = it.third;

			for (int i = 0; i < 8; i++) {
				int newRow = row + drow[i];
				int newCol = col + dcol[i];

				// Check if the cell is not out of range
				// check if the cell is 0
				// check if the current distance is less than the previous
				if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
						&& grid[newRow][newCol] == 0
						&& dis + 1 < dist[newRow][newCol]) {

					dist[newRow][newCol] = dis + 1;
					// if we reach the destination
					if (newRow == n - 1 && newCol == n - 1)
						return dis + 1;

					Q.add(new tuple(1 + dis, newRow, newCol));

				}
			}
		}
		return -1;
	}
}