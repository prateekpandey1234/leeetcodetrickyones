import java.io.IOException;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class lmao {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());
        int cnt=0;
        while(n-->0){
            int x = Integer.parseInt(st.nextToken());
            if(x%k==0)cnt++;
        }
        System.out.println(cnt);
    }
}
