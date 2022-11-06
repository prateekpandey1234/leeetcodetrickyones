

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;


public class Practice {
    class Pair implements Comparable<Pair>{
        int src;
        int dst;
        int stops;
        public Pair(int src,int dst, int stops){
            this.src = src;
            this.dst = dst;
            this.stops = stops;
        }
        public int compareTo(Pair p){
            return this.dst - p.dst;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int s, int d, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        for(int i=0;i<n;i++)dist[i]=(int)(1e9);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] fl:flights){
            adj.get(fl[0]).add(new Pair(fl[1],fl[2],k));
        }
        System.out.println(adj);
        pq.add(new Pair(s,0,k));
        int ans =-1;
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int src = node.src;
            int dst = node.dst;
            int stops = node.stops;
            if(stops==0){
                return ans;
            }
            for(int i=0;i<adj.get(src).size();i++){
                if(dst+adj.get(src).get(i).dst<dist[i]){
                    pq.add(new Pair(i,dst+adj.get(src).get(i).dst,k--));
                    dist[i]=dst+adj.get(src).get(i).dst;
                }
            }
        }
        return dist[d];
    }
}
