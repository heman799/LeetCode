import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    public static List<TreeNode> generateTrees(int n){
        return generateTreesDFS(1, n);
    }

    private static List<TreeNode> generateTreesDFS(int start, int end) {
        List<TreeNode> rst = new ArrayList<>();

        //exit for recursion
        if (start > end) {
            rst.add(null);
            return rst;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreesDFS(start, i - 1);
            List<TreeNode> right = generateTreesDFS(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    //should new a root here because it need to
                    //be different for each tree
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> result = generateTrees(n);
        for(TreeNode res : result) {
            System.out.println(res.val);
        }
    }
}
