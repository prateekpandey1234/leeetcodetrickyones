package Graph.hard;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLengthIncreasingPath {
    class Solution {
        //simple bfs using q.size() method would make it TLE so the best method would be using DP and doing topo sort using the Onion Peel method
        //simple DFS + MEMO
        public int longestIncreasingPath(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            if (row == 1 && col == 1) {
                return 1;
            }

            int max = 0;
            int[][] memo = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (memo[i][j] == 0) {
                        max = Math.max(max, dfs(matrix, memo, i, j));
                    }
                }
            }

            return max;
        }

        public int dfs(int[][] matrix, int[][] memo, int x, int y) {
            if (memo[x][y] > 0) {
                return memo[x][y];
            }

            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            int ans = 1;

            int row = matrix.length;
            int col = matrix[0].length;

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                if (matrix[nextX][nextY] <= matrix[x][y]) {
                    continue;
                }

                ans = Math.max(ans, dfs(matrix, memo, nextX, nextY) + 1);
            }

            memo[x][y] = ans;
            return ans;
        }
        //her is anohter method of using topo sort where we use the outdegree of each element as the number of paths going through it
        class Solution2 {
            public int longestIncreasingPath(int[][] matrix) {
                int row = matrix.length;
                int col = matrix[0].length;
                if (row == 1 && col == 1) {
                    return 1;
                }

                int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

                int[][] outDegrees = new int[row][col];
                //our idea would be topo sort the nums such as we travel from the number starting from very low in our increasing path
                // which has some of it's neighbour greater than it's current value
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        for (int[] dir : dirs) {
                            int nextX = i + dir[0];
                            int nextY = j + dir[1];
                            //checking if there is greater neighbour next to current

                            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || matrix[nextX][nextY] <= matrix[i][j]) {
                                continue;
                            }

                            outDegrees[i][j]++;//increasing outdegree of the node as we want to go through the each nodes
                        }
                    }
                }

//adding all those which have outdegree ==0 as they would be our starting point for out path
                Queue<int[]> queue = new LinkedList<>();
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (outDegrees[i][j] == 0) {
                            queue.offer(new int[]{i, j});
                        }
                    }
                }
//as we go first thorugh all those nodes whose which have outdegree==0
                int max = 0;
                while (!queue.isEmpty()) {
                    max++;
                    int size = queue.size();
                    //removing all those nodes with outdegree ==0 at once
                    for (int i = 0; i < size; i++) {
                        int[] curPos = queue.poll();
                        int x = curPos[0];
                        int y = curPos[1];
                        for (int[] dir : dirs) {
                            int prevX = x + dir[0];
                            int prevY = y + dir[1];

                            if (prevX < 0 || prevX >= row || prevY < 0 || prevY >= col) {
                                continue;
                            }

                            if (matrix[prevX][prevY] >= matrix[x][y]) {
                                continue;
                            }
                            //adding those nodes with outdegree ==0 as we peel thorugh each layer to the path
                            if (--outDegrees[prevX][prevY] == 0) {
                                queue.offer(new int[]{prevX, prevY});
                            }
                        }
                    }
                }

                return max;
            }
        }
    }
}
