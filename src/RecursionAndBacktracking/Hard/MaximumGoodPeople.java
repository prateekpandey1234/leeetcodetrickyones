package RecursionAndBacktracking.Hard;

public class MaximumGoodPeople {
    public int maximumGood(int[][] S) {
        int n = S.length;
        int ans = 0;

        for (int i = 0; i < (1 << n); i++) {
            if (isValid(S, i)) {
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }

        return ans;
    }

    private boolean isValid(int[][] S, int cur) {
        for (int i = 0; i < S.length; i++) {
            if ((cur & (1 << (S.length - 1 - i))) != 0) {
                for (int j = 0; j < S.length; j++) {
                    if (S[i][j] != 2 && S[i][j] != ((cur & (1 << (S.length - 1 - j))) )) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
