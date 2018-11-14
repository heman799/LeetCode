import java.util.Arrays;

public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int replace = nums.length - 2;
        while (replace >= 0) {
            if (nums[replace] < nums[replace + 1])
                break;
            replace--;
        }

        if(replace < 0) {
            Arrays.sort(nums); // 6 5 4 3 2 1
            return nums;
        }

        //replace curr number with closest larger number
        int largerIndex = replace + 1;
        while (largerIndex < nums.length && nums[largerIndex] > nums[replace]) {
            largerIndex++;
        }

        swapItem(nums, largerIndex - 1, replace);
        Arrays.sort(nums, replace + 1, nums.length);
        return nums;
    }

    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 4 ,2};
        NextPermutation _nextPermutation = new NextPermutation();
        int[] results = _nextPermutation.nextPermutation(arr);
        for (int res: results
             ) {
            System.out.println(res + " ");
        }

    }
}
