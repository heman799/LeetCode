import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            bfs(board, 0, j);
            bfs(board, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }


    }

    void bfs(char[][] board, int sx, int sy) {
        if (board[sx][sy] != 'O') {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(sx);
        qx.offer(sy);
        board[sx][sy] = 'W';

        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n
                    && 0 <= ny && ny < m
                    && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W';
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }

        }
    }
}
