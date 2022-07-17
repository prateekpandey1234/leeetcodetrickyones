import java.lang.reflect.Array;
import java.util.*;
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Practice {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans1 = new ArrayList<>();
        for(int i =0;i<intervals.length-1;i++){
            if((intervals[i][0]>intervals[i+1][0] && intervals[i][1]>intervals[i][1]) || (intervals[i][0]<intervals[i+1][0] && intervals[i][1]<intervals[i][1])){
                int x=0;
            }
            else{
                ans1.add(LapIntervals(intervals[i],intervals[i+1]));
            }
        }
        System.out.print(ans1);
        int[][] ans = new int[ans1.size()][2];
        for(int i =0;i<ans1.size();i++){
            ans[i]=ans1.get(i);
        }
        return ans;
    }
    public int[] LapIntervals(int[] ar1,int[] ar2){
        int [] newarr = new int[2];
        System.out.print(Arrays.toString(ar1));
        if(ar1[0]>=ar2[0]){newarr[0]=ar2[0];}
        else{newarr[0]=ar1[0];}
        if(ar1[1]>=ar2[1]){newarr[1]=ar1[1];}
        else{newarr[1]=ar2[1];}
        return newarr;
    }
}
