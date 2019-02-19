public class BinarySearch {

    public int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 1){
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                end = mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }

        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;

    }

    /*public int searchBigSortedArray(ArrayReader reader, int target) {
        //1. get the index that ArrayReader.get(index) >+ target in O(logk)
        //2. Binary search the target between 0 and index

        int index = 1;
        // >= target
        while(reader.get(index - 1) < target) {
            index = index * 2;
        }

        int start = 0, end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
         }

         if (reader.get(mid) < target) {
            start = mid;
         } else {
            end = mid;
         }

         if (reader.get(start) == target) {
            return start;
         }

         if (reader.get(end) == target) {
            return end;
         }

         return -1;

    }*/

}
