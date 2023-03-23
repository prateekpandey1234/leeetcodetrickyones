package DyanamicProgramming.hard;

import java.util.HashMap;
import java.util.Map;

public class RegularExpression {
    public boolean isMatch(String s, String p) {
        //base case here will be that we have successfully matched in both the strings
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'
            //if char is '*' then we will have to check for the next char in string p with previous char in s
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            //when 
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p);
            }
            return false;
        } else {                                     // second char is not '*'
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
    }
    //memorization
    Map<String, Boolean> cache;

    public boolean isMatch2(String s, String p) {
        cache = new HashMap<>();
        return match(s, p);
    }

    private boolean match(String s, String p) {
        String key = s.length() + ":" + p.length();
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean res = false;
        if (p.length() == 0) {
            res = s.length() == 0;
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                res = match(s, p.substring(2)) || match(s.substring(1), p);
            } else {
                res = match(s, p.substring(2));
            }
        } else {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                res = match(s.substring(1), p.substring(1));
            }
        }

        cache.put(key, res);
        return res;
    }
    //tabulation
    public boolean isMatch3(String text, String pattern) {
        // One more dimensional space, because when seeking dp[len - 1][j], you need to know the situation of dp[len][j],
        // If there is one more dimension, the pair dp[len - 1][j] can also be written into the loop
        boolean[][] dp = new boolean[2][pattern. length() + 1];
        dp[text.length()%2][pattern.length()] = true;

        // start decreasing from len
        for (int i = text. length(); i >= 0; i--) {
            for (int j = pattern. length(); j >= 0; j--) {
                if(i==text. length()&&j==pattern. length()) continue;
                boolean first_match = (i < text. length() && j < pattern. length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern. length() && pattern. charAt(j + 1) == '*') {
                    dp[i%2][j] = dp[i%2][j + 2] || first_match && dp[(i + 1)%2][j];
                } else {
                    dp[i%2][j] = first_match && dp[(i + 1)%2][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
