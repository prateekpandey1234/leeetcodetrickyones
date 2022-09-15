

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;


public class Practice {
    public int cherryPickup(int[][] a) {
        return helper(a,0,0,a.length-1,0);
    }
    public int helper(int[][] a,int i,int j1,int j2,int maxi){
        if(j1<0 || j2<0 || j1>a.length-1 || j2>a.length-1) return Integer.MIN_VALUE;
        if(i==a.length-1){
            if(j1==j2) return a[i][j1];
            return a[i][j1]+a[i][j2];
        }
        for(int dj1 = -1;dj1<2;dj1++){
            for(int dj2=-1;dj2<2;dj2++){
                if(j1==j2){
                    maxi = Math.max(maxi,helper(a,i,j1+dj1,j2+dj2,maxi)+a[i][j1]);
                }
                else{
                    maxi = Math.max(maxi,helper(a,i,j1+dj1,j2+dj2,maxi)+a[i][j1]+a[i][j2]);
                }
            }
        }
        return maxi;
    }


}
