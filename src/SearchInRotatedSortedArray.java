public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
       int left = 0, right = A.length - 1;
       while ( left <= right) {
           int mid = left + (right - left) / 2;
           if (A[mid] == target) {
               return mid;
           }
           //look up in the right half(ascending)
           else if (A[mid] < A[right]) {
               if (A[mid] < target && A[right] >= target) {
                   left = mid + 1;
               }
               else {
                   right = mid - 1;
               }
           }
           //look up in the left half(ascending)
           else {
               if (A[left] <= target && A[mid] > target) {
                   right = mid - 1;
               }
               else {
                   left = mid + 1;
               }
           }
       }


       return -1;
    }
}
