import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();


        List<Integer> combination = new ArrayList<>();
        helper(results, combination, n, k, 1);

        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> combination, int n, int k, int index) {

        //exit for recursion
        if (combination.size() == k) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i = index; i <= n; i++) {
            combination.add(i);
            helper(results, combination, n, k, i + 1);
            combination.remove(combination.size() - 1);
        }

    }
}
