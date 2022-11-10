package Graph.easy;

import java.util.ArrayList;

public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S)

    {
        int[] dst = new int[V];
        for(int i=0;i<V;i++)dst[i]=(int)(1e8);
        dst[S]=0;
        //V*E
        //N-1 iterations...
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> it:edges){
                int u=it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                //relaxing the nodes
                if(dst[u]!= 1e8 && dst[u]+wt<dst[v]){
                    dst[v]=wt+dst[u];
                }
            }
        }
        //for detecting negative cycles;
        for(ArrayList<Integer> it:edges){
            int u=it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dst[u]!= 1e8  && dst[u]+wt<dst[v]){
                int[] temp = new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dst;
    }
}
