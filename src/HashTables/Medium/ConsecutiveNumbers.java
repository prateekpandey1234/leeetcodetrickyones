package HashTables.Medium;

import java.util.HashSet;
import java.util.Set;
/**
 *  the numbers are stored in a HashSet (or Set, in Python) to allow O(1)O(1) lookups,
 *  and we only attempt to build sequences from numbers that are not already part of a longer sequence.
 *  This is accomplished by first ensuring that the number that would immediately precede the current
 *  number in a sequence is not present, as that number would necessarily be part of a longer sequence.*/
//question was solved but this approach was very good
public class ConsecutiveNumbers {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;
            //we will here just not start our streak for those numbers which have a number less than them
            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }
}
