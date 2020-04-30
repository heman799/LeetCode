import java.util.HashMap;
import java.util.Map;
public class LRUCache {
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    public int get(int key) {
        if(!keyToPrev.containsKey(key)) {
            return -1;
        }

        moveToTail(key);
        return tail.val;
    }

    public void set(int key, int value) {
        //if already exist in the linkedlist
        //we use get() method to move this one to tail
        if(get(key) != -1) {
           ListNode prev = keyToPrev.get(key);
           prev.next.val = value;
           return;
        }

        //this key doesn't exist in the linkedlist
        //size < capacity
        if (size < capacity) {
            size++;
            ListNode curr = new ListNode(key, value);
            tail.next = curr;
            keyToPrev.put(key, tail);
            tail = curr;
            return;
        }

        ListNode first = dummy.next;
        keyToPrev.remove(first.key);

        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);

        moveToTail(key);
    }

    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;

        //if curr is already the tail
        if(tail == curr) {
            return;
        }

        prev.next = prev.next.next;
        tail.next = curr;

        if(prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }

        keyToPrev.put(key, tail);
        tail = curr;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        lruCache.get(2);
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
