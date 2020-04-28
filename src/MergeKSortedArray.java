import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] mergekSortedArrays(int[][] arrays) {
        int[] result = {};
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return result;
        }

        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                count++;
                queue.add(arrays[i][j]);
            }
        }

        result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
