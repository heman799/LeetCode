public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //max保存最大的子数组之和
        //每遍历一个数字num, 比较sum + num 和 num中的较大值存入sum
        //然后再把max和sum中的较大值存入max, 以此类推
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
