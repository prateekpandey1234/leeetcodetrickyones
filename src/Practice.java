



import java.io.IOException;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cntb=0,cnts=0,cntc=0;
        for(char ch:s.toCharArray()){
            if(ch=='B')cntb++;
            if(ch=='S')cnts++;
            if(ch=='C')cntc++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cst =  new int[3];
        for(int i=0;i<3;i++)cst[i]=Integer.parseInt(st.nextToken());
        boolean f = true;
        //minimum burger with cost=0;
        long ans=Math.min(cst[0]/cntb,Math.min(cst[1]/cnts,cst[2]/cntc));
        st = new StringTokenizer(br.readLine());
        int pb = Integer.parseInt(st.nextToken()),ps = Integer.parseInt(st.nextToken()) ,pc = Integer.parseInt(st.nextToken());
        long left = Long.parseLong(br.readLine());
        //left ind
        cst[0]-=ans*cntb;
        cst[1]-=ans*cnts;
        cst[2]-=ans*cntc;
        left-=(Math.max((cntb-cst[0])*pb,0)+Math.max((cnts-cst[1])*ps,0)+Math.max((cntc-cst[2])*pc,0));
        ans+=1;
        ans+=(left/((long) cntb *pb+ (long) cnts *ps+ (long) cntc *pc));
        System.out.println(ans);

    }

}




