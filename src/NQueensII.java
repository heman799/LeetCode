public class NQueensII {
    public static int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        placeQueens(usedColumns, 0);

        return sum;
    }

    private void placeQueens(int[] usedColumns, int row) {
        int n = usedColumns.length;

        if (row == n) {
            sum++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueens(usedColumns, row + 1);
            }
        }
    }


    private boolean isValid(int[] usedColumns, int row, int column) {
        for(int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (usedColumns[rowIndex] == column) {
                return false;
            }

            if (row - rowIndex == Math.abs(usedColumns[rowIndex] - column)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueensII queensII = new NQueensII();
        System.out.println(queensII.totalNQueens(n));
    }

}
