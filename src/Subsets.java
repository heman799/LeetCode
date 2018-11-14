import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }


    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }    
    
    public static void main(String[] args){
        int[] s = {1, 2, 2};
        Subsets subsets = new Subsets();
        List<List<Integer>> results = subsets.subsetsWithDup(s);
        for (List<Integer> result: results
             ) {
            System.out.println(result);
        }
        
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums == null) return results;

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        helperDup(nums, 0, subset, results);

        return results;
    }

    public void helperDup(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for(int i=startIndex; i < nums.length; i++) {
            if(i != startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            subset.add(nums[i]);
            helperDup(nums, i+1, subset, results);
            subset.remove(subset.size() - 1);

        }
    }
}
