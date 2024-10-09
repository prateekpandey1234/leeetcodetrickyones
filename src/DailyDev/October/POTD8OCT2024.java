package DailyDev.October;

import java.sql.Array;
import java.util.*;

public class POTD8OCT2024 {
    class Solution {
        public int minSwaps(String s) {
            int cnt=0;
            int ans=0;
            for(char c:s.toCharArray()){
                if(c=='[')cnt++;
                else if(c==']' && cnt==0)ans++;
                else if(c==']' && cnt>0)cnt--;
            }

            return (ans+1)/2;
        }
        // stck.isEmpty() && curr=']'

    }
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        int[] ans= new int[n];
        List<Integer>[] graph = new List[n];
        for(int[] a:arr){
            graph[a[0]].add(a[1]);
        }
        Queue<Integer> q= new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[curr]=1;
            for(int i:graph[curr]){
                q.add(i);
            }
        }
        List<Integer> a= new ArrayList<>();
        for(int i =0;i<n;i++)if(ans[i]==0)a.add(i);
        return a;
    }
}
