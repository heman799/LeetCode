public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        for (int i = k; i < nums.length; i++) {
            //滚动数组，减去最开头的，加上新的
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}
