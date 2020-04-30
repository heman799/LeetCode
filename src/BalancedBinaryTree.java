
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    public ResultType helper(TreeNode root){
        //3.exit
        if (root == null) {
            return new ResultType(false, -1);
        }

        //2.split
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if(!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        int depth = Math.max(left.maxDepth, right.maxDepth) + 1;
        return new ResultType(true, depth);
    }

    class ResultType {
        public boolean isBalanced;
        public int maxDepth;
        //ctor
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }
}
