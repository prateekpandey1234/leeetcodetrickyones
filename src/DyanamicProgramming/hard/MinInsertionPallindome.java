package DyanamicProgramming.hard;

import java.util.Arrays;

public class MinInsertionPallindome {
    public int minInsertions(String s1) {
        //the approach here is to first find longest pallindome subsequence and keep it same ...
        //then to make staring fully palindrome we need to :-
        //1. reverse the unpalindrome substrings
        //2. add them into opposite half of string
        //ex:-abcaa LP=aca
        //after changing = abacaba
        int n=s1.length();
        String s2=new StringBuilder(s1).reverse().toString();
        int m=s2.length();

        int[][] dp =new int[n+1][m+1];
        for(int[] rows :dp)
            Arrays.fill(rows,-1);
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] =   Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        //another question ans
        StringBuilder ans  = new StringBuilder();
        for(int i = n;i>-1;i--){
            for(int j = m;j>-1;j--){
                if(dp[i][j]!=0 && s1.charAt(i)==s2.charAt(j)){
                    ans.append(s1.charAt(i));
                }
            }
        }
        return n-dp[n][m];
    }
}
