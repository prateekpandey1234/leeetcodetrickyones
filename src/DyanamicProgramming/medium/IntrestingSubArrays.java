package DyanamicProgramming.medium;

import java.util.HashMap;
import java.util.List;

public class IntrestingSubArrays {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] presum = new int[nums.size()];
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1); // Well, this is a common practice when working with presum.
        long res = 0;
// we can not do old way of finding cost of each subarray using 0(n^2) method as it will go TLE
        //there we need to find a way such that we can find subarray sum in O(n)
        for(int i = 0; i < nums.size(); i++) {
            presum[i] = (nums.get(i) % modulo == k ? 1 : 0)  % modulo;
            if(i > 0) presum[i] = (presum[i] + presum[i - 1]) % modulo;
            int presumRemain = (presum[i] - k + modulo) % modulo; // finding the cnt of subarray refer to the comment below
            //here we are finding x%m from text below
            res += map.getOrDefault(presumRemain, 0);//checking if there exists a subarray of presum that we found
            map.put(presum[i], map.getOrDefault(presum[i], 0) + 1);// we found another subarray with this presum count
        }
        //System.out.println(Arrays.toString(presum));
        return res;
        //For those who are wondering why acc-k, the core formula is:
//        if (y-x) % M == k, then (y-k) % M == x % M
//        The proof is
//        say, x = sum[0, i-1], y = sum[0, r]. This is the prefix
//        y-x is sum[i, j]
//        for (y-x) % M == k, based on the distributive property, ((y % M) - (x % M)) % M == k
//        k < M, thus, k % M == k
//                ((y % M) - (x % M)) % M == k % M
//                (y % M) - (x % M) === k modulo equivalent , as k = k%M
//        (y % M) - (x % M) === k % M modulo equivalent
//        (y % M) - (k % M) === x % M modulo equivalent
//        use distributive law again, (y-k) % M === x % M modulo equivalent
    }
}
