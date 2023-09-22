

import java.io.IOException;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
            int max=1;
            int j=0;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n1;i++) {
                int c = Integer.parseInt(st.nextToken());
                if(c>=max){
                    j=Math.max(j,i);
                    max=c;
                }
            }
            int lo=0, hi = (int)(1e9);
            while(lo<hi){
                int n = lo+(hi-lo)/2;
                System.out.println(max);
                if(n*max+(int)((n)*(n+1))/2<=k && n<=j){
                     lo=n+1;
                }
                else{
                    hi=n-1;
                }
            }
            System.out.println(max+lo);
        }
    }


}
