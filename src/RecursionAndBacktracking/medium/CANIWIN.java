package RecursionAndBacktracking.medium;

import java.util.HashMap;
import java.util.Map;

public class CANIWIN {
    class Solution {
        //For this question, the key part is: what is the state of the game? Intuitively, to uniquely determine the
        // result of any state, we need to know:

// 1)The unchosen numbers
// 2)The remaining desiredTotal to reach
// A second thought reveals that 1) and 2) are actually related because we can always get the 2) by deducting the sum
// of chosen numbers from original desiredTotal.

// Then the problem becomes how to describe the state using 1).

// In my solution, I use a boolean array to denote which numbers have been chosen, and then a question comes to mind,
// if we want to use a Hashmap to remember the outcome of sub-problems, can we just use Map<boolean[], Boolean> ?
// Obviously we cannot, because the if we use boolean[] as a key, the reference to boolean[] won't reveal the actual
// content in boolean[].

// Since in the problem statement, it says maxChoosableInteger will not be larger than 20, which means the length of
// our boolean[] array will be less than 20. Then we can use an Integer to represent this boolean[] array. How?

// Say the boolean[] is {false, false, true, true, false}, then we can transfer it to an Integer with binary
// representation as 00110. Since Integer is a perfect choice to be the key of HashMap, then we now can "memorize"
// the sub-problems using Map<Integer, Boolean>.

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            // Check for edge cases
            if (desiredTotal <= 0) return true;
            if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;

            // Create a map to store the state of each game configuration
            Map<Integer, Boolean> memo = new HashMap<>();

            // Create a boolean array to track the used numbers
            boolean[] used = new boolean[maxChoosableInteger + 1];

            // Call the backtracking function
            return canWin(desiredTotal, used, memo);
        }

        private boolean canWin(int desiredTotal, boolean[] used, Map<Integer, Boolean> memo) {
            // Convert the boolean array to an integer state representation
            int state = getState(used);

            // Check if the current state has been calculated before
            if (memo.containsKey(state)) {
                return memo.get(state);
            }

            // Try all possible moves from the current state
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    // Mark the current number as used
                    used[i] = true;

                    // If the current number is greater than or equal to the desired total,
                    // or the opponent cannot win from the next state, then the current player wins
                    if (i >= desiredTotal || !canWin(desiredTotal - i, used, memo)) {
                        memo.put(state, true);
                        // Reset the current number as unused for future iterations
                        used[i] = false;
                        return true;
                    }

                    // Reset the current number as unused for future iterations
                    used[i] = false;
                }
            }

            // If no winning move is found, mark the current state as losing
            memo.put(state, false);
            return false;
        }

        private int getState(boolean[] used) {
            int state = 0;
            for (int i = 1; i < used.length; i++) {
                if (used[i]) {
                    state |= (1 << i);
                }
            }
            return state;
        }
    }


}
