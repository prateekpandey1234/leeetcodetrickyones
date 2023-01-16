package Arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSlidingWindow {
    public long countGood(int[] nums, int k) {
        //here , we will use sliding window method
        // here the condition for our sliding window case will be that if our number of pair will be more than k than
        // we will decrease the length of our array and move to next values otherwise we will increase our array size
        int n = nums.length;
        //this map here will be updated and changed everytime during 2nd while loop in code to track frequency of elements
        // in the subarray
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int l = 0;
        long ans=0;
        for(int r=0;r<n;r++) {
            int curr = nums[r];
            int currFreq = freq.getOrDefault(nums[r], 0);
            //this count here will be tracking the number of pairs in the subarray
            //if there is number already in subarray and is same as our next element then count =1 (1= freq of next num)
            count+=currFreq;
            //we will increment our freq map
            freq.put(nums[r], currFreq+1);
            //now this here will be condition for our sliding window method
            while(count >= k) {
                //we are removing our leftmost element in subarray to check whether we get count>=k or not in current subarray
                count = count - (freq.get(nums[l])-1);
                // now we will update the frequency of our removed num in map
                freq.put(nums[l], freq.get(nums[l])-1);
                l++;
            }
            //as we change the length of our array by incrementing l we know that we have generated our required subarrays
            //l will only change when above loop runs that means we have achieved our required subarrays
            // and the number of time l gets incremented that number of subarrays have been generated
            ans+=l;
        }
        return ans;}
}
