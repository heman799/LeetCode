import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (num == null || num.length == 0) {
            return null;
        }

        Arrays.sort(num);
        List<Integer> combination = new ArrayList<>();
        helper(num, 0, combination, target, result);

        return result;

    }

    public void helper(int[] num, int startIndex, List<Integer> combination, int target, List<List<Integer>> result) {
        //3. exit for recursion
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }

            if (target < num[i]) {
                break;
            }

            combination.add(num[i]);
            helper(num, i + 1, combination, target - num[i], result);
            combination.remove(combination.size() - 1);
        }
    }
}
