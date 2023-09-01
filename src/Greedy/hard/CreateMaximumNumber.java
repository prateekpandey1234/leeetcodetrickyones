package Greedy.hard;

import java.util.Stack;

public class CreateMaximumNumber {
    // prob is we dn t know how many elements we will take from nums1 and nums2
// so we will try for all combinations of k and find the max out of them

    class Solution {

        // monotonic decreasing stack same as leetcode 1673 , only > changed to <
        public int[] findLexMax(int[] nums, int k) {
            int n = nums.length;
            Stack<Integer> st = new Stack<>();
            int[] res = new int[k];

        /* we have to form a k digit number which is lexicographically greatest
         that gives some hint that we need to maintain a monotonic decreasing stack
         and rem=n-k means we will remove n-k smaller digits from stack
         lets say nums=[6,7,4,8,9] and k=3, we have to remove 5-3=2 digits from the stack,
         while we try to form monotonic decreasing satck
         o our max number will be [8,9]
         */
            int rem = n - k;
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && st.peek() < nums[i] && rem > 0) {
                    st.pop();
                    rem--;
                }
                st.push(nums[i]);

            }

        /* if still some elements can be removed, the best option would be to remove the
        elements from the top of the stack, as we are mainting a monotonic decreasing satck
        so elemets at the top would be smaller
        take this example arr-[6,4,2] k=2 ans would be [6,4]
        */
            while (rem > 0) {
                st.pop();
                rem--;
            }
            for (int i = k - 1; i >= 0; i--) {
                res[i] = st.pop();
            }
            return res;
        }


        private static boolean findMax(int[] arr1, int[] arr2, int p1,int p2) {
            while (p1 < arr1.length && p2 < arr2.length) {
                if (arr1[p1] < arr2[p2]) {
                    return false;
                } else if (arr1[p1] > arr2[p2]) {
                    return true;
                } else {
                    p1++;
                    p2++;
                }
            }
            // when p1 is empty returns true, so that in merge function it picks up values of arr2
            // when p1==arr1.length, then returns false,so that we keep pn picking arr2 elements
            return p1!=arr1.length; // tricky
        }


        // think of the case [6,0,4] and [6,7], can t do simple logic like merge two sorted arrays
        // we need to decide which pointer to move forward based on the rest of the array,
        // if both elements are same compare the next element, and then decide
        private int[] merge(int[] nums1, int[] nums2, int k) {
            int[] res = new int[k];
            int resIndex = 0;
            int p1 = 0;
            int p2 = 0;

            while (resIndex<res.length) {
                res[resIndex++]=findMax(nums1,nums2,p1,p2)?nums1[p1++]:nums2[p2++];// tricky
            }

            return res;
        }

        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[] maxRes = new int[k];
            for (int i = 0; i <= k; i++) {
                int j = k - i;
                if (i <= len1 && (k - i) <= len2) { // skip invalid cases, imp step!
                    int[] maxLex1 = findLexMax(nums1, i);
                    int[] maxLex2 = findLexMax(nums2, j);
                    int[] res = merge(maxLex1, maxLex2, k);
                    boolean compareRes = findMax(res, maxRes,0,0);
                    if (compareRes) {
                        maxRes = res;
                    }
                }
            }
            return maxRes;
        }

    }
}
