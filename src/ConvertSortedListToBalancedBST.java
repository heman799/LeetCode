public class ConvertSortedListToBalancedBST {

    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);

    }

    public int getListLength(ListNode head){
        int size = 0;

        while(head != null) {
            size++;
            head = head.next;
        }

        return size;
    }


    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size/2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size/2);

        root.left = left;
        root.right = right;

        return root;
    }






    private void balance(TreeNode root,int[] arr, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(root, arr[middle]);
            balance(root, arr, first, middle - 1);
            balance(root,arr, middle + 1, last);
        }
    }

    private void insert(TreeNode root, int val) {
        TreeNode p = root;
        TreeNode prev = new TreeNode(0);

        while (p != null) {
            prev = p;
            if (val < p.val){
                p = p.left;
            } else
                p = p.right;
        }

        if (root == null ) {
            root = new TreeNode(val);
        }
        else if (val < prev.val){
            prev.left = new TreeNode(val);
        }
        else
            prev.right = new TreeNode(val);

    }

    public void main(String[] args) {



    }

}
