public class SegmentTreeModify {
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }

        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modify (root.left, index, value);
        }

        if (mid < index && index <= root.end) {
            modify (root.right, index, value);
        }

        root.max = Math.max(root.left.max, root.right.max);
    }
}