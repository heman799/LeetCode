import java.util.*;

public class BinaryTreeSerialization {
    public String serialization(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
           TreeNode node = queue.get(i);
           if (node == null) {
               continue;
           }
           queue.add(node.left);
           queue.add(node.right);
        }
        //Generated queue : {3,9,20,#,#,15,7,#,#,#,#};

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        //removed # queue: {3,9,20,#,#,15,7}


        //bfs to build a string
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialization(String data) {
        if (data.equals("{}")) {
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
              TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
              if (isLeftChild) {
                  queue.get(index).left = node;
              } else {
                  queue.get(index).right = node;
              }
              queue.add(node);
            }

            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;

        }

        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode d1 = new TreeNode(9);
        TreeNode d2 = new TreeNode(20);
        TreeNode d3 = new TreeNode(15);
        TreeNode d4 = new TreeNode(7);

        root.left = d1;
        root.right = d2;

        d2.left = d3;
        d2.right = d4;

        BinaryTreeSerialization binaryTreeSerialization = new BinaryTreeSerialization();

        String result = binaryTreeSerialization.serialization(root);
        System.out.println(binaryTreeSerialization.serialization(root));

        TreeNode newRoot = binaryTreeSerialization.deserialization(result);

        String a = "11";
        String b = "1";
        String c = addBinary(a, b);


        System.out.println(c);
    }

    public static String addBinary(String a, String b) {
        // Write your code here
        String ans = "";

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }

}
