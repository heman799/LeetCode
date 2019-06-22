public class CountOfSmallerNumber {

    private int binarySearch(int[]A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target <= A[start]) {
            return start;
        }
        if (target <= A[end]) {
            return end;
        }
        return end + 1;
    }
}