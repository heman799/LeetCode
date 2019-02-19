import java.util.*;

public class RouteBetweenTwoNodesInGraph {
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        if (s == t) {
            return true;
        }

        HashSet<DirectedGraphNode> visited = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (visited.contains(node.neighbors.get(i))){
                    continue;
                }

                visited.add(node.neighbors.get(i));
                queue.offer(node.neighbors.get(i));
                if (node.neighbors.get(i) == t) {
                    return true;
                }

            }
        }

        return false;
    }
}
