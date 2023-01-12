package DyanamicProgramming.medium;

public class InterLeavingStrings {
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
        public boolean isInterleave2(String s1, String s2, String s3) {
            if (s3.length() != s1.length() + s2.length()) {
                return false;
            }
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    if(i==0 && j==0){
                        dp[i][j]=true;
                    }//checking for codtns such that the i==0 means no char from s1 but jth char from s2 is either equal to kth char in s3
                    //we are '&&' with dp[i][j-1] such to know that prev path is true upto here
                    else if(i==0){
                        dp[i][j]=dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
                    }
                    //similar else if
                    else if(j==0){
                        dp[i][j] = dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1);
                    }
                    //assuming here to get a substring which is formed by using both of the ith char and jth char from s1 and s2
                    else {
                        dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }
}
