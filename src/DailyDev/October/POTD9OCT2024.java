package DailyDev.October;

import java.util.*;

public class POTD9OCT2024 {
    class Solution {
        public int minAddToMakeValid(String s) {
            int ans=0;
            int ex=0;
            for(char c:s.toCharArray()){
                if(ans==0 && c==')')ex++;
                else if(c=='(')ans++;
                else  ans--;
            }
            return Math.abs(ans)+ex;
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        int[] ans= new int[n];
        List<Integer>[] graph = new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int[] a:arr){
            graph[a[0]].add(a[1]);
            set.add(a[1]);
        }
        Queue<Integer> q= new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[curr]=1;
            for(int i:graph[curr]){
                if(ans[i]!=1){q.add(i);}
            }
        }

        for(int i=0;i<n;i++){
            if(ans[i]==1 && set.contains(i))ans[i]=0;
        }


        List<Integer> a= new ArrayList<>();
        for(int i =0;i<n;i++){
            if(ans[i]==0)a.add(i);
        }
        return a;
    }
}
