public class DigitCounts {
    public int digitCounts(int k, int n) {
        int count = 0;
        for (int i = k; i <= n; i++) {
            count += singleCount(i, k);
        }
        return count;
    }

    public int singleCount(int i , int k) {
        if ( i == 0 && k == 0) {
            return 1;
        }

        int count = 0;
        while ( i > 0) {
            if ( i % 10 == k) {
                count++;
            }
            i = i / 10;
        }

        return count;
    }
}
