import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strs, comparator);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        String result = sb.toString();
        //check if first is 0


        return result.charAt(0) == '0' ? "0" : result;

    }

    public static void main(String[] args) {
        int[] nums = {1, 20, 23, 4, 8};
        System.out.println(largestNumber(nums));
    }


    private static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    };
}
