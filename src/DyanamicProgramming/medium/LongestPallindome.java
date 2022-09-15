package DyanamicProgramming.medium;
//The problem can be broken down into subproblems which are reused several times. Overlapping subproblems lead us to
// Dynamic Programming.
//
//We decompose the problem as follows:
//
//State variable
//The start index and end index of a substring can identify a state, which influences our decision.
//So the state variable is state(start, end) indicates whether s[start, end] inclusive is palindromic
//
//Goal state
//max(end - start + 1) for all state(start, end) = true
//
//State transition
//
//for start = end (e.g. 'a'), state(start, end) is True
//for start + 1 = end (e.g. 'aa'), state(start, end) is True if s[start] = s[end]
//for start + 2 = end (e.g. 'aba'),  state(start, end) is True if s[start] = s[end] and state(start + 1, end - 1)
//for start + 3 = end (e.g. 'abba'),  state(start, end) is True if s[start] = s[end] and state(start + 1, end - 1)
public class LongestPallindome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        int ml = 0;
        int mr = 0;
        for (int r = 0; r < len; r++) {
            dp[r][r] = true;
            for (int l = 0; l < r; l++) {
                // l  r
                // abca ...  //a = a, ok
                if (s.charAt(l) != s.charAt(r)) continue;
                // l  r
                // abca ...   //b != c continue
                if (l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;
                dp[l][r] = true;
                if (r - l > mr - ml) {
                    ml = l;
                    mr = r;
                }
            }
        }
        return s.substring(ml, mr + 1);
    }
}
