public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root){
        return helper(root, null, 0);
    }

    public int helper (TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }

        int length = (parent != null && root.val == parent.val + 1) ? lengthWithoutRoot + 1 : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);

        return Math.max(length, Math.max(left, right));
    }
}
