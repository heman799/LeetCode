import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyCounter {
    class ListNode {
        public int count;
        public Set<String> keys = new HashSet<>();
        public ListNode next;
        public ListNode(String key, int count) {
            this.count = count;
            this.keys.add(key);
            this.next = null;
        }
    }

    private Map<String, ListNode> keyToPrev;
    private ListNode dummy, tail;

    public KeyCounter() {
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode("", 0);
        this.tail = this.dummy;
    }

    public void incrementCount(String key) {
        if (!keyToPrev.containsKey(key)) {
            //not insert yet
            if (dummy.next == null) {
                ListNode curr = new ListNode(key, 1);
                dummy.next = curr;
                tail = curr;
            } else {
                ListNode curr = dummy.next;
                curr.keys.add(key);
            }
            keyToPrev.put(key, dummy);
            return;
        }

        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;

        if (curr.next == null) {
            int currentCount = curr.count;
            ListNode newNode = new ListNode(key, currentCount + 1);
            curr.keys.remove(key);
            curr.next = newNode;
            keyToPrev.put(key, curr);
            tail = newNode;
        } else {
            curr.keys.remove(key);
            curr.next.keys.add(key);
            keyToPrev.put(key, curr);
        }
    }

    public void decrementCount(String key) {
        if (!keyToPrev.containsKey(key)) {

        }
    }

    public int getMaxCount() {
        return tail.count;
    }

    public int getMinCount() {
        return dummy.next.count;
    }

    public int getValue(String key) {
        if (!keyToPrev.containsKey(key)) {
            return 0;
        }
        ListNode prev = keyToPrev.get(key);
        return prev.next.count;
    }

    public static void main(String[] args) {
        KeyCounter keyCounter = new KeyCounter();
        keyCounter.incrementCount("Tom");
        keyCounter.incrementCount("Sam");
        keyCounter.incrementCount("Tony");
        keyCounter.incrementCount("Tom");
        keyCounter.incrementCount("Tom");
        keyCounter.incrementCount("Tony");
        System.out.println(keyCounter.getMaxCount());
        System.out.println(keyCounter.getMinCount());
        System.out.println(keyCounter.getValue("Tony"));
    }
}
