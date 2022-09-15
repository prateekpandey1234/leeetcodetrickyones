package DyanamicProgramming.easy;

import java.util.Arrays;

public class FrogJump {
    static int solve(int ind,int[] height,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;//because we are going backwards , we can not jump 2 if we are at i=1
        int jumpOne= solve(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
        if(ind>1)
            jumpTwo = solve(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);

        return dp[ind]=Math.min(jumpOne, jumpTwo);
        //space optimized method
//       int height[]={30,10,60,10,60,50};
//  int n=height.length;
//   int prev=0;
//  int prev2=0;
//        for(int i=1;i<n;i++){
//
//      int jumpTwo = Integer.MAX_VALUE;
//      int jumpOne= prev + Math.abs(height[i]-height[i-1]);
//      if(i>1)
//        jumpTwo = prev2 + Math.abs(height[i]-height[i-2]);
//
//      int cur_i=Math.min(jumpOne, jumpTwo);
//      prev2=prev;
//      prev=cur_i;
//
//  }
    }
//here the state is the index of heights with heights hence we first define every index as -1
//

    public static void main(String args[]) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solve(n-1,height,dp));
    }
}
