package Greedy.medium;

public class ReorganizeStrings {
    class Solution {
        //We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
// In this way, we can make sure there is always a gap between the same characters

// Consider this example: "aaabbbcdd", we will construct the string in this way:

        // a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
// a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
// a b a c a _ b _ b // fill in "c" at position 3
// a b a c a d b d b // fill in "d" at position 5, 7
        public String reorganizeString(String S) {
            int[] hash = new int[26];
            for (int i = 0; i < S.length(); i++) {
                hash[S.charAt(i) - 'a']++;
            }
            int max = 0, letter = 0;
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] > max) {
                    max = hash[i];
                    letter = i;
                }
            }
            if (max > (S.length() + 1) / 2) {
                return "";
            }
            char[] res = new char[S.length()];
            int idx = 0;
            //adding the max letter count at every interval of 1
            while (hash[letter] > 0) {
                res[idx] = (char) (letter + 'a');
                idx += 2;
                hash[letter]--;
            }
            //adding every rest of characters in the space left behind as we add similarly for max cnt
            for (int i = 0; i < hash.length; i++) {
                while (hash[i] > 0) {
                    //our 2nd pointer used to put values on res , reset after length is reached
                    if (idx >= res.length) {
                        idx = 1;
                    }
                    res[idx] = (char) (i + 'a');
                    idx += 2;
                    hash[i]--;
                }
            }
            return String.valueOf(res);
        }
        //class Solution {
//     public String reorganizeString(String S) {
//         // Create map of each char to its count
//         Map<Character, Integer> map = new HashMap<>();
//         for (char c : S.toCharArray()) {
//             int count = map.getOrDefault(c, 0) + 1;
//             // Impossible to form a solution
//             if (count > (S.length() + 1) / 2) return "";
//             map.put(c, count);
//         }
//         // Greedy: fetch char of max count as next char in the result.
//         // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//         for (char c : map.keySet()) {
//             pq.add(new int[] {c, map.get(c)});
//         }
//         // Build the result.
        //here we are doing as same as above but we will add the chars depending on thier count
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             int[] first = pq.poll();
//             if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
//                 sb.append((char) first[0]);
//                 if (--first[1] > 0) {
//                     pq.add(first);
//                 }
//             } else {
//                 int[] second = pq.poll();
//                 sb.append((char) second[0]);
//                 if (--second[1] > 0) {
//                     pq.add(second);
//                 }
//                 pq.add(first);
//             }
//         }
//         return sb.toString();
//     }
// }
    }
}
