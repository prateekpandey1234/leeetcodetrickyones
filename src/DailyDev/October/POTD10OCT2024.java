package DailyDev.October;

import java.util.Arrays;
import java.util.Stack;

public class POTD10OCT2024 {
    class Solution {

        public int maxWidthRamp(int[] nums) {
            int n = nums.length;
            Stack<Integer> indicesStack = new Stack<>();

            // Fill the stack with indices in increasing order of their values
            for (int i = 0; i < n; i++) {
                if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                    indicesStack.push(i);
                }
            }

            int maxWidth = 0;

            // Traverse the array from the end to the start
            for (int j = n - 1; j >= 0; j--) {
                while (
                        !indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]
                ) {
                    maxWidth = Math.max(maxWidth, j - indicesStack.peek());
                    // Pop the index since it's already processed
                    indicesStack.pop();
                }
            }

            return maxWidth;
        }
    }
    class Solution1 {

        public int maxWidthRamp(int[] nums) {
            int n = nums.length;
            Integer[] indices = new Integer[n];

            // Initialize the array with indices
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            // Sort indices based on corresponding values in nums and ensure stability
            Arrays.sort(indices, (i, j) ->
                    nums[i] != nums[j] ? nums[i] - nums[j] : i - j
            );

            int minIndex = n; // Minimum index encountered so far
            int maxWidth = 0;

            // Calculate maximum width ramp
            for (int i : indices) {
                maxWidth = Math.max(maxWidth, i - minIndex);
                minIndex = Math.min(minIndex, i);
            }

            return maxWidth;
        }
    }
    class Solution2 {

        public int maxWidthRamp(int[] nums) {
            int n = nums.length;
            int[] rightMax = new int[n];

            // Fill rightMax array with the maximum values from the right
            rightMax[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
            }

            int left = 0, right = 0;
            int maxWidth = 0;

            // Traverse the array using left and right pointers
            while (right < n) {
                // Move left pointer forward if current left exceeds rightMax
                while (left < right && nums[left] > rightMax[right]) {
                    left++;
                }
                maxWidth = Math.max(maxWidth, right - left);
                right++;
            }

            return maxWidth;
        }
    }
}
