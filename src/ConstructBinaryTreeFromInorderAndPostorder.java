public class ConstructBinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length)
            return null;

        return buildMyTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode buildMyTree(int[] inorder, int iLeft, int iRght, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRght || pLeft > pRight)
            return null;

        TreeNode currRoot = new TreeNode(postorder[pRight]);
        int i = 0;
        for (i = iLeft; i < inorder.length; i++) {
            if (inorder[i] == currRoot.val) {
                break;
            }
        }

        currRoot.left = buildMyTree(inorder, iLeft, i -1, postorder, pLeft, pLeft + i -iLeft - 1);
        currRoot.right = buildMyTree(inorder, i + 1, iRght, postorder, pLeft + i - iLeft, pRight - 1);

        return currRoot;


    }

}
