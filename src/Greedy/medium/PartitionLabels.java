package Greedy.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    class Solution {
        //    possible solution where we can simply take the end of current window which will be updated as chars are repeated
        public List<Integer> partitionLabels(String s) {
            int[] lastOccurrence = new int[26];

            // Find the last occurrence index of each character
            for (int i = 0; i < s.length(); i++) {
                lastOccurrence[s.charAt(i) - 'a'] = i;
            }

            List<Integer> partitions = new ArrayList<>();
            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
                // when our index has reached the end index of our curr window which will get updated
                // depending upon the repetion of chars throughout the array
                // ex::--> abacabca
                //        i=0,end=8 --> as our 'a' last occurrence is at end=8
                if (i == end) {
                    partitions.add(end - start + 1);
                    start = end + 1;
                }
            }

            return partitions;
        }
    }
}
