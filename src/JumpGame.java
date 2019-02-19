public class JumpGame {
    public boolean canJump(int[] A) {
        int n = A.length;
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach)
                return false;
            maxReach = Math.max(maxReach, A[i] + i);
        }

        return true;
    }

    public int jump(int[] A) {
        int res = 0, n = A.length, i = 0, cur = 0;
        while (cur < n - 1) {
            ++res;
            int pre = cur;
            for (; i <= pre; i++) {
                cur = Math.max(cur, i + A[i]);
            }
        }
        return res;

    }
}
