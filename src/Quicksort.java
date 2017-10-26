public class Quicksort {

    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while(arr[left] < pivot) {
                left++;
            }

            while(arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }

        }
        return left;
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void quicksort (int[] array) {

    }

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        //partition these lelement
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
    }


}
