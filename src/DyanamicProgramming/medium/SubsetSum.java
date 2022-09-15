package DyanamicProgramming.medium;

public class SubsetSum {
    //SPACE OPTIMIZED
    static boolean subsetSumToKSpaceOP(int n, int k,int[] arr){


        boolean prev[]= new boolean[k+1];

        prev[0] = true;

        if(arr[0]<=k)
            prev[arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = prev[target-arr[ind]];

                cur[target]= notTaken||taken;
            }
            prev=cur;

        }

        return prev[k];
    }
    //tabulisation
    static boolean subsetSumToK(int n, int k,int[] arr){


        boolean dp[][]= new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }

        return dp[n-1][k];
    }
    //memorisation
    static boolean subsetSumUtil(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target] != 0;//return false is the sum at this index with target value was zero

        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;//to check which condition works ...
        return notTaken||taken;
    }
}
