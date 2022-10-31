

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;


public class Practice {
    public String findOrder(String [] dict, int N, int K)
    {
        //taking a=0,b=1,c=2,d=3,e=4.....
        int[][] adj = new int[K][K];
        int[] ind = new int[K];
        for(int i=0;i<N-1;i++){
            for(int j=0;j<dict[i].length();j++){
                if(dict[i].charAt(j)!=dict[i+1].charAt(j)){
                    adj[i][j]=dict[i+1].charAt(j);
                }
            }

        }
    }
    public static void main(String[] args){
        System.out.println(-1%3);
    }
}
