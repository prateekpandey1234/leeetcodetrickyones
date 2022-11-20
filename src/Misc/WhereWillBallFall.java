package Misc;

public class WhereWillBallFall {
    //dp soln
    int n;
    int m;
    public int[] FindBall(int[][] grid){
        int[] ans = new int[m];
        int[][] dp = new int[n][m];
        for(int i=0;i<grid[0].length;i++)
        {
            int k = fall(0,i,grid,dp);
            ans[i] = (k>0?k-1:k); //As DP has 0 as a default value to control the dispute I am  returning j+1 i.e for 0 column it will return 1 hence to control this we are using this line.
// This is done just for the ease i didnt want to populate dp with -2 or anyother number. hence had to do this.   
        }
        return ans;
    }
    public int fall(int i,int j,int[][] grid,int[][] dp){
        if(i>=n) return j+1;
        if(dp[i][j]!=0) return dp[i][j];
        if(grid[i][j]==1){
            if(j+1>m || grid[i][j]==-1)return -1;//for right wall(the "1" type of walls can tilt ball to wall) and V Shape
            else{
                return dp[i][j]=fall(i+1,j+1,grid,dp);
            }
        }
        if(grid[i][j]==-1){
            if(j-1<0 || grid[i][j-1]==1)return -1;//for left wall(the "-1" type of walls can tilt ball to wall) and V Shape
            else{
                return dp[i][j]=fall(i+1,j-1,grid,dp);
            }
        }
        return -1;
    }
    //dfs soln
    public int[] findBall_1(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++)
            res[j] = helper(grid, 0, j);
        return res;
    }

    private int helper(int[][] grid, int i, int j) {
        if (grid[i][j] == 1 && (j + 1 >= grid[0].length || grid[i][j + 1] != grid[i][j])) return -1;
        if (grid[i][j] == -1 && (j - 1 < 0 || grid[i][j - 1] != grid[i][j])) return -1;

        j += grid[i][j] == 1 ? 1 : -1;
        if (i == grid.length - 1) return j;
        return helper(grid, ++i, j);
    }
}
