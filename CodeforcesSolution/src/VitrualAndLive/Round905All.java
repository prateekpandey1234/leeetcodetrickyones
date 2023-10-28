package VitrualAndLive;
import java.io.IOException;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Round905All {
 ;

     class PracticeCF {


        //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while (t-- > 0) {
//            int ans=0;
//             String s =  br.readLine();
//             char k='1';
//             for(char ch:s.toCharArray()){
//
//                     int curr=Math.abs(ch-k);
//                     if(k=='0' && ch=='0'){
//                         curr= 0;
//                     }
//                     else if((k=='0' || ch=='0') ){
//                         curr=Math.abs(Math.abs(ch-k)-10);
//                      }
//                     ans+=curr;
//                     k=ch;
//
//             }
//             System.out.println(ans+4);
//        }
//    }
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int tc = sc.nextInt();
//    while(tc--!=0){
//        int [] arr = new int[26];
//        int n=sc.nextInt();
//        int r=sc.nextInt();
//        String s = sc.next();
//        for(int i=0;i<n;i++){
//            arr[s.charAt(i)-'a']++;
//        }
//        int p=0,u=0;
//        for(int i=0;i<26;i++){
//            if(arr[i]%2==0)p++;
//            else u++;
//        }
//        if(r-u<0 ){
//            if(u==1 || r-u==-1) System.out.println("YES");
//            else System.out.println("NO");
//        }
//        else System.out.println("YES");
//    }
//}
//static Scanner sc;
//    public static void main(String[] args) {
//          sc = new Scanner(System.in);
//        int T = Integer.parseInt(sc.nextLine());
//        for(int i = 0; i < T; i++)
//            System.out.println(solve());
//    }
//
//    public static long solve() {
//        int N = sc.nextInt(), K = sc.nextInt(), minDist = 100, evenCnt = 0;
//        boolean exist = false;
//        int[] arr = new int[N];
//        for(int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//            if(arr[i]%2==0) evenCnt++;
//            if(arr[i]%K==0) exist = true;
//            if(K - (arr[i] % K) < minDist) minDist = K - (arr[i] % K);
//        }
//        if(exist) return 0;
//        if(K == 2) return 1;
//        if(K == 4) {
//            if(evenCnt > 1) return 0;
//            if(minDist == 1 || evenCnt == 1) return 1;
//            return 2;
//        }
//        return minDist;
//    }
//public static void main (String [] args) throws IOException {
//    final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//    int Q = 1;
//    while (Q > 0) {
//        StringTokenizer st = new StringTokenizer(input.readLine());
//        final int n = Integer.parseInt(st.nextToken());
//        final int[][] qs = new int[n][];
//        for (int i=0;i<n;++i){
//            //adding our queries one by one
//            String[] ss = input.readLine().split(" ");
//            if (ss[0].equals("+")){
//                qs[i] = new int[]{1, Integer.parseInt(ss[1]), Integer.parseInt(ss[2])};
//            }else {
//                qs[i] = new int[]{-1, Integer.parseInt(ss[1]), Integer.parseInt(ss[2])};
//            }
//        }
//        for (String s : calc(n, qs)){
//            System.out.println(s);
//        }
//        Q--;
//    }
//}
//    private static String[] calc(final int n, final int[][] qs) {
//    //we just have to check whether a single set is intersecting with other one
//    String[] ans = new String[n];
//    // the hasmaps here will tell us whether we need to delete our element from their respective priortiyqueue as we get '-' in our query
//    HashMap<Integer,Integer> m1= new HashMap<>(),m2= new HashMap<>();
//    //the priorityqueue allows us to compare the maximum l values currently and minimum r value after any operations
//    PriorityQueue<Integer> q1= new PriorityQueue<>(),q2=new PriorityQueue<>();
//    // the thing to notice is to ther eis no dependency betwenn l , r of a set , what we have to do is to check whether if the maximum l and minimum r at
//    // any moment of operation are holding that Max(l)>Min(r);
//    for(int i=0;i<n;i++){
//        if(qs[i][0]==1){
//            q1.add(-qs[i][1]);
//            q2.add(qs[i][2]);
//        }
//        else{
//            m1.put(-qs[i][1],m1.getOrDefault(-qs[i][1],0)+1);
//            m2.put(qs[i][2],m2.getOrDefault(qs[i][2],0)+1);
//        }
//        //deleting our peek value in PQ if there is a query which asks us to delete our num
//        while(!q1.isEmpty() && m1.getOrDefault(q1.peek(),0)>0){
//            int v= q1.poll();
//            m1.put(v,m1.get(v)-1);
//        }
//        while(!q2.isEmpty() && m2.getOrDefault(q2.peek(),0)>0){
//            int v= q2.poll();
//            m2.put(v,m2.get(v)-1);
//        }
//        if(q1.isEmpty() || -q1.peek()<=q2.peek()){
//            ans[i]="NO";
//        }
//        else{
//            ans[i]="YES";
//        }
//    }
//    return ans;
//    }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st;
            while (t-- > 0) {
                Stack<Long > stk =  new Stack<>();
                st = new StringTokenizer (br.readLine());
                int n =  Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                int [] a  = new int[n];
                for(int i=0;i<n;i++)a [i]= Integer.parseInt(st.nextToken());
                long ans = 0;
                int curr = 0;
                for (int i = 1; i < n; i++) {
                    int u = a[i-1];
                    int v = a[i];
                    if (u > v) {
                        //simple until we get our value greater we multiply
                        while (u > v) {
                            curr++;
                            v <<= 1;
                        }
                    } else {//this here is important as it saves storing new values in our array
                        //what we are doing here is that if we found a current value a[i] greater or equal to prev a[i-1] , where it may
                        // happen that our prev was used to increase curr as in above boolean logic , therefore we decrease the counter
                        // until our a[i-1] is larger than a[i]
                        //ex:- 7 1 5 3
                        //here curr=+3 will be at i=1 for u=7,v=1--> v=1*2*2*2=8 then v>u
                        /// at i==2 curr=-2 so that a[2]=5/2/2=1 such a[1]==a[2]
                        while ((u << 1) <= v && curr > 0) {
                            curr--;
                            u <<= 1;
                        }
                    }
                    ans += curr;//our current will vary after each iteration so need to add them everytime in answer
                }
                System.out.println(ans);;

            }
        }

    }















 }
