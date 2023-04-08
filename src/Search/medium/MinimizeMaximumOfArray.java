package Search.medium;

import java.util.Collections;
import java.util.List;

public class MinimizeMaximumOfArray {
    //so we are here first of all using the observation that
//1.we can increment and decrement any two pairs of numbers in array
// ex:-- 3,7,1,6
//       i=1 --> 4,6,1,6
//       i=2 --> 4,7,0,6
//       i=3 --> 4,7,1,5
//       we can see that 7 and 1 remain unchanged but 3 and 6 were changed
//2.the total sum of array will be less than answer*length_of_array
// ex:- 3,7,1,6
//      ans = 5 -->  17<4*5 --> sum<length*ans
//from above these observations ,specially the second one we try to use binary search
//method where left = 0 , right =10**9 and left will return answer
//and for checking in binary search we will use prefix sum method which will
//stasify our 2nd obervation as:
//   prefixsum <=(i+1)*x , where i+1 will be current length and x is our mid

    //O(NlogN)
    class Solution {
        public boolean isValid(List<Integer> nums, long mid) {
            long sum = 0;
            long maxNum = Integer.MIN_VALUE;

            for (int i = 0; i < nums.size(); i++) {
                sum += nums.get(i);
                if (sum > (i + 1) * mid) {
                    return false;
                }
            }

            return true;
        }

        public int minimizeArrayValue(List<Integer> nums) {
            int n = nums.size();

            int low = 0;
            int high = Collections.max(nums);
            int mid;

            while (low < high) {
                mid = (low + high) >>> 1;

                if (isValid(nums, mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return high;
        }
    }
//from above same observation we can simply remove binary search from our code and
//just iterate over array by comparing prefixsum similarly as in 2nd our obervation
//class Solution {
//     public int minimizeArrayValue(int[] A) {
//         long sum = 0, res = 0;
//         for (int i = 0; i < A.length; ++i) {
//             sum += A[i];
//             res = Math.max(res, (sum + i) / (i + 1));
//         }
//         return (int)res;
//     }
// }


}
