import java.util.HashSet;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        int max = 0;
        for(int n : A) {
            if (n <= 0) {
                continue;
            }

            hashSet.add(n);
            max = Math.max(max, n);
        }

        for (int i = 1; i <= max; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return max + 1;
    }

    //another version
    public int firstMissingPositiveNumber(int[] A) {
        if (A == null)
            return 1;

        for (int i = 0; i < A.length; i++) {
            //while (A[i] > 0 && A[i] <= A.length)
        }

        return 0;
    }
}
