package DyanamicProgramming.medium;

import java.util.Arrays;

public class LongestCommonSubsequenceDONE {
    //tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() ;
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];//index shifting
        for(int[] row:dp) Arrays.fill(row,-1);
        //what we do is here we just shift our array by 1 indices in both of them
        //like we are taking 0 as -1 , 1 as 0, n as n-1 so that we can return '0' as value just like
        // base case from memorisation
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n ][m ];
    }
    //memorisation
    public int helper(String text1,String text2, int i,int j , int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)) return dp[i][j]=1+helper(text1,text2,i-1,j-1,dp);
        else return  dp[i][j]= Math.max(helper(text1, text2, i - 1, j, dp), helper(text1, text2, i, j - 1, dp));
    }
}
