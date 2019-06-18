public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        if (cost == null || cost.length == 0) {
            return -1;
        }
        if (gas.length != cost.length) {
            return -1;
        }

        //greedy
        int sum = 0;
        int total = 0; 
        int index = -1;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }

        return total < 0 ? -1 : index + 1;
    }
}