package Graph.medium;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    //the main observation we can get here is that if a node is incoming to any cycle or is part of a cycle it is not
    // a safe node... because if then we will always end up at those nodes which have loops..
    private boolean dfsCheck(int node, int[][] graph, int vis[],
                             int pathVis[], int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        // traverse for adjacent nodes
        for (int it : graph[node]) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, graph, vis, pathVis, check))
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
        // Your code here
    }
    //the BFS approach is quite simple ... we just have to reverse the edges of graph such that terminal nodes
    //(which have outdegree of 0 ) will have indegree of 0 and using this we can apply Kahns algo for topo sort
    // to find out those nodes which are safe
}
