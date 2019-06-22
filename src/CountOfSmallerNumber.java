public class CountOfSmallerNumber {

    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        if (queries == null || queries.length == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<>(queries.length);

        int lenA = (A == null) ? 0 : A.length;

        Arrays.sort(A);
        for (int query : queries) {
            if (lenA == 0) {
                ans.add(0);
            } else {
                ans.add(binarySearch(A, query));
            }
        }

        return ans;
    }
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