package DyanamicProgramming.medium;

public class MaximalSquare {


    class Solution {
        int n;
        int m;
        public int maximalSquare(char[][] matrix) {
            n=matrix.length;
            m=matrix[0].length;
            int[][] dp = new int[n][m];
            int edge=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    edge = Math.max(edge,helper(matrix,i,j,dp));
                    //we are doing traversal rather than our normal memo thing to know about maximum edge of the square as our original answer can be anywhere
                    //in the dp matrix ... we may be familiar with normal return dp[i][j] answer type but here the ans is not dependent of our last element in matrix
                }
            }
            return edge*edge;
        }
        public int helper(char[][] matrix,int i,int j,int[][] dp){
            if(i<0 || i>=n || j<0 || j>=m)return 0;//means that we are at edge cases and there will be no square formation through this particular node
            if(matrix[i][j]=='0')return 0;//means that our formation of square combining with neighbouring edges has failed
            if(dp[i][j]!=0)return dp[i][j];
            return dp[i][j]=Math.min(Math.min(helper(matrix,i,j-1,dp),helper(matrix,i-1,j,dp)),helper(matrix,i-1,j-1,dp))+1;
            //we're adding +1 in our dp as we know that it is already 1 in that node by above if condtn
            //so the need of using min instead of max is that we need to tell our parent node that we have reached either 0 or another 1
            //for example let submatrix = [1,1,1,0]
            //then for we will get ---> MIN(helper(i,j-1)=1 , helper(i-1,j)=1,helper(i-1,j-1)=0) = 0 which will tell us that we can not form square here
        }
    }
}
