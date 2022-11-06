package Graph.medium;

import java.util.*;

public class MinimumEffortPath {
    //here we using binary search and Bfs ...

    private int[] d = {0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int lo = 0, hi = 1_000_000;
        //the use of binary search is that the effort is lying between 1-10**6 value and we just need to find it
        while (lo < hi) {
            int effort = lo + (hi - lo) / 2;
            if (isPath(heights, effort)) {
                hi = effort;
            }else {
                lo = effort + 1;
            }
        }
        return lo;
    }
    private boolean isPath(int[][] h, int effort) {
        //we are using BFS to confirm that whether there is a path such that it's effort is equal to effort we calculated
        //from binary search
        int m = h.length, n = h[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);
        //we can use vis array also but using set is faster ....
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (int k = 0; k < 4; ++k) {
                int r = x + d[k], c = y + d[k + 1];
                if (0 <= r && r < m && 0 <= c && c < n && effort >= Math.abs(h[r][c] - h[x][y]) && seen.add(r * n + c)) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        return false;
    }
    //here we are using Djiskarta method, but we are changing the total dist with the effort of that path
    // which is max difference between two consecutive nodes in the path
    class Solution2 {
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            minHeap.offer(new int[]{0, 0, 0}); // distance, row, col
            dist[0][0] = 0;

            while (!minHeap.isEmpty()) {
                int[] top = minHeap.poll();
                int d = top[0], r = top[1], c = top[2];
                if (d > dist[r][c]) continue; // this is an outdated version -> skip it
                if (r == m - 1 && c == n - 1) return d; // Reach to bottom right
                for (int i = 0; i < 4; i++) {
                    int nr = r + DIR[i], nc = c + DIR[i + 1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                        if (dist[nr][nc] > newDist) {
                            dist[nr][nc] = newDist;
                            minHeap.offer(new int[]{dist[nr][nc], nr, nc});
                        }
                    }
                }
            }
            return 0; // Unreachable code, Java require to return interger value.
        }
    }
}
