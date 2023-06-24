package Greedy.medium;

import java.util.HashMap;
import java.util.Map;

public class Maximizetheconfusionofanexam {
    class Solution {
        //We can also find the longest valid window with fewer traversals. Unlike the previous fixed-length sliding window solution, this time we can adjust the window length based on the situation. We will still use the counter count to record the count of each type of answer within the window.

        // Specifically, if the current window is valid, we can try to expand the window by moving the right boundary one position to the right, right = right + 1. On the other hand, if the current window is invalid, we keep moving the left boundary to the right (equivalent to removing the leftmost answer from the window) until the window becomes valid, that is left = left + 1. During this process, we constantly record the longest valid window seen so far.
        public int maxConsecutiveAnswers(String answerKey, int k) {
            int maxSize = k;
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < k; i++) {
                count.put(answerKey.charAt(i), count.getOrDefault(answerKey.charAt(i), 0) + 1);
            }

            int left = 0;
            for (int right = k; right < answerKey.length(); right++) {
                count.put(answerKey.charAt(right), count.getOrDefault(answerKey.charAt(right), 0) + 1);

                while (Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0)) > k) {
                    count.put(answerKey.charAt(left), count.get(answerKey.charAt(left)) - 1);
                    left++;
                }

                maxSize = Math.max(maxSize, right - left + 1);
            }

            return maxSize;
        }
    }
}
