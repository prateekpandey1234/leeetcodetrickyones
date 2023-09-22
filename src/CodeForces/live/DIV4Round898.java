package CodeForces.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DIV4Round898 {



      class Practice {
        //
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int t = Integer.parseInt(st.nextToken());
//        while(t-->0){
//            int i=0;
//            int cnt=0;
//            for(char ch : br.readLine().toCharArray()) {
//
//                if ((ch != ('a' + i++))) {
//                    cnt++;
//                }
//            }
//            System.out.println((cnt<=2)?"YES":"NO");
//        }
//    }
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int t = Integer.parseInt(st.nextToken());
//        while(t-->0){
//            int n = Integer.parseInt(br.readLine());
//            int[] arr = new int[10];
//            int ans=1;
//            int max=10;
//            st = new StringTokenizer(br.readLine());
//            for(int i=0;i<n;i++){
//                int curr = Integer.parseInt(st.nextToken());
//                arr[curr]+=1;
//                max=Math.min(max,curr);
//                if(curr!=0)ans*=curr;
//            }
//            if(arr[0]==1) System.out.println(ans);
//            else if(arr[0]>1) System.out.println(0);
//            else if(arr[1]>0)System.out.println(ans*2);
//            else System.out.println((ans/max)*(max+1));
//
//        }
//    }
//public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int t = Integer.parseInt(st.nextToken());
//    while(t-->0){
//
//        int i=0;
//        int ans=0;
//        while(i<10){
//            int j=0;
//            st = new StringTokenizer(br.readLine());
//            for(char ch :st.nextToken().toCharArray()) {
//                if(ch=='X' ) {
//                ans+=Math.min(Math.min(9-i,i),Math.min(9-j,j))+1;
//                }
//                j++;
//            }
//            i++;
//        }
//        System.out.println(ans);
//    }
//}
//public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int t = Integer.parseInt(st.nextToken());
//    while(t-->0){
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
//        int i =-1;
//        int ans=0;
//        String s = br.readLine();
//        for(int x=0;x<n;x++){
//            if(s.charAt(x)=='B'){
//                if(i==-1)i=x+0;
//                else if(x-i+1>k){
//                    ans++;
//                    i=x+0;
//                }
//            }
//
//        }
//        System.out.println((i==-1)?0:ans+1);
//
//    }
//}
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            while(t-->0){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
                List<Integer> arr = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<n;i++){
                    arr.add(Integer.parseInt(st.nextToken()));
                }
                int h=0;
                boolean flag=true;
                while(x>0){
                    h++;
                    for(int i=0;i<arr.size();i++) {
                        arr.add(i,arr.get(i)-1);
                        x--;
                        if(arr.get(i)==0)arr.remove(i);
                        if(x==0)break;
                    }
                }
                System.out.println(h);
            }

        }
    }

}
