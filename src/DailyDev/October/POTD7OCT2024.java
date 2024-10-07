package DailyDev.October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class POTD7OCT2024 {
    public int minLength(String s) {
        Stack<Character> stck = new Stack<>();
        int ans=s.length();
        for(char c :s.toCharArray()){
            if(c=='A' || c=='C'){
                stck.push(c);
            }
            else if(c=='B' && !stck.isEmpty() && stck.peek()=='A'){
                ans-=2;
                stck.pop();
            }
            else if(c=='D' && !stck.isEmpty() && stck.peek()=='C'){
                ans-=2;
                stck.pop();
            }
            else stck.clear();
        }
        return ans;
    }
}
class POTD6_OCT2024 {
    // solving previous day question
    class Solution {

        public boolean areSentencesSimilar(String s1, String s2) {
            // Split the words in sentences and store it in a string array.
            String[] s1Words = s1.split(" "), s2Words = s2.split(" ");
            int start = 0, ends1 = s1Words.length - 1, ends2 =
                    s2Words.length - 1, s1WordsLength = s1Words.length, s2WordsLength =
                    s2Words.length;

            // If words in s1 are more than s2, swap them and return the answer.
            if (s1WordsLength > s2WordsLength) {
                return areSentencesSimilar(s2, s1);
            }

            // Find the maximum words matching from the beginning.
            while (start < s1WordsLength && s1Words[start].equals(s2Words[start])) {
                ++start;
            }
            // Find the maximum words matching in the end.
            while (ends1 >= 0 && s1Words[ends1].equals(s2Words[ends2])) {
                --ends1;
                --ends2;
            }

            // If i reaches the end of the array, then we return true.
            return ends1 < start;
        }
    }
    class Solution2 {

        public boolean areSentencesSimilar(String s1, String s2) {
            Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
            Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
            //Compare the prefixes or beginning of the strings.
            while (
                    !deque1.isEmpty() &&
                            !deque2.isEmpty() &&
                            deque1.peek().equals(deque2.peek())
            ) {
                deque1.poll();
                deque2.poll();
            }
            // Compare the suffixes or ending of the strings.
            while (
                    !deque1.isEmpty() &&
                            !deque2.isEmpty() &&
                            deque1.peekLast().equals(deque2.peekLast())
            ) {
                deque1.pollLast();
                deque2.pollLast();
            }
            return deque1.isEmpty() || deque2.isEmpty();
        }
    }
}