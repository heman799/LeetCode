import java.util.*;

public class LongestConsecutiveElementsSequence {
    public static List<Integer> longestConsecutive(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        int smallest = 0;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left)) left--;
            while (set.remove(right)) right++;
            if (right - left - 1 > maxLength) {
                maxLength = right - left - 1;
                if (left == num - 1) {
                    smallest = num;
                }
                else {
                    smallest = left + 1;
                }
            }
            if (set.isEmpty()) break;
        }
        while (maxLength-- > 0) {
            res.add(smallest++);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
