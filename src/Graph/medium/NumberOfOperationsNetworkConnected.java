package Graph.medium;

import Graph.easy.DSU;

public class NumberOfOperationsNetworkConnected {

    public int makeConnected(int n, int[][] edges) {
       DSU ds = new DSU(n);
        //we just need to check whether there is enough extra edges for connecting the components
        int cnte=0;
        int m = edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v =edges[i][1];
            if(ds.find(u)==ds.find(v))cnte++;
            else ds.union(u,v);
        }
        int cntc=0;
        //we can check number of components like below
        for(int i=0;i<n ;i++){
            if(ds.parent[i]==i)cntc++;
        }
        return (cnte>=cntc-1)?cntc-1:-1;

    }
}
