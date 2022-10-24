package Graph.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirected {
    static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }}
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean[] vis)
    {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] =true;

        // until the queue is empty
        while(!q.isEmpty())
        {
            // source node and its parent node
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for(Integer it: adj.get(node))
            {
                if(!vis[it])
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if(par != it) return true;
            }
        }

        return false;
    }

    // function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
            if(!vis[i])
                if(checkForCycle(adj, i,vis ))
                    return true;

        return false;
    }
    //DFS
    public boolean CycleDFS(int V , ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]) {
                if(checkDFS(adj, i, vis, -1)) return true;
            };
        }
        return false;
    }
     boolean checkDFS(ArrayList<ArrayList<Integer>> adj,int s , boolean[] vis,int par){
        vis[s] = true;
        for(Integer adjnode:adj.get(s)){
            if(!vis[adjnode]){
                if(checkDFS(adj,adjnode,vis,s)) return true;
            }
            else if(adjnode!=par) return true;
        }
        return false;
     }
}
