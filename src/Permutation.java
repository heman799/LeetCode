import java.util.*;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        List<Integer> permutation = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        helper(nums, permutation, set, results);

        return results;
    }

    // 1. 找到所有以permutation 开头的排列
    public void helper(int[] nums,
                       List<Integer> permutation,
                       Set<Integer> set,
                       List<List<Integer>> results) {

        //3. 递归的出口
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            permutation.add(nums[i]);
            set.add(nums[i]);
            helper(nums, permutation, set, results);
            set.remove(nums[i]);
            permutation.remove(permutation.size() - 1);

        }
    }

    public static void main(String[] args){
        Permutation _permutation = new Permutation();
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = _permutation.permute(nums);
        for (List<Integer> result: results
             ) {
            System.out.println(result);
        }

    }
}
