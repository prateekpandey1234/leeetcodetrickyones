package DyanamicProgramming.medium;

public class WaysToBuildGoodString {
    Integer[] dp;
    int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Integer[high +1];
        int ans =0;
        for(int i=low; i<= high; i++){
            ans =(ans + helper(i, zero, one)) % MOD;
        }
        return ans;
    }

    private int helper(int n, int zero, int one){
        if(n <0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int takeZero = helper(n-zero, zero, one) % MOD;
        int takeOne = helper(n-one, zero, one) % MOD;

        return dp[n] = (takeZero + takeOne) % MOD;
    }
}
