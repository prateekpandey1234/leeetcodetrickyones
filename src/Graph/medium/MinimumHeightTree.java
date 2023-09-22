package Graph.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTree {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] E) {
            if (E.length == 0) {
                return List.of(0);
            }

            List<List<Integer>> G = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                G.add(new ArrayList<>());
            }

            for (int[] e : E) {
                int u = e[0];
                int v = e[1];
                G.get(u).add(v);
                G.get(v).add(u);
            }

            List<Integer> leaves = new ArrayList<>();
            List<Integer> newLeaves = new ArrayList<>();
            int[] inDegree = new int[n];

            for (int i = 0; i < n; i++) {
                if (G.get(i).size() == 1) {
                    leaves.add(i);
                }
                inDegree[i]=G.get(i).size();
            }
            //we take the condition of n>2 also here as we can imagine that maximum number of answers would be 2
            while (n > 2) {
                for (int leaf : leaves) {
                    for (int adj : G.get(leaf)) {
                        inDegree[adj]--;
                        if (inDegree[adj]== 1) {
                            newLeaves.add(adj);
                        }
                    }
                }
                n -= leaves.size();
                leaves = new ArrayList<>(newLeaves);
                newLeaves.clear();
            }

            return leaves;
        }
    }
}
