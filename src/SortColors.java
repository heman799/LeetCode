public class SortColors {
    public void sortColors(int[] nums){
        if (nums == null || nums.length == 0) {
            return;
        }

        int red = 0;
        int blue = nums.length - 1;

        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                swap(nums, i, red++);
            }
            else if (nums[i] == 2) {
                swap(nums, blue--, i);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
