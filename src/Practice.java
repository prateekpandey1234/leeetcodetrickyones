




import BinaryTree.Medium.TreeNode;
import LinkedList.easy.ListNode;
import kotlin.Pair;

import java.io.*;

import java.lang.reflect.Array;
import java.util.*;

public class Practice {

    List<Integer> l = new ArrayList<>();
    public List<Integer> circularPermutation(int n, int start) {
        Set<Integer> set = new HashSet<>();
        n=2*n-1;
        for(int i=0;i<=n;i++)set.add(i);
        List<Integer> curr=new ArrayList();
        curr.add(start);
        set.remove(start);
        for(int i=0;i<=n;i++)
        {
            if(i!=start && check(i,start)){
                set.remove(i);
                curr.add(i);
                dfs(curr,n,set);
                set.add(i);
                curr.remove(curr.size()-1);
            }
        }
        return l;
    }
    public void dfs(List<Integer> curr,int n , Set<Integer> s ){
        if(s.size()==0){
            l.addAll(curr);
            return ;
        }
        for(int i=0;i<n;i++){
            if(s.contains(i) && check(curr.get(curr.size()-2),i) ){
                s.remove(i);
                curr.add(curr.size()-2,i);
                dfs(curr,n,s);
                s.add(i);
                curr.remove(curr.size()-2);
            }
        }
        

    }
    public boolean check(int a , int b){
        int d = Math.abs(a-b);
        double val = (Math.log(d))/(Math.log(2));
        return (int)val - val==0;
    }
    public long minNumberOfSeconds(int m, int[] wt) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Math.toIntExact(a[0] - b[0]));
        for(int i:wt){
            pq.add(new long[]{(long)i,(long)i,(long)1});
        }
        while(m>1){
            long[] c=pq.poll();
            pq.add(new long[]{c[0]+c[1]*(c[2]+1),c[1],c[2]+1});
            m--;
        }
        return (long)(pq.peek()[0]);
    }
    // 2112112332
//    class Pair implements Comparable<Pair>{
//        char c;
//        int i;
//        public Pair(char c, int i){
//            this.c=c;
//            this.i=i;
//        }
//
//        @Override
//        public int compareTo(Pair o) {
//            return Integer.compare(o.i,this.i);
//        }
//    }
    public static void main(String[] args) throws IOException{

        System.out.println("123".substring(1,2));
     }

//    public int maxGoodNumber(int[] nums) {
//
//    }
    public static int num(int a , int b , int c){
        int val=a|0;
        val=(val<<((int)(Math.log(b)/Math.log(2) +1)))|b;
        val=(val<<((int)(Math.log(c)/Math.log(2)+1)))|c;
        return val;
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        long ans=0;
        for(int i:nums)pq.add(i);
        while(k>0 && !pq.isEmpty()){
            System.out.println(pq.toString());
            int curr=pq.poll();
            ans+=(long)curr;
            pq.add((int)Math.ceil(curr/3));
            k--;
        }
        return ans;
    }
    int ans;
    public int maxUniqueSplit(String s) {
        ans=0;
        dfs(new HashSet<>(),s,new StringBuilder(),0);
        return ans;
    }
    public void dfs(HashSet<String> curr , String s,StringBuilder c, int i){
        if(i>=s.length()){
            boolean ch =true;
            int size=0;
            for(String k:curr)size+=k.length();
            if(size==s.length())ans=Math.max(ans,curr.size());
            return;
        }
        c.append(s.charAt(i));
        if(!curr.contains(c.toString())){
            curr.add(c.toString());
            dfs(curr,s,c,i+1);
        }
        StringBuilder st = new StringBuilder();
        st.append(s.charAt(i));
        if(!curr.contains(st.toString())){
            curr.add(st.toString());
            dfs(curr,s,st,i+1);
        }
    }
    public int numberOfSubstrings(String s, int k) {
        TreeMap<Character,Integer> map = new TreeMap<>();
        int l=0,mx=0,ans=0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            if(!map.containsKey(ch))map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
            Map.Entry<Character,Integer> e= map.lastEntry();
            mx=e.getValue();
            int curr=0;
            while(mx==k){
                curr+=s.length()-r;
                char st = s.charAt(l);
                if(st==e.getKey())mx--;
                l++;
            }
            ans+=curr;

        }
        return ans;
    }
    public int maxEqualRowsAfterFlips(int[][] arr) {
        int ans=1;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num=0,num1=0;
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    num|=(1<<(j+1));
                }
                if(arr[i][j]==0){
                    num1|=(1<<(j+1));
                }
            }
            map.put(num,map.getOrDefault(num,0)+1);
            map.put(num1,map.getOrDefault(num1,0)+1);
        }

        return Collections.max(map.values());

    }


}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int calculate(String s) {
        int res=0,currres=0,curr=0,prev=0,op=1;
        Stack<Pair> stck = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' ')continue;
            if(Character.isDigit(ch)){
                curr=curr*10+(int)(ch-'0');
            }
            else if(ch=='('){

                Pair p = new Pair(op,currres+op*prev);
                stck.push(p);
                currres=0;
                curr=0;
                prev=0;
                op=1;
            }
            else if(ch==')'){
                currres+=prev+op*curr;

                Pair p = stck.pop();
                currres=p.res+p.p*(currres);
                prev=0;
                curr=0;
            }
            else{
                currres+=prev;
                prev=(op==1)?curr:-curr;
                // update op after doing previous operation
                op=(ch=='+')?1:-1;
                curr=0;
        }

        }
        return currres;
    }
    class Solution {
//        public int minOperations(int[] nums) {
//            Queue<Integer> q = new LinkedList<>();
//            int ans=0;
//            for(int i=0;i<nums.length;i++){
//                while(!q.isEmpty() && i>q.peek()+2){
//                    q.poll();
//                }
//
//                if((nums[i]+q.size())%2==0){
//                    if(i+2>=nums.length){
//                        return -1;
//                    }
//                    q.add(i);
//                    ans++;
//                }
//            }
//            return ans;
//        }
        public int minOperations(int[] nums) {
            int ans=0;
            for(int i = 0;i<nums.length;i++){
                while(i<nums.length  && nums[i]==1)i++;
                if(i>=nums.length)break;
                if(i+2>=nums.length)return -1;
                for(int k=i+0;k<=i+2 && k<nums.length;k++){
                    nums[k]=(nums[k]==1)?0:1;
                }
                ans++;

            }
            return ans;
        }
    }

    class Pair{
        int p;
        int res;
        public Pair(int p, int res){
            this.p=p;
            this.res=res;
        }
    }
}




