import java.util.HashMap;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) {
          return null;
      }

      HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
      RandomListNode dummy = new RandomListNode(0);
      RandomListNode pre = dummy;
      RandomListNode newNode;
      while (head != null) {
          //exist mapping already
          if (map.containsKey(head)) {
              newNode = map.get(head);
          }
          //create mapping
          else {
              newNode = new RandomListNode(head.label);
              map.put(head, newNode);
          }
          pre.next = newNode;

          //then copy random
          if (head.random != null) {
              if (map.containsKey(head.random)) {
                  newNode.random = map.get(head.random);
              }
              else {
                  newNode.random = new RandomListNode(head.random.label);
                  map.put(head.random, newNode.random);
              }
          }

          pre = newNode;
          head = head.next;
      }

      return dummy.next;

    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
}


