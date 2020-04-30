import java.util.ArrayList;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lca(root, p, q);
        if (lca == p) {
            return find(p, q) == true ? lca : null;
        } else if (lca == q) {
            return find(q, p) == true ? lca : null;
        }
        return lca;
    }

    public boolean find (TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return find(root.left, node) || find(root.right, node);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

/*    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get (indexA) != pathB.get(indexB)){
                break;;
            }
            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }

        return lowestAncestor;
    }

    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node){
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }*/

}
