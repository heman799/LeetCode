public class MaxPerimeterOfIsland {
    public int maxPerimeterOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxPerimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxPerimeter = Math.max(maxPerimeter, dfs(grid, i, j));
                }
            }
        }
        return maxPerimeter;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[i].length-1 || grid[i][j]==0) {
            return 1;
        }

        if (grid[i][j] == -1) return 0;

        int count = 0;
        grid[i][j] = -1;

        count += dfs(grid,i-1, j);
        count += dfs(grid,i+1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);
        return count;
    }

    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }

    public static void main(String[] args) {
        MaxPerimeterOfIsland maxPerimeter = new MaxPerimeterOfIsland();
        int[][] matrix = {{1,1,0,0,0},{1,1,0,0,1},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxPerimeter.maxPerimeterOfIsland(matrix));
    }
}
