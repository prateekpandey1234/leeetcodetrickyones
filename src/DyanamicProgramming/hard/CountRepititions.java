package DyanamicProgramming.hard;

import java.util.Arrays;

public class CountRepititions {
    //Input:
    //s1="abacb", n1=6
    //s2="bcaa", n2=1
    //
    //Return:
    //3
    // our intuition is that we have to find that if after certain  iterations of s1 does s2 repeat in s2
    // we don't need to care about str2 as we would simply divide res by n2 for that as str2 is str2=s2*n2
    // explained:
    // indexes of s2  --> 0 1    2 3 0      1    2 3 0      1    2 3 0
    //S1 --------------> abacb | abacb | abacb | abacb | abacb | abacb
    //
    //repeatCount ----->    0  |   1   |   1   |   2   |   2   |   3
    //
    //Increment of
    //repeatCount     ->    0  |   1   |   0   |   1   |   0   |   1
    //
    //nextIndex ------->    2  |   1   |   2   |   1   |   2   |   1
    //                                     ^
    //									   |
    //									 repetitive pattern found here (we've met 2 before)!
    //									 The pattern repeated 3 times
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int nn1 = s1.length();
            int nn2 = s2.length();
            //1.iterate through S1 again and again, track the pointer position of S2 at the end of each S1 iteration
            //  continue until the S2 pointer comes back to previous position, which means we've found a cycle
            //2.break up into 3 parts: pre-cycle, in-cycle, post-cycle
            //   2.1.calculate loop count for the in-cycle part
            //   2.2.snitch pre-cycle and post-cycle together, and calculate the loop count for this combined parts
            int[][] records = new int[2][n1+1];
            Arrays.fill(records[0], -1);
            int index2 = 0, count = 0;
            int cycleStart = -1, cycleEnd = -1, cycleCount = -1;
            for (int i = 1; i <= n1; i++) {
                //finding our next index and count of match
                for (int j = 0; j < nn1; j++) {
                    if (s1.charAt(j) == s2.charAt(index2)) {
                        index2++;
                    }
                    if (index2 == nn2) {
                        index2 = 0;
                        count++;
                    }
                }
                //checking whether we found our current next index in any of the previous concatenations of string s1
                for (int k = 1; k < i; k++) {
                    // we have seen this next index repeat before , so we don't need to go further
                    if (records[0][k] == index2) {
                        // we find the cycle, record start/end/count and then quit the loop
                        cycleStart = k;// the value of concatenation where we found this next index earlier
                        cycleEnd = i;// the value of concatenation where we found next index again
                        cycleCount = count - records[1][k];//getting our cycle count
                    }
                }
                if (cycleStart != -1) {
                    break;
                }
                //storing our next index and number of s2 found within ith concatenation
                records[0][i] = index2;
                records[1][i] = count;
            }
            // there is no repetition here
            if (cycleStart == -1) {
                return count / n2;
            }

            int res = 0;
            // calculate cycle
            int cycleN = (n1 - cycleStart) / (cycleEnd - cycleStart);
            res = cycleN * cycleCount;
            // add  pre-cycle and post-cycle parts
            res += records[1][n1 - cycleN * (cycleEnd - cycleStart)];

            return res / n2;
        }
    }
}
