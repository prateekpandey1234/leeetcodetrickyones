package DyanamicProgramming.hard;

import java.util.Arrays;

public class MinimumSubsetDifference {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num:nums) sum+=num;
        int[][] dp = new int[n][sum+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        for(int i=0;i<=sum;i++){
            helper(n-1,i,nums,dp);//we are checking all possible sums are true or not
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[n-1][i]==0){
                int diff = Math.abs(2*i-sum);
                min = Math.min(min,diff);
            }
        }
        return min;

    }
    private boolean helper(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return true;

        if(ind == 0) {
            dp[ind][target] = arr[0] == target ? 0 : 1;
            return arr[0]==target;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target] == 0;//return false is the sum at this index with target value was zero

        boolean notTaken = helper(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = helper(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?0:1;//to check which condition works ...
        return notTaken||taken;
    }
}
