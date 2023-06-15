package DyanamicProgramming.medium;

import java.util.Arrays;

public class MinimumCostBinaryString {
    public long helper(int i, int n, String s, char lastChar, long[][] dp) {
        if (i == n) {
            return 0;
        }

        if (dp[i][lastChar - '0'] != -1) {
            return dp[i][lastChar - '0'];
        }

        if (s.charAt(i) == lastChar) {
            return dp[i][lastChar - '0'] = helper(i + 1, n, s, lastChar, dp);
        } else {
            return dp[i][lastChar - '0'] = Math.min(i + helper(i + 1, n, s, s.charAt(i), dp),
                    n - i + helper(i + 1, n, s, s.charAt(i), dp));
        }
    }

    public long minimumCost(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int n = s.length();
        long[][] dp = new long[n][2];
        //Each element dp[i][j] represents the minimum cost computed for the
        // substring starting at index i with the last character as j.
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(1, s.length(), s, s.charAt(0), dp);
    }
    //greedy
    public long minimumCost2(String s) {
        long res = 0;
        for (int i = 1, n = s.length(); i < n; ++i)
            if (s.charAt(i) != s.charAt(i - 1))
                res += Math.min(i, n - i);
        return res;
    }
}
