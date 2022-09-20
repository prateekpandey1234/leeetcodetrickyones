package DyanamicProgramming.medium;

public class Knapsack01 {
    //memorisation
    static int knapsackUtil(int[] wt,int[] val, int ind, int W,int[][] dp){

        if(ind == 0){
            if(wt[0] <=W) return val[0];
            else return 0;
        }
        //the following condition replaces the function in recursion when we use tabulation
        if(dp[ind][W]!=-1)
            return dp[ind][W];
        int ans = (int) Math.pow(10,9);
        int notTaken = 0 + knapsackUtil(wt,val,ind-1,W,dp);

        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt,val,ind-1,W-wt[ind],dp);

        return dp[ind][W] = Math.max(notTaken,taken);
    }
    //tabulation
    static int knapsack(int[] wt,int[] val, int n, int W){

        int[][] dp = new int[n][W+1];

        //Base Condition
        //here we fill those spaces with intial value(val[0]) because we are starting from beginning
        //we are checking here whether we can take our starting value (val[0]) if the capcity of bag is more than or equal
        //to the wight of item at i=0... we are taking this as base condition
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken =  dp[ind-1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind-1][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }
}
