package Misc;

import java.util.Stack;

public class BasicCalculator {
    //     Algorithm:

// Start from +1 sign and scan s from left to right;
// if c == digit: This number = Last digit * 10 + This digit;
// if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
// if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
// if c == '(': Push this context sign to stack;
// if c == ')': Pop this context and we come back to last context;
// Add the last num. This is because we only add number after '+' / '-'.
// Implementation:

    public int calculate(String s) {
        if(s == null) return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //basic operation for prevnum
            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            }//will use sign from prev character to solve here
            else if(c == '+' || c == '-') {
                result += sign * num;
                //here we will store the sign out of bracket to solve further
                sign = stack.peek() * (c == '+' ? 1: -1);
                num = 0;

            } else if(c == '(') {
                stack.push(sign);

            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }
}
