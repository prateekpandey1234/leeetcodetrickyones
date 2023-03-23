package DyanamicProgramming.hard;

public class NumberofWaystoEarnPoints {
    class Solution {
//        int[][] dp;
//        public int waysToReachTarget(int target, int[][] types) {
//            dp=new int[target+1][types.length+1];//it will tell about number of ways to reach specific target using types
//            //here we can use our dfs by function
//            //dfs(i+1,target-j*types[i][1],types), where j=0->types[i][0] and i=0->n-1
//            //this target-j*types[i][1] return the remaining target val remained after using up j number of question of types[i][1] type
//            Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));//filling our dp with -1
//
//            return dfs(0,target,types);
//
//        }
//        public int dfs(int i,int target,int[][] types){
//            //base cases
//            if(target==0)return 1;//achieved 1 way
//            if(i>=types.length || target<0)return 0;//not a way
//
//            //memo
//            if(dp[target][i]!=-1)return dp[target][i];
//            //ans for specific dp[target][i]
//            int ans=0;
//            for(int j=0;j<=types[i][0];j++){
//                ans=(ans+dfs(i+1,target-j*types[i][1],types))% 1000000007;
//            }
//            return dp[target][i]=ans;
//        }
        //tabulisation
        public int waysToReachTarget(int target, int[][] types) {
            int n = types.length;
            int mod = 1000000007;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                int count = types[i][0];
                int mark = types[i][1];
                for (int j = target; j >= mark; j--) {
                    for (int k = 1; k <= count && j - k * mark >= 0; k++) {
                        dp[j] = (dp[j] + dp[j - k * mark]) % mod;
                    }
                }
            }
            return dp[target];
        }
    }
}
