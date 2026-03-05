




import BinaryTree.Medium.TreeNode;
import LinkedList.easy.ListNode;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */

class Solution1 {
    int[] par;
    int[] depth;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        par = new int[n];
        depth = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
            depth[i]=1;
        }
        List<int[]> arr = new ArrayList<>();
        HashMap<String,Integer> map  = new HashMap<>();
        int j=0;
        for(int [] a:points){
            map.put(a[0]+"$"+a[1],j++);
            for(int [] b:points){
                if(a[0]==b[0] && a[1]==b[1]){
                    continue;
                }
                else{
                    arr.add(new int[]{a[0],a[1],b[0],b[1],Math.abs(a[0]-a[1])+Math.abs(b[1]-b[0])});
                }
            }
        }
        Collections.sort(arr,(a,b)->Integer.compare(a[4],b[4]));
        int cst=0;
        int[] vis = new int[n];
        for(int i=0;i<arr.size();i++){
            int wt = arr.get(i)[4];
            String a = arr.get(i)[0]+"$"+arr.get(i)[1];
            String  b = arr.get(i)[2]+"$"+arr.get(i)[3];
            int par1 = find(map.get(a)),par2 = find(map.get(b));
            if(par1!=par2){
                cst+=wt;
                union(par1,par2);
            }
        }
        return cst;

    }
    public int find(int x){
        if(par[x]!=x)return par[x] = find(par[x]);
        return par[x];
    }
    public void union(int a , int b){
        int x = find(a);
        int y = find(b);
        if(depth[a]>depth[b]){
            int t = a;
            a =b;
            b=t;
        }
        par[a]=b;
        if(depth[a]==depth[b])depth[b]++;
    }
}








