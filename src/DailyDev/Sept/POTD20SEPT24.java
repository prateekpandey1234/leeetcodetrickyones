package DailyDev.Sept;

import java.util.Arrays;

public class POTD20SEPT24 {
    //first way is using of KMP algo , i thought and partially implemented it but this is full one
    class Solution {
        private int[] prefixFunction(String s) {
            int n = s.length();
            int[] pi = new int[n];
            for (int i = 1; i < n; i++) {
                int j = pi[i - 1];
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = pi[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                pi[i] = j;
            }
            return pi;
        }
        //so what we do here is that we are trying to match the largest prefix of string from words to
        // that of suffix of target , this is much better than trying to match prefix by prefix
        // It can be proven by a contradiction. As a quick example, say we matched two prefixes ["abc]["def"].
        //
        //If there is a longer second prefix, e.g. ["ab]["cdef"], picking it will never make the result worse.
        //However, if we use a shorter second prefix, e.g. ["abc]?["ef"], the result could become worse.
        public int minValidStrings(String[] words, String target) {
            int[][] pis = new int[words.length][];
            // generating KMP array for every words string
            for (int i = 0; i < words.length; i++) {
                pis[i] = prefixFunction(words[i] + "#" + target);
            }
            int len = target.length(), res = 0;
            while (len > 0) {
                int match = 0;
                // len is remaining length to match
                for (int i = 0; i < words.length; ++i) {
                    // the pis[i][words[i].length()+len] is the value of matching prefix we get
                    // from generating prefixes matches 
                    match = Math.max(match, pis[i][words[i].length() + len]);
                }
                if (match == 0) {
                    return -1;
                }
                ++res;
                len -= match;
            }
            return res;
        }

        // second solution
        // Trei +DP
        class TrieNode {
            TrieNode[] childs;
            TrieNode() {
                this.childs = new TrieNode[26];
            }
        }

        class Trie {
            TrieNode root;
            Trie() {
                this.root = new TrieNode();
            }
            public void insert(String word) {
                TrieNode temp = root;
                // inserting level wise
                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (temp.childs[idx] == null) {
                        temp.childs[idx] = new TrieNode();
                    }
                    temp = temp.childs[idx];
                }
            }
        }

        class Solution1 {
            int n;
            String target;
            int[] dp;

            private int solve(int i, TrieNode root) {
                // end point
                if (i == n) return 0;
                if (dp[i] != -1) return dp[i];

                TrieNode temp = root;
                int res = Integer.MAX_VALUE;
                // we will try to match the remaining string length from i->i+1,i+2,..n.

                for (int j = i; j < n; j++) {
                    int idx = target.charAt(j) - 'a';
                    if (temp.childs[idx] == null) break;
                    // traversing to deeper level for next string in words
                    temp = temp.childs[idx];
                    //this means we always point on the top of trie when finding for the next
                    // subarray prefix ... this will return back number of matches to get
                    // string matched from j+1 in trie
                    int t = solve(j + 1, root);
                    // take minimum of whole traverse
                    if (t != Integer.MAX_VALUE) {
                        res = Math.min(res, t + 1);
                    }
                }
                return dp[i] = res;
            }

            public int minValidStrings(String[] words, String target) {
                Trie trie = new Trie();
                // making the whole trie structure for words
                // helps to get possible string prefixes we want
                for (String word : words) {
                    trie.insert(word);
                }
                this.n = target.length();
                this.target = target;
                this.dp = new int[n];
                Arrays.fill(dp, -1);

                int res = solve(0, trie.root);
                return res == Integer.MAX_VALUE ? -1 : res;
            }
        }
    }
}
