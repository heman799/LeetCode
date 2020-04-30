public class WoodCut {
    public static int getLongestCutLen(int[] woods, int k) {
        //corner case
        if (woods.length == 0 || k == 0) return 0;
        //lowerBound and upperBound
        int left = 1, right = Integer.MAX_VALUE;
        int res = 0;
        if (!isValid(woods, left, k)) return 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(woods, mid, k)) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid;
            }
        }
        return res;
    }

    public static boolean isValid(int[] woods, int cutLen, int k) {
        int count = 0;
        for (int wood : woods) {
            count += wood / cutLen;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        int[] woods = {5,5,9};
        int k = 6;
        System.out.println(getLongestCutLen(woods, k));
    }
}
