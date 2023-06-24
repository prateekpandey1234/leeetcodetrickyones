package DyanamicProgramming.hard;

import java.util.HashMap;
import java.util.Map;

public class TallestBillBoard {
    public class Solution {
// The use of height difference as an indicator simplifies the problem because it allows us to represent the two
// stands as a single value. This makes it easier to handle the different combinations of rod placements and track
// the maximum height achievable for each height difference.

// If we were to use the sum of elements as an indicator instead, it would be more challenging to track the maximum
// height achievable for each specific sum. Additionally, it would require considering all possible subsets of rods
// to calculate the sum, which would significantly increase the time and complexity of the solution.

// The intuition behind the solution is to use dynamic programming to keep track of the maximum achievable height
// for a given height difference between the two stands.

// The key idea is to represent the state of the problem using a HashMap, where the keys represent the height
// difference between the two stands, and the values represent the maximum height that can be achieved for that
// height difference.

// The algorithm iterates through each rod and updates the HashMap based on two cases:

// 1,Adding the rod to the taller stand: If we add the rod to the taller stand, the height difference between the two
// stands increases by the height of the rod. We update the maximum achievable height for the new height difference.

// 2,Adding the rod to the shorter stand: If we add the rod to the shorter stand, the height difference between the
// two stands is expressed as the absolute difference between the updated shorter stand height and the taller stand
// height. We update the maximum achievable height for this new height difference.

// By considering both cases, we ensure that we explore all possible combinations of rod placements to achieve the
// maximum height for each height difference.

        // Finally, we return the maximum height achievable for a height difference of 0, which represents the case
        // where the two stands have equal height.
        public int tallestBillboard(int[] rods) {
            // dp[taller - shorter] = taller
            Map<Integer, Integer> dp = new HashMap<>();
            dp.put(0, 0);

            for (int rod : rods) {
                // Create a new map to store the updated states
                Map<Integer, Integer> newDp = new HashMap<>(dp);

                for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                    int diff = entry.getKey();
                    int taller = entry.getValue();
                    int shorter = taller - diff;

                    // Add the rod to the taller stand, increasing the height difference to diff + rod.
                    int newTaller = newDp.getOrDefault(diff + rod, 0);
                    newDp.put(diff + rod, Math.max(newTaller, taller + rod));

                    // Add the rod to the shorter stand, expressing the height difference as abs(shorter + rod - taller).
                    int newDiff = Math.abs(shorter + rod - taller);
                    int newTaller2 = Math.max(shorter + rod, taller);
                    newDp.put(newDiff, Math.max(newTaller2, newDp.getOrDefault(newDiff, 0)));
                }

                dp = newDp; // Update dp with the new states
            }

            // Return the maximum height with a height difference of 0
            return dp.getOrDefault(0, 0);
        }
    }

}
