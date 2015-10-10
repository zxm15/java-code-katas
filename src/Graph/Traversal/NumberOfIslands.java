package Graph.Traversal;

/**
 * Created by ZXM on 10/10/15.
 * Given a boolean 2D matrix, find the number of islands.
 * Given graph:

 [
     [1, 1, 0, 0, 0],
     [0, 1, 0, 0, 1],
     [0, 0, 0, 1, 1],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 1]
 ]
 return 3.
 assume you can make changes to the original grid
 */

public class NumberOfIslands {
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};
    public int findNumberOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] != 1) return;
        grid[i][j] = 2; //mark the position as visited
        for (int k = 0; k < 4; k++) {
            dfs(grid, m, n, i + dx[k], j + dy[k]);
        }
    }

}
