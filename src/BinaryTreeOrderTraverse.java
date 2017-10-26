import java.util.*;

public class BinaryTreeOrderTraverse {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        //interface
        //poll, offer
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }

        //1. put start node into queue
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<ArrayList<Integer>> stack = new Stack<>();
        queue.offer(root);



        int level = 0;


        //2. while queue is not empty
        while(!queue.isEmpty()){
            //3. level x --> x + 1
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){ // level x
                TreeNode head = queue.poll();
                currentLevel.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);  // level x
                }
                if(head.right != null){
                    queue.offer(head.right);  //level x + 1
                }

            }

            //no deep copy
            stack.add(currentLevel);

        }

        while(!stack.isEmpty()){
            results.add(stack.pop());
        }

        return results;
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        dfs(rst, new ArrayList<Integer>(), root, 0, sum);

        return rst;
    }


    public void dfs(List<List<Integer>> rst, ArrayList<Integer> list, TreeNode node, int add, int sum){
        list.add(node.val);
        if (node.left == null && node.right == null){
            if (add + node.val == sum) {
                rst.add(new ArrayList<Integer>(list));
            }
            return;
        }

        if (node.left != null){
           dfs(rst, list, node.left, add + node.val, sum);
           list.remove(list.size() - 1);
        }

        if (node.right != null){
            dfs(rst, list, node.right, add + node.val, sum);
            list.remove(list.size() - 1);
        }

    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        if (root == null){
            return rst;
        }



        dfs(rst, String.valueOf(root.val), root );

        return rst;
    }

    public void dfs(List<String> rst, String path, TreeNode node){
        if (node.left == null && node.right == null){
            rst.add(path);
        }

        if (node.left != null){
           dfs(rst, path + "->" + String.valueOf(node.left.val), node.left);
        }

        if (node.right != null){
            dfs(rst, path + "->" + String.valueOf(node.right.val), node.right);
        }
    }


}
