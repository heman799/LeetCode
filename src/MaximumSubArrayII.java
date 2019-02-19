import java.util.*;

public class MaximumSubArrayII {
    public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.isEmpty())
            return -1;

        int size = nums.size();
        int[] maxSubArrayLeft = new int[size];
        forwardTraversal(nums, maxSubArrayLeft);

        int[] maxSubArrayRight = new int[size];
        backwardTraversal(nums, maxSubArrayRight);

        int maxTwoSub = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            maxTwoSub = Math.max(maxTwoSub, maxSubArrayLeft[i] + maxSubArrayRight[i+1]);
        }

        return maxTwoSub;
    }

    private static void forwardTraversal(List<Integer> nums, int[] maxSubArray){
        int sum = 0, minSum = 0, maxSub = Integer.MIN_VALUE;
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            maxSub = Math.max(maxSub, sum - minSum);
            minSum = Math.min(sum, minSum);
            maxSubArray[i] = maxSub;
        }
    }

    private static void backwardTraversal(List<Integer> nums, int[] maxSubArray) {
        int sum = 0, minSum = 0, maxSub = Integer.MIN_VALUE;
        int size = nums.size();
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            maxSub = Math.max(maxSub, sum - minSum);
            minSum = Math.min(sum, minSum);
            maxSubArray[i] = maxSub;

        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-2,2,-3,4,-1,2,1,-5,3);
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        System.out.print(maxTwoSubArrays(arrayList));
    }
}

