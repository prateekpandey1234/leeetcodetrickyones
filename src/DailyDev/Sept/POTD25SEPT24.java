package DailyDev.Sept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POTD25SEPT24 {
    class TrieNode {

        TrieNode[] next = new TrieNode[26];
        int cnt = 0;
    }

    //tried this implementation but did overcomplicate my solution , not so har done it is
    // just had to insert all the prefixes and form a tree but also storing count of them
    // then counting on once whole tree is formed
    class Solution {

        // Initialize the root node of the trie.
        TrieNode root = new TrieNode();

        // Insert function for the word.
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                // If new prefix, create a new trie node.
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                // Increment the count of the current prefix.
                node.next[c - 'a'].cnt++;
                node = node.next[c - 'a'];
            }
        }

        // Calculate the prefix count using this function.
        int count(String s) {
            TrieNode node = root;
            int ans = 0;
            // The ans would store the total sum of counts.
            for (char c : s.toCharArray()) {
                ans += node.next[c - 'a'].cnt;
                node = node.next[c - 'a'];
            }
            return ans;
        }

        public int[] sumPrefixScores(String[] words) {
            int N = words.length;
            // Insert words in trie.
            for (int i = 0; i < N; i++) {
                insert(words[i]);
            }
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                // Get the count of all prefixes of given string.
                scores[i] = count(words[i]);
            }
            return scores;
        }
    }
}

class Solution2 {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        dfs(board,trie,0,0,new StringBuilder());
        List<String> arr = new ArrayList();
        for(String s:words){
            if(trie.search(s)){
                arr.add(s);
            }
        }
        return arr;
    }


    public void dfs(char[][] graph,Trie trie , int i , int j ,StringBuilder str ){
        if(i<0 || j<0 || i>=graph.length || j>=graph[0].length){
            trie.insert(str.toString());
            return ;
        }

        for(int [] d:dir){
            int x = d[1]+j;
            int y = d[0]+i;
            StringBuilder s = new StringBuilder(str);
            if(x>-1 && y>-1 && y<graph.length && x<graph[0].length){
                s.append(graph[y][x]);
                dfs(graph,trie,y,x,s);
            }
         }

    }

    public int minScoreTriangulation(int[] nums) {
        int[][] arr = new int[nums.length][2];
        for(int i=0;i<nums.length;i++)arr[i]  = new int[]{nums[i],2};
//        Arrays.sort(nums,(a, b) -> a[0] - b[0]);
        int k = arr[0][1];
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(Math.abs(arr[0][1]-arr[i][1])>1){
                j=arr[i][1];
                break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(i!=k && i!=j){
                sum+= (nums[k]*nums[j]*nums[i]);
            }
        }
        return sum;
    }

}


class Trie{
    Trie[] arr= new Trie[26];

    public Trie(){
    }

    public void insert(String s){
        Trie[] curr = this.arr;
        for(int i=0;i<s.length();i++){
            if(curr[s.charAt(i)-'a']==null){
                curr[s.charAt(i)-'a'] = new Trie();
            }
            curr = curr[s.charAt(i)-'a'].arr;
        }
    }

    public boolean search(String s){
        Trie[] curr = this.arr;
        for(int i=0;i<s.length();i++){
            if(curr[s.charAt(i)-'a']==null)return false;
        }
        return true;
    }


}
