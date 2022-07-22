package Arrays.medium;
/**when draw out the matrix it will be like a staircase with negative and positive numbers ...
 * you just have to analyse the staircases nothing else */
public class CountNegativeIn2D {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (grid[i][j] < 0) {
                res += m - i;
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
