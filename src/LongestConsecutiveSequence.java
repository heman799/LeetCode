import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    // 我们也可以采用哈希表来做，刚开始哈希表为空，然后遍历所有数字，
    // 如果该数字不在哈希表中，那么我们分别看其左右两个数字是否在哈希表中，
    // 如果在，则返回其哈希表中映射值，若不在，则返回0，
    // 然后我们将left+right+1作为当前数字的映射，并更新res结果，
    // 然后更新d-left和d-right的映射值

    public static int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                continue;
            }
            int left = hashMap.containsKey(num - 1) ? hashMap.get(num - 1) : 0;
            int right = hashMap.containsKey(num + 1) ? hashMap.get (num + 1) : 0;

            int sum = left + right + 1;
            hashMap.put(num, sum);

            result = Math.max(result, sum);

            // range = (num - left, num + right), update map value of boundary
            hashMap.put (num - left, sum);
            hashMap.put (num + right, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
