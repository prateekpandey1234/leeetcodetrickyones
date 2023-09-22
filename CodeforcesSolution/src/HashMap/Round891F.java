package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Round891F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            HashMap<Long,Integer> map  = new HashMap<>();
            for(int i=0;i<n;i++){
                map.merge((long)Integer.parseInt(st.nextToken()),1,Integer::sum);
                //a cp way to get our sum merged easily
            }
            int q = Integer.parseInt(br.readLine());
            while(q-->0){
                st=new StringTokenizer(br.readLine());
                long x=Integer.parseInt(st.nextToken());
                long y=Long.parseLong(st.nextToken());
                long d = x*x-4*y;
                int s = (int) Math.sqrt(d);
                if((long)s*s!=d){
                    System.out.print(0+" ");
                    continue;
                }
                int c1 = map.getOrDefault((x+s)/2,0);//found using sqrt solution
                int c2 = map.getOrDefault((x-s)/2,0);
                if(d==0){//same numbers
                    System.out.print(((long) c1 *(c1-1)/2)+" ");
                }
                else System.out.print((long)c1*c2+" ");
            }
            System.out.println();
        }}
}
