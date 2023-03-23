package StacksAndQueues.medium;

import java.util.Stack;

public class pattern132 {
    class Solution {
        //here what will we do is that use stack such to get our highest number on right side of our curr number(nums[i])
        // such it follows 32 pattern with our current nums[i] now as we keep moving from right to left if we encounter
        // an higher pair of value 32(ex:- 6,4) than our current 32(ex:- 4,2) we will update our 32 pattern as it will
        // allow a larger range of number to follow our 1 pattern on our left side
        public boolean find132pattern(int[] nums) {
            Stack<Integer> stck = new Stack<>();
            int sec = Integer.MIN_VALUE;//assuming our 2nd value in pattern
            for(int i=nums.length-1;i>-1;i--){
                if(nums[i]<sec)return true;//found our '1' in 132
                while(!stck.isEmpty() && nums[i]>stck.peek()){
                    sec=stck.pop();//searching for our '2' in 32 if we found new peak value
                }
                stck.push(nums[i]);//keeping track of our prev numbers
            }
            return false;
        }
    }
}
