package Graph.easy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DjasktraAlgo {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.

    static class Pair implements Comparable<Pair>{

        int src;
        int wt;

        public Pair(int src, int wt){
            this.src = src;
            this.wt = wt;
        }
        //this here is important to apply as we're using priority queue
        public int compareTo(Pair p){
            return this.wt - p.wt;
        }

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] distance = new int[V];
        for(int i = 0 ; i < V; i++)distance[i] = (int)1e8;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));
        distance[S] = 0;

        while(pq.size() > 0){

            Pair node = pq.remove();

            int src = node.src;
            int wt = node.wt;

            ArrayList<ArrayList<Integer>> graph = adj.get(src);

            for (ArrayList<Integer> list : graph) {

                int dest = list.get(0);
                int toReachDestinationdist = list.get(1);

                if (wt + toReachDestinationdist < distance[dest]) {
                    distance[dest] = wt + toReachDestinationdist;
                    pq.add(new Pair(dest, distance[dest]));
                }
            }
        }
        return distance;
    }
}

