package DyanamicProgramming.hard;

import java.util.Arrays;

public class BuysAndSellStocks3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length;
        int profit = 0;

        // scan from left
        // left[i] keeps the max profit from 0 to i
        int[] left = new int[n];
        int min = prices[0];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        // scan from right
        // right[i] keeps the max profit from i to n - 1
        int[] right = new int[n];
        int max = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);

            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }
    //memo solution using 3D DP where we are using our 3 states as i , buy flag and no of stocks left to buy
    public int maxProfit2(int[] prices) {
         int[][][] dp = new int[prices.length + 1][2][3];// 0 - > to not buy ,1 -> to buy
        //0,1,2-> no of stock left to buy or the limit var here
         for(int[][] row : dp) for(int[] col : row) Arrays.fill(col, -1);
         return helperMem(prices, 0, 1, 2, dp);

    }
    public int helperMem(int[] prices, int index, int buy, int limit, int[][][] dp){
        // Base Case
        if(index == prices.length) return 0;
        if(limit == 0) return 0;

        if(dp[index][buy][limit] != -1) return dp[index][buy][limit];
        int totalProfit = 0;
        if(buy == 1){
            int buyKaro = -prices[index] + helperMem(prices, index + 1, 0, limit, dp);
            int skipKaro = helperMem(prices, index + 1, 1, limit, dp);
            totalProfit = Math.max(buyKaro, skipKaro);
        }else{
            int sellKaro = prices[index] + helperMem(prices, index + 1, 1, limit - 1, dp);
            int skipKaro = helperMem(prices, index + 1, 0, limit, dp);
            totalProfit = Math.max(sellKaro, skipKaro);
        }
        return dp[index][buy][limit] = totalProfit;
    }

}
