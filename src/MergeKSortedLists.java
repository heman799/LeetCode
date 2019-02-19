import java.util.*;

public class MergeKSortedLists {

//    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
//        public int compare(ListNode left, ListNode right) {
//            return left.val - right.val;
//        }
//    };



    private Comparator<ListNode> ListNodeComparator = (left, right) -> left.val - right.val;

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>(lists.size(), ListNodeComparator);

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }

        return dummy.next;
    }



    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("dog");
        pq.add("apple");
        pq.add("fox");
        pq.add("easy");
        pq.add("boy");

        while (!pq.isEmpty()) {
            for (String s : pq) {
                System.out.print(s + " ");
            }

            System.out.println();
            System.out.println("pq.poll(): " + pq.poll());
        }
    }
}
