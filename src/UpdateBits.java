public class UpdateBits {
    public int updateBits(int n, int m, int i, int j) {

        // All 1's
        int max = ~0;

        //1's through position j, then 0's
        if (j == 31)
            j = max;
        else
            j = (1 << ( j + 1)) - 1;
        //1's before position j
        int left = max - j;
        //1's after position i
        int right = ((1 << i) - 1);
        //1's, with 0s between i and j
        int mask = left | right;
        //clear i through j, then put m in there
        return ((n & mask) | (m << i));
    }
}
