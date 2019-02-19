public class ClosetBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        if (target < root.val && root.left != null) {
            int left = closestValue (root.left, target);
            if (Math.abs(result - target) >= Math.abs(left - target))
                result = left;
        }
        else if (target > root.val && root.right != null) {
            int right = closestValue(root.right, target);
            if (Math.abs(result - target) >= Math.abs(right - target))
                result = right;
        }

        return result;
    }

}
