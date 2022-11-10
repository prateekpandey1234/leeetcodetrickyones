package Graph.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultipicationsToReachEnd {
//here the intuition is that we will assume our numbers as node
    //eg. src = start and dst = end
    //we will follow djaskrta algo but will use queue instead of priority queue
    //cuz of we are moving 1 step every time and we have to reach end in minimum steps...
    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    class Solution {
        int minimumMultiplications(int[] arr,
                                   int start, int end) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(start, 0));
            int[] dist = new int[100000];
            for(int i = 0;i<100000;i++) dist[i] = (int)(1e9);
            dist[start] = 0;
            int mod = 100000;
            int n = arr.length;
            // O(100000 * N)
            //we will multiply the start with every number in array and increment steps by 1
            //then we will multiply the result from previous step to the array again
            while(!q.isEmpty()) {
                int node = q.peek().first;
                int steps = q.peek().second;
                q.remove();

                for(int i = 0;i < n; i++) {
                    int num = (arr[i] * node) % mod;
                    if(steps + 1 < dist[num]) {
                        dist[num] = steps + 1;
                        if(num == end) return steps + 1;
                        q.add(new Pair(num, steps + 1));
                    }
                }
            }
            return -1;
        }
    }
}
