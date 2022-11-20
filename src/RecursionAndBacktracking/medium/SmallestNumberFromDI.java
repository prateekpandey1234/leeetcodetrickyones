package RecursionAndBacktracking.medium;

public class SmallestNumberFromDI {
    public String smallestNumber(String s) {
        //here we are asked that we need to get minimum lexo. number so what we do is that
        //we match this string pattern with our numbers like
        //D D I D D I D D
        //1 2 3 4 5 6 7 8 9
        //now we can see that whenever there is different character ... the order changes
        //from either D->I or I->D ... so we just have to print the order and whenever there is D/I , we just need to reverse
        //the order from there on
        //For example:
        //first 'I' at 3, then reverse 1,2,3, we have 3,2,1
        //second 'I' at 6, then reverse 4,5,6, we have 6,5,4
        //Reverse the last group 7,8,9, we have 9,8,7
        //
        //Final result for D D I D D I D D,
        //is 3,2,1,6,5,4,9,8,7
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            stack.append((char)('1' + i));
            if (i == s.length() || s.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}
