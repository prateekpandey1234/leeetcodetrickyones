package CodeForces.Virtual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Round895Div3 {
    //prob A
//        public static void main(String[] args) throws IOException {
//            BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int t =  Integer.parseInt(st.nextToken());
//            while(t-->0){
//                st = new StringTokenizer(br.readLine());
//                int a =Integer.parseInt(st.nextToken()), b= Integer.parseInt(st.nextToken()),k = Integer.parseInt(st.nextToken());
//                int di =  Math.abs(b-a);
//                if(di==0)System.out.println(0);
//                else if(di%2==0 && (di/2)%k==0)System.out.println((di/2)/k);
//                else System.out.println((di/2)/k+1);
//            }
//        }
    //prob B
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int t = Integer.parseInt(st.nextToken());
//        while(t-->0){
//            int n = Integer.parseInt(br.readLine());
//            int min  = Integer.MAX_VALUE;
//            while(n-->0){
//                st = new StringTokenizer(br.readLine());
//                int ind = Integer.parseInt(st.nextToken()),val= Integer.parseInt(st.nextToken());
//                val = (val%2==0)?val/2-1:val/2;
//                min=Math.min(min,ind+val);
//            }
//            System.out.println((min==0)?1:min);
//        }
//    }
    //prob C
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            st= new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken()),r=Integer.parseInt(st.nextToken());
            int a=0,b=0;
            if(l==r){
                int i=1;
                while(i<=l/2 && gcd(i,l-i)==1)i++;
                if(i<=l/2){
                    i=a;b=l-i;
                }
                System.out.println((a==0)?-1:a+" "+b);
            }
            else{
                System.out.println((l%2==0)?(2+" "+(l-2)):(r%2==0)?(2+" "+(r-2)):(2+" "+((l+r)/2-2)));
            }

        }
    }
    static int gcd(int a, int b)
    {
        int i;
        if (a < b)
            i = a;
        else
            i = b;
        for (i = i; i > 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    }

