import java.util.Stack;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        //find left most child and push path into stack
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        //now root is equal to null
        for (int i = 0; i < k - 1; i++) {
            TreeNode node = stack.peek();

            //no right child
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            //has right child
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

            }
        }

        return stack.peek().val;
    }
}
