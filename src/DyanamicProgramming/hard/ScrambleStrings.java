package DyanamicProgramming.hard;

import java.util.HashMap;
import java.util.Map;

public class ScrambleStrings {
    public boolean isScramblem(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        Map<String, Boolean> memo = new HashMap<>();
        return isScrambleHelper(s1, s2, memo);
    }

    private boolean isScrambleHelper(String s1, String s2, Map<String, Boolean> memo) {
        if (s1.equals(s2)) {
            return true;
        }
        //this type of storing dp is good here
        if (memo.containsKey(s1 + "#" + s2)) {
            return memo.get(s1 + "#" + s2);
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            //this if condition is comparing first part of s1 to first part of s2 and last part of s1 to last part
            // of s2 without swapping
            if (isScrambleHelper(s1.substring(0, i), s2.substring(0, i), memo) &&
                    isScrambleHelper(s1.substring(i), s2.substring(i), memo)) {
                memo.put(s1 + "#" + s2, true);
                return true;
            }
            //this if here is first swapping and again comparing their respective first parts and last parts
            if (isScrambleHelper(s1.substring(0, i), s2.substring(n-i), memo) &&
                    isScrambleHelper(s1.substring(i), s2.substring(0, n-i), memo)) {
                memo.put(s1 + "#" + s2, true);
                return true;
            }
        }

        memo.put(s1 + "#" + s2, false);
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        //now this will be 3D dp because we have to divide the substrings over, and then we will compare both of them
        //[k][i][j] -> k for substring ,
        int n = s1.length();
        boolean dp[][][] = new boolean[n + 1][n][n];
        //base cases
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);//checking whether our chars are same when selected substring
                //is of size 1
            }
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean dp1[] = dp[newLength][i];//not swapping the string s1
                        boolean dp2[] = dp[length - newLength][i + newLength];//swapping the string s1
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];//checking with s2 without swapping s2
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];//checking with s2 with swapping s2
                    }
                }
            }
        }
        return dp[n][0][0];
    }
}
