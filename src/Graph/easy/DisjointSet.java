package Graph.easy;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    //class needed to create while solving questions
    class DSU {
        int[] parent;
        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i)
                parent[i] = i;
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
