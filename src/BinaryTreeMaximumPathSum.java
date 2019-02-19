public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);
        return pathSumMax;
    }

    private int pathSumMax = Integer.MIN_VALUE;

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        pathSumMax = Math.max(pathSumMax, left + right + root.val);

        return Math.max(left, right) + root.val;

    }
}
