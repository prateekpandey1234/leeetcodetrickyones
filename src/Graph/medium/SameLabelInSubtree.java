package Graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SameLabelInSubtree {
    class Solution {
        //this dfs here will return array after every call which allows to know about the childcounts easily
        public int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj,
                         char[] labels, int[] ans) {
            // Store count of all alphabets in the subtree of the node.
            int[] nodeCounts = new int[26];
            //making the count of nodecount to be 1
            nodeCounts[labels[node] - 'a'] = 1;

            if (!adj.containsKey(node))
                return nodeCounts;//this node count here will be the childcounts for it's parent node
            for (int child : adj.get(node)) {
                if (child == parent) {
                    continue;
                }
                int[] childCounts = dfs(child, node, adj, labels, ans);
                // Add frequencies of the child node in the parent node's frequency array.
                for (int i = 0; i < 26; i++) {
                    nodeCounts[i] += childCounts[i];
                }
            }
            //here we are updating our answer as our dfs call for one subtree is finished
            ans[node] = nodeCounts[labels[node] - 'a'];
            return nodeCounts;
        }

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            Map<Integer, List<Integer>> adj = new HashMap<>();
            // The computeIfAbsent(Key, Function) method of HashMap class is used to compute value for a given key using the given mapping function, if key is not already associated with a value (or is mapped to null) and enter that computed value in Hashmap else null.
            //creating adjancey list
            for (int[] edge : edges) {
                int a = edge[0], b = edge[1];
                adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
                adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
            }

            int[] ans = new int[n];
            char[] label = labels.toCharArray();
            dfs(0, -1, adj, label, ans);
            return ans;
        }
    }
}
