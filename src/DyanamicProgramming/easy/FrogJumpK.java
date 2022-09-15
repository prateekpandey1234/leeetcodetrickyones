package DyanamicProgramming.easy;

import java.util.Arrays;

public class FrogJumpK {
    static int solve(int ind,int k,int[] height,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jump = Integer.MAX_VALUE;
        for(int i=0;i<k+1;i++){
            if(ind-i>=0){
                jump = Math.min(jump,solve(ind-i,k,height,dp)+Math.abs(height[ind]-height[ind-i]));
            }
        }
        return jump;
    }


    public static void main(String args[]) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solve(n-1,9,height,dp));
    }
}
