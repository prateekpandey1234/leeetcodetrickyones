package Matrix.medium;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    public int snakesAndLadders(int[][] board) {
        //so there were two approachs but all of them were based on BFS ,.. as backtracking would be waste ... it was BFS as we can see that we will traverse through 6 blocks at same step .. meaning if step increases by 1 we can go +1,+2,+3,+4,+5,+6 steps ... the main implementation would be converting that 2D array into 1D as it will be much easier... after that easy BFS implementaion
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            //if we reach end of the row ... we will decrease our j
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            }//if we reach start of our row ... we will increase our j
            else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        //standard BFS method ...
        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new LinkedList<>();
        int start = arr[0] > -1 ? arr[0] - 1 : 0;
        q.offer(start);
        visited[start] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                //found our step
                if (cur == n * n - 1) {
                    return step;
                }
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
                    //checking whether there is ladder or snake
                    int dest = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            //step will only increase by 1
            step++;
        }
        //not found steps
        return -1;
    }
}
