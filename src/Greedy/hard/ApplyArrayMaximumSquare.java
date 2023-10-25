package Greedy.hard;

import java.util.List;

public class ApplyArrayMaximumSquare {

    //    Observe the effect of an operation on one bit:
//            (1, 1) -> (1 & 1, 1 | 1) -> (1, 1)
//            (0, 0) -> (0 & 0, 0 | 0) -> (0, 0)
//            (0, 1) -> (0 & 1, 0 | 1) -> (0, 1)
//            (1, 0) -> (1 & 0, 1 | 0) -> (0, 1)
//
//    The first three cases won't change anything,
//    the last case will move the bit from A[i] to A[j].
//
//    So apply operation as many as possible,
//    it will sort the array on each bit,
//    from random array [1,0,1,0,1,0,0],
//    to a sorted array [0,0,0,0,1,1,1].
//
//    Explanation
//    Count the number of 1 on each 32 bits,
//    and we will use these bits to construct the array again,
//    by use them in as late as possible in the array.
//    Then we can know the finally sorted array.
//
//    The core of this process is counting sort on each bit.
//The best approach was to consider a count array where we store the count of number of times ith
// bit is set in whole array of data , this would help us to then generate our sum by just looping k
// times (for our k numbers ) inside this loop we will go through our count array and add the value of
// those bits which are set in array whilst decreasing its count . after one single count array loop
// we will get our 1st number from kth and add it's square to result
    class Solution {
        public int maxSum(List<Integer> A, int k) {
            int count[] = new int[32];
            long res = 0, cur = 0, mod = 1000000007;
            for (int a : A) {
                for (int i = 0; i < 32; i++) {
                    //now if we have 1 at ith place this means , doing OR with other num which doesn't
                    // have 1 at ith place will increase our value
                    //Main thing from test cases we can see that OR increases value and "AND" decreases values
                    if ((a & (1 << i)) != 0)// here we are increasing the count of those i where a bit is set to 1
                        count[i]++;
                }
            }
            // now we use the count of those set bits and add it to our answer
            for (int j = 0; j < k; j++) {
                //curr here is the number we will get after adding those numbers who have their  bit  set at ith place
                cur = 0;
                // we will go through our count bit array to get each k times
                //doing this we will get our number with its bits set after operations among the original array
                for (int i = 0; i < 32; i++) {
                    if (count[i] > 0) {
                        count[i]--;// will decrease count as we take those set bits to get our values
                        cur += 1 << i;//we will add those numbers who have set bits at ith place to our curr in loop
                    }
                }
                res = (res + cur * cur % mod) % mod;// in the end our cur will be an answer we get after many operations
                // and we will add %mod of it after it's square
            }
            return (int)res;
        }
    }

}
