import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, combination, result);

        return result;
    }

    //1.递归的定义： 找到所有combination 开头的组合， 后面部分的和是target的组合
    private static void helper(int[] candidates, int index, int target, List<Integer> combination,
                List<List<Integer>> result){
        //3. 递归的出口
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        //2. 递归的拆解
        //[] -> [2], [3], [6], [7]
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i != 0 && candidates[i] == candidates[i - 1]){
                continue;
            }

            combination.add(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(arr, target);

        System.out.println(result);
    }
}
