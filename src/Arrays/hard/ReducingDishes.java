package Arrays.hard;

import java.util.Arrays;

public class ReducingDishes {
    //greddy approach
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int maxSatisfaction = 0;
        int suffixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0 && suffixSum + satisfaction[i] > 0; i--) {
            // Total satisfaction with all dishes so far.
            suffixSum += satisfaction[i];
            // Adding one instance of previous dishes as we add one more dish on the left.
            maxSatisfaction +=  suffixSum;
        }
        return maxSatisfaction;
    }
    //dp solution
    //memorization
    public int maxSattisfaction(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){Arrays.fill(dp[i],-1);};
        return memo(arr,dp,0,1);
    }
    public int memo(int[] arr, int[][] dp, int i, int time){
        if(i>=arr.length)return 0;
        if(dp[i][time]!=-1)return dp[i][time];
        //we either take or don't take
        return dp[i][time]=Math.max(arr[i]*time+memo(arr,dp,i+1,time+1),memo(arr,dp,i+1,time));
    }
    //tabulation
    public int maxSatisfaction2(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 2];
        // Mark all the states initially as 0.
        for (int i = 0; i <= satisfaction.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            for (int j = 1; j <= satisfaction.length; j++) {
                dp[i][j] = Math.max(satisfaction[i] * j + dp[i + 1][j + 1], dp[i + 1][j]);
            }
        }

        return dp[0][1];
    }
    //space optimized
    public int maxSatisfaction3(int[] satisfaction) {
        Arrays.sort(satisfaction);
        // Array to keep the result for the previous iteration.
        int[] prev = new int[satisfaction.length + 2];
        Arrays.fill(prev, 0);
        for (int index = satisfaction.length - 1; index >= 0; index--) {
            // Array to keep the result for the current iteration.
            int[] dp = new int[satisfaction.length + 2];

            for (int time = 1; time <= satisfaction.length; time++) {
                dp[time] = Math.max(satisfaction[index] * time + prev[time + 1], prev[time]);
            }
            prev = dp;
        }
        return prev[1];
    }
}
