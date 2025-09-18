package Graph.easy;

import java.util.*;

public class KahnsAlgoTopoLogicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        //this algorithm can also be used as onion peel algorithm , it can also help us find center of an
        // graph
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] indeg = new int[n];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<n;i++)arr.add(new ArrayList<>());
        for(int [] e:edges){
            indeg[e[0]]++;
            indeg[e[1]]++;
            arr.get(e[0]).add(e[1]);
            arr.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==1)q.add(i);
        }

        int remainingNodes=n;
        while(remainingNodes>2){
            int sz = q.size();
            remainingNodes-=sz;
            while(sz-- >0){
                int i=q.poll();
                for(int j:arr.get(i)){
                    indeg[j]--;
                    if(indeg[j]==1){
                        q.add(j);
                    }
                }
            }
        }
        return new ArrayList<>(q);

    }




    
}





