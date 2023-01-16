package Greedy.medium;

import java.util.Stack;

public class RemoveKdigits {
    class Solution {
        //Traverse through each digit in num,
//if you found, previous digit is greater than the current digit, delete it.
//Suppose given num = 14329 and k = 2
// Do the following steps to get least number:-
// 1. Traverse through each digit in num
// 2. Now, pop stack
// 	while k > 0 top of the stack is greater than current digit.
// 	this is beacuse if stack has 1 4
// 	then, current digit is 3, then 4 > 3 so, pop 4.
// 	because, the number starting with 13 is smaller than 14.
// 	That's why we need to pop stack while top is
// 	greater than current digit.
// 3. After traversing through all the digits,
//     then stack looks like this = 1 2 9
//     if k > 0
// 	pop k times
// 	because we need to delete k digits from the number.
// 4. Now, create a string variable,
//     then insert every digit in stack at the beginning.
// 	This is because,
// 	while popping stack 9 will first come out, then 2, and then 1.
// 	So, add digits in reverse.
// 	Here, I am adding digits at starting position.
// 	So,
// 	when 9 is popped, str = 9
// 	when 2 is popped str = 29
// 	when 1 is popped str = 129.
// 	that's how we will get number in reverse order.
// 5. Now, Del any leading zeros are in string.
// 6. return smallest string.
        public String removeKdigits(String num, int k) {
            int n = num.length();
            if(k==n) return "0";
            if(k==0) return num;
            Stack<Character> stack = new Stack<>();
            int i=0;
            while(i<n){
                while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i++));
            }
            while(k-->0)stack.pop();
            String smallest = "";
            while(!stack.isEmpty()) smallest = stack.pop() + smallest;

            // delete leading zeros
            while(smallest.length() > 1 && smallest.charAt(0) == '0')
                smallest = smallest.substring(1);

            return smallest;
        }
    }
}
