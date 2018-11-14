public class UniquePath {
    public int uniquePaths(int m, int n) {
        if ( m == 0 || n == 0) {
            return 1;
        }

        int[][] sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }

        for (int j = 0; j < m;  j++) {
            sum[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = sum[i - 1] [j] + sum[i][j - 1];
            }
        }

        return sum[m - 1][n - 1];
    }

    public int uniquePath2(int[][] obstacleGrid){
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] paths = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < columns; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < rows; j++) {
                if (obstacleGrid[i][j]  != 1) {
                    paths[i][j] = paths[i-1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }

        return paths[rows - 1][columns - 1];
    }

}
