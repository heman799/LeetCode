public class MinimumSubtree {

    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }

    // 1. return root's sum
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //divide + conquer + merge
        int sum = helper(root.left) + helper(root.right) + root.val;

        //traverse (compare with global variable)
        if (sum < subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }

        return  sum;
    }

    private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }


}
