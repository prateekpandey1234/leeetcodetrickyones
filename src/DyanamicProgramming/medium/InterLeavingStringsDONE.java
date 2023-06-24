package DyanamicProgramming.medium;

public class InterLeavingStringsDONE {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int[][] dp = new int[s1.length()][s2.length()];
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    dp[i][j]=-1;
                }
            }
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            return helper(s1,s2,s3,0,0,0,dp);
        }
        public boolean helper(String s1,String s2,String s3,int i,int j,int k,int[][] dp){
            //base case here will be the codtn to check whether we  finished one string or not
            if(i==s1.length()){
                return s2.substring(j).equals(s3.substring(k));
            }
            if(j==s2.length()){
                return s1.substring(i).equals(s3.substring(k));
            }
            //checking for overlapping soln
            if(dp[i][j]>=0){return dp[i][j] == 1;}
            boolean ans = s3.charAt(k) == s1.charAt(i) && helper(s1, s2, s3, i + 1, j, k + 1, dp)
                    || s3.charAt(k) == s2.charAt(j) && helper(s1, s2, s3, i, j + 1, k + 1, dp);
            //if any of the cases pass
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        public boolean isInterleaveTab(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();

            if (s3.length() != m + n) {
                return false;
            }

            boolean[][] dp = new boolean[m + 1][n + 1];

            // Base case initialization
            dp[0][0] = true;

            // Fill the first row
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
            }

            // Fill the first column
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            }

            // Fill the remaining cells
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char c = s3.charAt(i + j - 1);
                    if (c == s1.charAt(i - 1) && c == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else if (c == s1.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (c == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[m][n];
        }
    }
}
