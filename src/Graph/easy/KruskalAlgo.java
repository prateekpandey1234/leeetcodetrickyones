package Graph.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgo {
    class Edge implements Comparable<Edge>{
        int src,dest,wt;
        Edge(int src, int dest, int wt){
            this.src=src;this.dest=dest;this.wt=wt;
        }
        //sorting based on weight
        public int compareTo(Edge o) {
            return this.wt-o.wt;
        }
    }
     int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int adjnode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge temp = new Edge(i,adjnode,wt);
                edges.add(temp);
            }
        }
        //disjoint as we defined as earlier in different class
        DisjointSet ds = new DisjointSet(V);
        //sorting the edges
        Collections.sort(edges);
        int mstWt=0;
        for(int i=0;i< edges.size();i++){
            int wt = edges.get(i).wt;
            int u = edges.get(i).src;
            int v= edges.get(i).dest;
            if(ds.findUPar(u)!=ds.findUPar(v)){
                mstWt+=wt;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;
    }
}
