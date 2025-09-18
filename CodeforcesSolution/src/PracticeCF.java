



import java.io.IOException;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PracticeCF {
//     public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//
//
//        while (t-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int y =  Integer.parseInt(st.nextToken()) ,x=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
//            if(y>=x){
//                System.out.println(y);
//            }
//            else{
//                if(x-y<=k){
//                    System.out.println(x);;
//                }
//                else{
//                    System.out.println(Math.min(2*x-y-k,2*x-y));
//                }
//            }
//
//
//        }
//
//
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//
//
//        while (t-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int n  =  Integer.parseInt(st.nextToken())*2;
//            st = new StringTokenizer(br.readLine());
//            int[] arr = new int[n];
//            for(int i=0;i<n;i++){
//                arr[i]=Integer.parseInt(st.nextToken());
//            }
//            Arrays.sort(arr);
//            List<int[]> ans = new ArrayList<>();
//            int sum = 0;
//            int[] a = new int[]{arr[0],arr[n-1]};
//            ans.add(a);
//            for(int i=1;i<n/2;i++){
//                int[] x = new int[]{arr[i],arr[n-i-1]};
//                int[] y = ans.get(ans.size()-1);
//                sum+=Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
//                ans.add(x);
//            }
//            System.out.println(sum);;
//            for(int[] r:ans){
//                System.out.println(r[0]+" "+r[1]);
//            }
//
//
//        }
//
//
//    }

    class Solution {
        Set<String> set = new HashSet<>();
        long ans=0;

        public long fact(int x){
            long res=x*1L;
            for(int i=2;i<x;i++)res*=i;
            return res;
        }

        public long arraytoLong(int[] a){
            long res=0;
            for(int i=a.length-1;i>-1;i--){
                res+=10*res+a[i];
            }
            return res;
        }

        public long ValidPerum(HashMap<Integer,Integer> map, int total){
            long totalWays = fact(total);
            for(Map.Entry<Integer,Integer> e:map.entrySet()) totalWays/=fact(e.getValue());
            return totalWays;
        }

        public long LeadingZeroePerum(HashMap<Integer,Integer> map, int total){
            if(!map.containsKey(0) || map.get(0)==0)return 0;
            long totalWays = fact(total-1);
            map.put(0,map.get(0)-1);
            for(Map.Entry<Integer,Integer> e:map.entrySet()) totalWays/=fact(e.getValue());
            return totalWays;
        }

        public void genPalindome(int[] arr, int left , int right , int total , int divisor){
            if(left>right){
                long curr = arraytoLong(arr);
                if(curr%divisor==0){
                    HashMap<Integer,Integer> map = new HashMap<>();
                    for(int i:arr)map.put(i,map.getOrDefault(i,0)+1);
                    String key   = map.toString();
                    key.eq
                    if(!set.contains(key)){
                        ans+=ValidPerum(map,total)-LeadingZeroePerum(map,total);
                        set.add(key);
                    }
                }
            }

            for(int i = ((left==0)?1:0) ; i<=9 ; i++){
                arr[left]=arr[right]=i;
                genPalindome(arr,left+1,right-1,total,divisor);
            }
        }
        public long countGoodIntegers(int n, int k) {
            ans=0;
            set.clear();
            int[] arr = new int[n];
            genPalindome(arr,0,n-1,n,k);
            return ans;
        }
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int[][] dp = new int[arr.size()+1][arr.get(arr.size()-1).size()];
        for(int i=0;i<arr.get(arr.size()-1).size();i++){
            dp[arr.size()][i]=arr.get(arr.size()-1).get(i);
        }
        for(int i=arr.size()-1;i>-1;i--){
            for(int j=0;j<arr.get(i).size();j++){
                dp[i][j]=arr.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
    }
}
class Solution {
    Set<String> set ;
    List<String>[][] memo;
    List<String> ans  = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new ArrayList[s.length()][s.length()];
        return f(s,0,0);
    }
    public List<String> f(String s, int i , int j){
        List<String> curr = new ArrayList<>();
        if(j>=s.length()){
            if(j==s.length() && set.contains(s.substring(i,j))){
                curr.add(s.substring(i,j));
                return new ArrayList<>(curr);
            }
            return new ArrayList<>();
        }
        if(memo[i][j]!=null)return memo[i][j];
        String c = s.substring(i,j);
        if(set.contains(c)){
            List<String> tk = f(s,j+1,j+1);
            List<String> ntk = f(s,i,j+1);
            for(String k:tk)curr.add(c+" "+k);
            for(String k:ntk)curr.add(c+" "+k);
        }
        else{
            List<String> ntk = f(s,i,j+1);
            for(String k:ntk)curr.add(c+" "+k);
        }
        return memo[i][j]=new ArrayList<>(curr);
    }
}



















