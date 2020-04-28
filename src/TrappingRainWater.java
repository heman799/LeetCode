import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int water = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!queue.isEmpty() && heights[i] > heights[queue.peekLast()]) {
                int j = queue.pollLast();

            }
            queue.offer(i);
        }

        return 0;
    }
}