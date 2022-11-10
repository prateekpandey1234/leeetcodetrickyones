package Graph.easy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgo {
    class Pair {
        int dist;
        int node;

        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = dist;
        }

        public int PrimsAlgo(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
            PriorityQueue<Pair> pq =
                    new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);
            int[] vis = new int[V];
            pq.add(new Pair(0, 0));
            int sum = 0;
            while (pq.size() > 0) {
                int wt = pq.peek().dist;
                int node = pq.peek().node;
                pq.remove();
                if (vis[node] == 1) continue;
                vis[node] = 1;
                sum += wt;
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int edW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);
                    if (vis[adjNode] != 1) {
                        pq.add(new Pair(edW, adjNode));
                    }
                }
            }
            return sum;
        }
    }
}
