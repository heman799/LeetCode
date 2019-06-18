public class Permutation {
    public long permutationIndex (int[] A) {
        long index = 0;
        long position = 2;
        long factor = 1;

        for (int p = A.length - 2; p >= 0; p--) {
            long successor = 0; // 在当前位之后小于其的个数
            for (int q = p + 1; q < A.length; q++) {
                if (A[p] > A[q]) {
                    successor++;
                }
            }
            index += factor * successor;
            factor *= position;
            position++;
        }

        return index + 1;
    }
}