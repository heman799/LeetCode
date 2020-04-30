public class BinarySearchTree {
    TreeNode root;
    TreeNode myParent;
    //constructor
    BinarySearchTree() {
        root = null;
        myParent = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.val < val) {
            root.right = insert(root.right, val);
        } else if (root.val > val) {
            root.left = insert(root.left, val);
        }
        return root;
    }



    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        myParent = root;
        if (root.val > key){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public void deleteNode(int key) {
        TreeNode p = search(root, key);

        if (p == null) return;
        //leaf node
        if (p.left == null && p.right == null) {
            deleteANodeWithoutChildren(p);
        }
        //one child
        if (p.left == null || p.right == null) {
            deleteANodeWith1Subtree(p);
        }
        //two children
        if (p.left != null && p.right != null) {
            deleteANodeWith2Subtrees(p);
        }

    }

    public void deleteANodeWithoutChildren(TreeNode p) {
        //special case
        if (p == root) {
            root = null;
            return;
        }
        TreeNode parent = myParent;
        if (parent.left == p)
            parent.left = null;
        else
            parent.right = null;
    }

    public void deleteANodeWith1Subtree(TreeNode p) {
        //p has left subtree
        if (p.right == null) {
            if (p == root) {
                root = root.left;
                return;
            }
            TreeNode parent = myParent;
            if (parent.left == p)
                parent.left = p.left;
            else
                parent.right = p.left;
        }
        if (p.left == null) {
            if (p == root) {
                root = root.right;
            }
            TreeNode parent = myParent;
            if (parent.left == p)
                parent.left = p.right;
            else
                parent.right = p.right;
        }
    }

    public void deleteANodeWith2Subtrees(TreeNode p) {
        //step1: find the deletion node
        //TreeNode p = search(root, key);
        //step2: find inorder successor
        TreeNode succ = p.right;
        TreeNode succParent = p;
        //special case: no left branch in right subtree
        if (succ.left == null) {
            p.val = succ.val;
            p.right = succ.right; //shortcut, replace a right subtree
            return;
        }
        //has leftmost child
        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }
        //step3: replace value of p with successor node
        p.val = succ.val;
        //step4: delete successor node, cover no right child condition
        succParent.left = succ.right;
    }
}
