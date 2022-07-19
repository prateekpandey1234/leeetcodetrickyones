package Arrays.easy;

public class LongestPallindome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            //this was to check the whether we have one extra character that could fit in ...
            //if our ans is even then it means it's perfect palindrome ...
            //but we can however add a single unique char to increase its length
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
