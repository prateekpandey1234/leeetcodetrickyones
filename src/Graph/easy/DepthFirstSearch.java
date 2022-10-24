package Graph.easy;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node);
        //marking current node as visited
        vis[node] = true;

        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj, storeDfs);
            }
        }
    }
     public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> storeDfs = new ArrayList<>();

        //boolean array to keep track of visited vertices
        boolean[] vis = new boolean[V+1];

        //If you are starting from node 2, then i should start from 2.
        for(int i = 1;i<=V;i++) {
            if(!vis[i]) dfs(i, vis, adj, storeDfs);
        }

        return storeDfs;
    }
    static void printAns(ArrayList < Integer > ans) {
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}
