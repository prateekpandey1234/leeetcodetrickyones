package Graph.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        String res = "";
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[K];
        for(int i = 0; i < K; i++)
            adj.add(new ArrayList<>());
        //here we are creating our adjancey list ... using the basic dictionary way of ascending order
        for(int i = 0; i < N - 1; i++){
            String s1 = dict[i],s2 = dict[i+1];
            int j = 0,k = 0;
            while(j < s1.length() && k < s2.length()){
                if(s1.charAt(j) == s2.charAt(k)){
                    j++;
                    k++;
                }

                else{
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(k)-'a');
                    indegree[s2.charAt(k)-'a']++;
                    break;
                }
            }
        }
        //in graph question ... if there is need of a order specifically ... then use topo sort...
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++)
            if(indegree[i] == 0)
                q.offer(i);
        while(!q.isEmpty()){
            int temp = q.poll();
            res += (char)(temp + 'a');
            for(int v : adj.get(temp))
                if(--indegree[v] == 0)
                    q.offer(v);
        }
        return res;
    }
}
