import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    private void search(List<List<String>> results, List<Integer> cols, int n) {

        //3. exit for recursion
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, cols.size(), colIndex)) {
                continue;
            }

            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String>  drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValid(List<Integer> cols, int row, int column) {

        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            // on the same row
            if (cols.get(rowIndex) == column) {
                return false;
            }

            if (row - rowIndex == Math.abs(cols.get(rowIndex) - column)) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens();
        List<List<String>> results = nQueens.solveNQueens(n);
        for(List<String> result : results) {
            for (String s : result) {
                System.out.println(s);
            }
        }

    }
}
