public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        curr.next = head;
        int m = length - k % length;
        for (int i = 0; i < m; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}
