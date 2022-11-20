package Graph.medium;

import Graph.easy.DisjointSet;

public class NumberOfOperationsNetworkConnected {

    public int makeConnected(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        //we just need to check whether there is enough extra edges for connecting the components
        int cnte=0;
        int m = edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v =edges[i][1];
            if(ds.findUPar(u)==ds.findUPar(v))cnte++;
            else ds.unionBySize(u,v);
        }
        int cntc=0;
        //we can check number of components like below
        for(int i=0;i<n ;i++){
            if(ds.parent.get(i)==i)cntc++;
        }
        return (cnte>=cntc-1)?cntc-1:-1;

    }
}
