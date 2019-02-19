public class Triangle {

    private int n;
    private int[][] minSum;
    private int[][] triangle;


    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }

        if (triangle[0] == null || triangle[0].length == 0){
            return -1;
        }

        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        //initialize minSum all nodes to MAX_VALUE
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return search(0, 0);
    }



    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }

        //exit for recursion
        //value has been calculated in matrix
        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        //next row search
        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle[x][y];
        return minSum[x][y];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        Triangle triangle = new Triangle();

        System.out.println(triangle.minimumTotal(arr));

    }
}
