import java.util.*;
import java.io.*;

 class Codeforces {
     //    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()),q = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<n;i++){
//            if(i==n-1){
//            String s  = st.nextToken();
//            arr[i]=s.charAt(0)-'0';
//        } else arr[i]=Integer.parseInt(st.nextToken());}
//        for(int i=1;i<n;i++){
//
//            arr[i]=Math.min(arr[i],arr[i-1]);
//        }
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<q;i++){
//            int x = Integer.parseInt(st.nextToken());
//            if(x==n-1)System.out.print(Math.min(arr[x],arr[x-1])+" ");
//            else System.out.print(arr[x]+" ");
//        }
//    }
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        int[] arr = new int[26];
//        char ch = '1';
//        for(int i=0;i<s.length();i++){
//            arr[s.charAt(i)-'a']++;
//        }
//        for(int i=0;i<s.length();i+=2){
//            if(arr[s.charAt(i)-'a']==1){
//                ch=s.charAt(i);
//                System.out.println(ch);
//                break;
//            }
//        }
//        for(int i=1;i<s.length();i+=2){
//            if(ch=='1' && arr[s.charAt(i)-'a']==1){
//                ch = s.charAt(i);
//                System.out.println(ch);
//                break;
//            }
//        }
//        System.out.println((ch=='1')?"-1":" ");
//    }
     public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n= Integer.parseInt(st.nextToken());
         int[] arr =  new int[n];
         st = new StringTokenizer(br.readLine());
         int ans=0;
         for(int i=0;i<n;i++)arr[i]=Integer.parseInt(st.nextToken());
         Set<Integer> set = new HashSet<>();
         for(int i=0;i<n;i++){
             for(int j=0;j<n && j!=i;j++){
                 if(!set.contains(arr[i]*arr[j]))set.add(arr[i]*arr[j]);
                 else ans++;
             }
         }
         System.out.println(ans/2);

     }
}