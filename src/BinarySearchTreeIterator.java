import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator {
    //constructor
    public BinarySearchTreeIterator(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private Deque<TreeNode> stack = new ArrayDeque<>();

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next(){
        TreeNode curr = stack.pop();
        TreeNode node = curr;


        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return curr;
    }
}
