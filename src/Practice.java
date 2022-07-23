
import java.lang.reflect.Array;
import java.util.*;

public class Practice {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length,n=mat[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int j=m-1;j>-1;j--){
            for(int i=0;i<n;i++){
                if(mat[j][i]==1 && !ans.contains(i)){ans.add(0,i);}
            }
        }
        int[] ans2 = new int[k];
        for(int i=0;i< ans2.length;i++){
            ans2[i]=ans.get(i);
        }
        return ans2;
    }
}
