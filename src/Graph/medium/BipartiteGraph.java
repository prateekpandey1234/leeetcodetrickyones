package Graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private boolean check(int start, int V,
                          int[][] graph, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : graph[node]) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if(color[it] == -1) {

                    color[it] = 1 - color[node];
                    q.add(it);
                }
                // is the adjacent guy having the same color
                // someone did color it on some other path
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph)
    {
        int V = graph.length;
        int[] color = new int[V];
        for(int i = 0;i<V;i++) color[i] = -1;

        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(!check(i, V, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
