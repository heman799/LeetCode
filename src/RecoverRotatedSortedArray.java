import java.util.*;

public class RecoverRotatedSortedArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        for (int index = 0; index < nums.size() - 1; index++) {

        }
    }

    private void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
