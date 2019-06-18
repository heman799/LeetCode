public class SegmentTreeBuilt {
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build (start, mid);
            root.right = build (mid + 1, end);
        }
        return root;
    }
}