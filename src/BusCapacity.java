import java.util.ArrayList;
import java.util.List;

public class BusCapacity {
    public static List<Integer> getPossibleBusCapacity(int[] groups) {
        List<Integer> results = new ArrayList<>();
        int capacity = 0;
        for (int i = 0; i < groups.length; i++) {
            capacity += groups[i];
            int sum = 0;
            for (int j = i + 1 ; j < groups.length; j++) {
                sum += groups[j];
                if (sum > capacity) {
                    break;
                }

                if (sum < capacity) {
                    continue;
                }

                if (sum == capacity) {
                    if (j == groups.length - 1) {
                        results.add(capacity);
                    } else {
                        sum = 0;
                    }
                }
            }
        }
        results.add(capacity);

        return results;
    }
    public static void main(String[] args) {
        int[] groups = {1, 2, 1, 1, 1, 1, 2, 3};
        List<Integer> results = BusCapacity.getPossibleBusCapacity(groups);
        for(int result : results) {
            System.out.println(result);
        }
    }
}
