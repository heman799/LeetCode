import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxAreaOfIsland {
    static final int[] dirs = {0, -1, 0, 1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int area = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, bfs(grid, i, j, m, n));
                }
            }
        }
        return area;
    }

    private int bfs(int[][] grid, int x, int y, int m, int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(x * n + y);
        seen.add(x * n + y);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int cx = pos / n;
            int cy = pos % n;
            grid[cx][cy] = 0;
            count++;

            for (int i = 0; i < dirs.length - 1; i++) {
                int nx = cx + dirs[i];
                int ny = cy + dirs[i+1];
                if (isValid(grid, nx, ny, m, n, seen)) {
                    queue.offer(nx * n + ny);
                    seen.add(nx * n + ny);
                }
            }

        }
        return count;
    }

    private boolean isValid(int[][] grid, int x, int y, int m, int n, Set<Integer> set) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !set.contains(x * n + y)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] matrix = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(matrix));
    }
}
