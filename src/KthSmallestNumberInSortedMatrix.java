import java.util.*;

public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int[] dx = new int[] {0, 1};
        int[] dy = new int[] {1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, (a, b) -> a.val - b.val);
        minHeap.add(new Pair(0, 0, matrix[0][0]));

        for (int i = 0; i < k - 1; i++) {
            Pair curr = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int next_x = curr.x + dx[j];
                int next_y = curr.y + dy[j];
                Pair next_Pair = new Pair(next_x, next_y, 0);
                if (next_x < n && next_y < m && !hash[next_x][next_y]) {
                    hash[next_x][next_y] = true;
                    next_Pair.val = matrix[next_x][next_y];
                    minHeap.add(next_Pair);
                }
            }
        }
        return 0;
    }

    class Pair {
        public int x, y, val;
        public Pair (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}