import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        //insert node into arrayList "queue" -> {3,9,20,#,#,15,7,#,#,#,#}
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        //removed # --> queue = {3, 9, 20, #, #, 15, 7}
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        //bfs to build a string
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);

        for(int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(", #");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("{}"))
            return null;

        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;

        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(vals[0]));
                if(isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }

                queue.add(node);
            }

            if(!isLeftChild) {
                index++;
            }

            isLeftChild = !isLeftChild;

        }

        return root;
    }

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println(a == c);
        System.out.println(a == e);



    }
}


