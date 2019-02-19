public class MaximumProductSubarray {

    // O(1) space complexity
    public int maxProduct(int[] nums) {
        int res = nums[0], max = res, min = res;
        int maxPre = res, minPre = res;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
            min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
            res = Math.max(res, max);
            maxPre = max;
            minPre = min;
        }

        return res;
    }

}
