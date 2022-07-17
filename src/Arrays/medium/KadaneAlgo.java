package Arrays.medium;
/**Greedy Algorithm*/
public class KadaneAlgo {
        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE;
            int sum = 0;

            for(int elem: nums){
                sum += elem;
                ans = Math.max(ans, sum);
                if(sum < 0){
                    sum = 0;
                }
            }

            return ans;
        }
    }