public class PaintOfFence {
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0)
            return 0;

        int same = 0, diff = k;
        for (int i = 1; i < n; i++) {
            int temp = diff;
            diff =  (k - 1)*(same + diff);
            same = temp;
        }

        return same + diff;
    }
}
