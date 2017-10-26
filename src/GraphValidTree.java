import java.util.*;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges){
        if(n == 0){
            return false;
        }

        if(edges.length != n - 1){
            return false;
        }

        //key: Integer, value: Set(node's neighbor)
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        queue.offer(0);
        hash.add(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer neighbor : graph.get(node)){

                //if visited, continue to quit for
                if(hash.contains(neighbor)){
                    continue;
                }

                //otherwise add into hash
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }

        return (hash.size() == n);

    }


    //adjacency list : TODO
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }


        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

}
