public class ValidateBinarySearchTree {

    //Solution 1: based on its property: left < root < right
//    public boolean isValidBST(TreeNode root) {
//        if (root == null)
//            return true;
//        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean valid(TreeNode root, long low, long high) {
//        if (root == null)
//            return true;
//
//        if (root.val <= low || root.val >= high)
//            return false;
//
//        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
//    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        TreeNode curr = root, prev = null, parent = null;
        boolean flag = true;
        while(curr == null) {
            if (curr.left != null) {
                if (parent != null && parent.val >= curr.val) {
                    flag = false;
                }
                parent = curr;
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    if (parent.val >= curr.val)
                        flag = false;

                    parent = curr;
                    curr = curr.right;
                }
            }
        }

        return flag;

    }
}
