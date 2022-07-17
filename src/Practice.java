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
    public int peakIndexInMountainArray(int[] arr) {
        int i=0,j=arr.length-1;
        return DivAndSolve(arr,i,j,0);
    }
    public int DivAndSolve(int[] arr,int i,int j,int max){
        int mid=(i+j)/2;
        if(j-i<=2){return Math.max(Math.max(arr[i],arr[j]),arr[mid]);}
        max=Math.max(DivAndSolve(arr,i,mid-1,max),DivAndSolve(arr,mid+1,j,max));
        return Math.max(arr[mid],max);
    }
}
