package DyanamicProgramming.medium;

import java.util.Arrays;

//The problem can be broken down into subproblems which are reused several times. Overlapping subproblems lead us to
// Dynamic Programming.
//
//We decompose the problem as follows:
//
//State variable
//The start index and end index of a substring can identify a state, which influences our decision.
//So the state variable is state(start, end) indicates whether s[start, end] inclusive is palindromic
//
//Goal state
//max(end - start + 1) for all state(start, end) = true
//
//State transition
//
//for start = end (e.g. 'a'), state(start, end) is True
//for start + 1 = end (e.g. 'aa'), state(start, end) is True if s[start] = s[end]
//for start + 2 = end (e.g. 'aba'),  state(start, end) is True if s[start] = s[end] and state(start + 1, end - 1)
//for start + 3 = end (e.g. 'abba'),  state(start, end) is True if s[start] = s[end] and state(start + 1, end - 1)
//tabulation
public class LongestPallindome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        int ml = 0;
        int mr = 0;
        for (int r = 0; r < len; r++) {
            dp[r][r] = true;//to match same character as a==a , n==n
            for (int l = 0; l < r; l++) {
                // l  r
                // abca ...  //a = a, ok
                if (s.charAt(l) != s.charAt(r)) continue;
                // l  r
                // abca ...   //b != c continue
                if (l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;//checking states before
                dp[l][r] = true;
                if (r - l > mr - ml) {
                    ml = l;
                    mr = r;
                }
            }
        }
        return s.substring(ml, mr + 1);
    }
    //striver solution for subsequence
    static int lcs(String s1, String s2) {

        int n=s1.length();
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

        return dp[n][m];
    }

    static int longestPalindromeSubsequence(String s){
        String t = s;
        String ss=new StringBuilder(s).reverse().toString();
        return lcs(ss,t);
    }
}
