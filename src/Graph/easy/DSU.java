package Graph.easy;

import java.util.ArrayList;
import java.util.List;


    //class needed to create while solving questions
    public     class DSU {
        public int[] parent;
        public int[] depth;
        public DSU(int N) {
            parent = new int[N];
            depth = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
                depth[i]=0;
            }
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            int r1 = find(x);
            int r2 = find(y);
            if(r1==r2)return;
            //depth will help differentiate larger parents and allow to union correctly always use it
            if(depth[r1]<depth[r2]){
                int t = r1;
                r1=r2;
                r2=t;
            }
            parent[r2] = r1;
            if(depth[r1]==depth[r2])depth[r1]++;
        }
    }

        // Union function to merge the components of two nodes
//        private void union(int node1, int node2) {
//            int root1 = find(node1);
//            int root2 = find(node2);
//
//            // If the two nodes are already in the same component, do nothing
//            if (root1 == root2) return;
//
//            // Union by depth: ensure the root of the deeper tree becomes the parent
//            if (depth[root1] < depth[root2]) {
//                int temp = root1;
//                root1 = root2;
//                root2 = temp;
//            }
//
//            // Merge the two components by making root1 the parent of root2
//            parent[root2] = root1;
//
//            // If both components had the same depth, increase the depth of the new root
//            if (depth[root1] == depth[root2]) {
//                depth[root1]++;
//            }
//        }

