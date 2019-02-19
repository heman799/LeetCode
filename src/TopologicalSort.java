import java.util.*;

public class TopologicalSort {

        /*
         * @param graph: A list of Directed graph node
         * @return: Any topological order for the given graph.
         */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();

        if (graph == null) {
            return order;
        }

        //1. count indegree
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        //2. topological sorting
        ArrayList<DirectedGraphNode> startNodes = getStartNodes(indegree, graph);

        //3. bfs
        order = bfs(indegree, startNodes);

        if (order.size() == graph.size()) {
            return order;
        }

        return null;
    }

    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                //node -> neighbor
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        return indegree;
    }

    private ArrayList<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegree,
                                                       ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> nodes = new ArrayList<>();
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                nodes.add(node);
            }
        }

        return nodes;
    }
    private ArrayList<DirectedGraphNode> bfs(Map<DirectedGraphNode, Integer> indegree,
                                             ArrayList<DirectedGraphNode> startNodes) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for (DirectedGraphNode node : startNodes) {
            order.add(node);
            queue.offer(node);
        }

        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                // node -> neighbor
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }

        return order;

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        DirectedGraphNode d0 = new DirectedGraphNode(0);
        DirectedGraphNode d1 = new DirectedGraphNode(1);
        DirectedGraphNode d2 = new DirectedGraphNode(2);
        DirectedGraphNode d3 = new DirectedGraphNode(3);
        DirectedGraphNode d4 = new DirectedGraphNode(4);
        DirectedGraphNode d5 = new DirectedGraphNode(5);

        d1.neighbors.add(d0);
        d2.neighbors.add(d0);
        d3.neighbors.add(d0);

        d4.neighbors.add(d1);
        d4.neighbors.add(d2);
        d4.neighbors.add(d3);

        d2.neighbors.add(d5);
        d3.neighbors.add(d5);

        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        graph.add(d0);
        graph.add(d1);
        graph.add(d2);
        graph.add(d3);
        graph.add(d4);
        graph.add(d5);


        TopologicalSort topologicalSort = new TopologicalSort();
        ArrayList<DirectedGraphNode> order = topologicalSort.topSort(graph);

        for (DirectedGraphNode node : order) {
            System.out.println(" -> " + node.label);
        }
    }

}


