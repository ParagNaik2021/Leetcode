// Leetcode- 1631. Path With Minimum Effort
// GFG Shortest Distance in a Binary Maze

class Tuple {
	int distance, row, col;

	Tuple(int distance, int row, int col) {
		this.distance = distance;
		this.row = row;
		this.col = col;
	}
}

class Solution {
	public int minimumEffortPath(int[][] heights) {
		PriorityQueue<Tuple> PQ = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);

		int n = heights.length;
		int m = heights[0].length;
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = (int) 1e9;
			}
		}
		dist[0][0] = 0;
		PQ.add(new Tuple(0, 0, 0));
		int[] drow = { -1, 0, +1, 0 };
		int[] dcol = { 0, 1, 0, -1 };
		while (PQ.size() != 0) {
			Tuple it = PQ.peek();
			PQ.remove();
			int diff = it.distance;
			int row = it.row;
			int col = it.col;

			if (row == n - 1 && col == m - 1)
				return diff;

			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
					int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);

					if (newEffort < dist[nrow][ncol]) {
						dist[nrow][ncol] = newEffort;
						PQ.add(new Tuple(newEffort, nrow, ncol));
					}
				}
			}

		}
		return 0;
	}
}