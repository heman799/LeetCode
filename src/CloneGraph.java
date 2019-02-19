import java.util.*;

class UndirectedGraphNode{
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        //use bfs algorithm to traverse the graph and get all nodes
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        //copy nodes, store the old -> new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();

        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        //copy neighbors (edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);


    }


    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }

    public static void main(String[] args) {


        ArrayList list1 = new ArrayList();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        list1.add("five");
        list1.add(0,"zero");
        System.out.println("<--list1中共有>" + list1.size()+ "个元素");
        System.out.println("<--list1中的内容:" + list1 + "-->");

        ArrayList list2 = new ArrayList();
        list2.add("Begin");
        list2.addAll(list1);
        list2.add("End");
        System.out.println("<--list2中共有>" + list2.size()+ "个元素");
        System.out.println("<--list2中的内容:" + list2 + "-->");

        ArrayList list3 =  new ArrayList();
        list3.removeAll(list1);
        System.out.println("<--list3中是否存在one: "+ (list3.contains("one")? "是":"否")+ "-->");

        list3.add(0,"same element");
        list3.add(1,"same element");
        System.out.println("<--list3中共有>" + list3.size()+ "个元素");
        System.out.println("<--list3中的内容:" + list3 + "-->");
        System.out.println("<--list3中第一次出现same element的索引是" + list3.indexOf("same element") + "-->");
        System.out.println("<--list3中最后一次出现same element的索引是" + list3.lastIndexOf("same element") + "-->");


        System.out.println("<--使用Iterator接口访问list3->");
        Iterator it = list3.iterator();
        while(it.hasNext()){
            String str = (String)it.next();
            System.out.println("<--list3中的元素:" + list3 + "-->");
        }

        System.out.println("<--将list3中的same element修改为another element-->");
        list3.set(0,"another element");
        list3.set(1,"another element");
        System.out.println("<--将list3转为数组-->");
        // Object []  array =(Object[]) list3.toArray(new   Object[list3.size()] );
        Object [] array = list3.toArray();
        for(int i = 0; i < array.length ; i ++){
            String str = (String)array[i];
            System.out.println("array[" + i + "] = "+ str);
        }

        System.out.println("<---清空list3->");
        list3.clear();
        System.out.println("<--list3中是否为空: " + (list3.isEmpty()?"是":"否") + "-->");
        System.out.println("<--list3中共有>" + list3.size()+ "个元素");

        //System.out.println("hello world!");
    }
}




