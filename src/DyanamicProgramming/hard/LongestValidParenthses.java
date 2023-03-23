package DyanamicProgramming.hard;

import java.util.Stack;

public class LongestValidParenthses {
    public class Solution {
        //two pases method
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, maxlength = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * right);
                } else if (right >= left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * left);
                } else if (left >= right) {
                    left = right = 0;
                }
            }
            return maxlength;
        }
    }
    //dp only
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max_len = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {//checking if both are closing whether there is a possible opening parathensis before our prev valid parenthses
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                //this part here also alows to check continious valid parenthses
                //dp[i-]
                max_len = Math.max(max_len, dp[i]);
            }
        }

        return max_len;
    }

//stack only
        public int longestValidParentheses2(String s) {
            int maxans = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
    }
}
