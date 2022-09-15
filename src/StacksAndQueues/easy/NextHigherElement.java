package StacksAndQueues.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextHigherElement {
    //We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than
    // stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
    //For example [9, 8, 7, 3, 2, 1, 6]
    //The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3
    // whose next greater element should be 6
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
    //method 2 ;; O(n2)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] htr = higherToRight(nums2);

        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            if(htr[nums1[i]]==-1){
                res[i]=-1;
            }else{
                res[i]=nums2[htr[nums1[i]]];
            }
        }

        return res;
    }

    public int[] higherToRight(int[] a) {
        int n = a.length;
        int[] res = new int[10001];
        int[] stack = new int[n];
        int top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && a[i] >= a[stack[top]]) {
                top--;
            }
            if (top < 0) {
                res[a[i]] = -1;
            } else {
                res[a[i]] = stack[top];
            }
            stack[++top] = i;
        }
        return res;
    }
}
