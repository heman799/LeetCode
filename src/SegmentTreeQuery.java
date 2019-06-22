public class SegmentTreeQuery {
    public int query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.max;
        }

        int mid = (root.start + root.end)/2;
        int leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;

        //divided by mid, when end <= mid, all in left
        if (end <= mid) {
            leftmax = query(root.left, start, end);
        }

        //when end > mid, two cases
        if (mid < end) {
            //not cross
            if (start <= mid) {
                leftmax = query(root.left, start, mid);
                rightmax = query(root.right, mid + 1, end);
            } else {
                rightmax = query(root.right, start, end);
            }
        }

        return Math.max(leftmax, rightmax);
    }
}