import java.util.Arrays;
import java.util.List;

public class ContinuousSubarraySum {
    public List<Integer> continuousSubarraySum(int[] A){
        int n = A.length;
        int low = 0;
        long sum = 0;
        long max = Long.MIN_VALUE;
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum > max) {
                max = sum;
                ans[0] = low;
                ans[1] = i;
            }

            if (sum < 0) {
                sum = 0;
                low = i + 1;
            }
        }

        return Arrays.asList(ans[0], ans[1]);
    }
}
