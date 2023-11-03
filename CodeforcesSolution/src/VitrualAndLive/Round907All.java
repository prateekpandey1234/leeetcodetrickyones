package VitrualAndLive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Round907All {
    //public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int k = Integer.parseInt(br.readLine());
//    StringTokenizer st;
//    while (k-- > 0) {
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int[] arr = new int[n+1];
//        for(int i=1;i<n+1;i++){
//            arr[i]= Integer.parseInt(st.nextToken());
//        }
//        String ans = "YES";
//        int i=1;
//        for( ;i<n;i*=2){
//
//            for(int j=i+1;j<i*2 && j<n;j++){
//                if(arr[j]>arr[j+1]){
//
//                    ans="NO";
//                    break;
//                }
//            }
//        }
//        i/=2;
//        i++;
//        for(;i<n;i++){
//            if(arr[i]>arr[i+1]){
//
//                ans="NO";
//                break;
//            }
//        }
//        System.out.println(ans);
//
//    }
//
//}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()),q= Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] arr= new long[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());

            }
            st = new StringTokenizer(br.readLine());
            int  max=31;
            for(int i=0;i<q;i++){
                int x=Integer.parseInt(st.nextToken());
                //we only need to do divisions for minimum values as we go through array because after we add some values they can not
                // be divisble by higher nums
                // ex :-  16 is div by 2 and 4 but as 2 comes before 4 , after q[i]=2 , a[i]=16+4/2 a[i]=18, which mean 4 can no longer be operated here
                //therefore from next quesries we only need to check for lower values
                if(x<max){
                    long v = ((1L << (long)(x-1)));
                    long e = ((1L << (long)(x)));
                    for(int j=0;j<n;j++){

                        if(arr[j]%e==0){
                            arr[j]+=v;
                        }
                    }
                    max=x;
                }

            }

            for(int i=0;i<n;i++){
                System.out.print( arr[i] +" ");
            }
            System.out.println();
        }
}}
