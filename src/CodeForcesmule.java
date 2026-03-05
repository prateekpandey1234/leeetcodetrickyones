import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class CodeForcesmule {
    final static int p = 131;


    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static final long m = (long) (1e9 + 7);
    static StringTokenizer st;
    static BufferedReader br;
    static BufferedWriter out;
    static int upperBound = (int) 1e4 + 1;
    static int[] prime = new int[upperBound + 1];

    static ArrayList<Integer> primes = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        solve();

//        int t = Integer.parseInt(br.readLine());
//
////        prime(upperBound);
//        while (t-- > 0) {
//        // n-sum(k^i)
//            solve();
//        }


        out.flush();
    }


    static long[] t;

    public static void solve() throws IOException {
        // in
        st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int s=1;
        while(s<2*n){
            s = s<<1;
        }
        t= new long[s+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] freqOfI = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            freqOfI[i] = map.get(arr[i]);
        }
        map  = new HashMap<>();
        long ans=0;
        for(int i=n-1;i>-1;i--){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            int leftCount = freqOfI[i];
            if(leftCount>1){
                ans+=query(0,0,n-1,1,leftCount-1);
            }
            update(map.get(arr[i]),1,0,0,n-1);
        }

        System.out.println(ans);

    }

    boolean isPrime(int n) {
        if (n <= 1) return false; // 1 and numbers <= 0 are not prime
        if (n <= 3) return true;  // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // divisible by 2 or 3
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void update(int i , int val , int v , int l , int r){
        if(l==r){
            t[v]+=val;
            return;
        }
        int  m = (l+r)/2;
        if(i<=m){
            update(i,val,v*2+1,l,m);
        }
        else{
            update(i,val,v*2+2,m+1,r);
        }
        t[v] = t[v*2+1]+t[v*2+2];
    }

    public static long query(int v , int tl , int tr , int l , int r){
        if(l>r) return 0;
        if(tl==l && tr==r) return t[v];
        int tm = (tl+tr)/2;
        return query(v*2+1,tl,tm,l,Math.min(tm,r))+query( v*2+2,tm+1,tr,Math.max(tm+1,l),r);
    }














    // seive till root prime factor generation
    public static void prime(int upperBound) { // Complexity O(Nlog(log(N));
        primes = new ArrayList<>();
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i <= upperBound; i++) {
            if (prime[i] == 1) {
                for (long j = (long) i * i; j <= upperBound; j += i)
                    prime[(int) j] = 0;
                primes.add(i);
            }
        }
    }

    public static ArrayList<Integer> primeFactors(int N) { // Complexity O(sqrt(N) / ln (sqrt(N)));
        ArrayList<Integer> factors = new ArrayList<>();
        int PF_idx = 0;
        int PF = primes.get(PF_idx); // primes has been populated by sieve
        while (PF * PF <= N) { // stop at sqrt(N); N can get smaller
            while (N % PF == 0) {
                N /= PF;
                factors.add(PF);
            } // remove PF
            PF = primes.get(++PF_idx); // only consider primes!
        }
        if (N != 1)
            factors.add(N); // special case if N is a prime
        return factors; // if N does not fit in 32-bit integer and is a prime
    }



    public static int[] IntArray(int n) throws  IOException{
        int[] a = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)a[i]= Integer.parseInt(st.nextToken());
        return a;
    }
    public static long[] LongArray(int n) throws  IOException{
        long[] a = new long[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)a[i]= Long.parseLong(st.nextToken());
        return a;
    }
    public static ArrayList<Integer> IntList() throws IOException{
        ArrayList<Integer> arr= new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while( st.hasMoreTokens())arr.add(Integer.parseInt(st.nextToken()));
        return arr;
    }
    public static ArrayList<Long> LongList() throws IOException{
        ArrayList<Long> arr= new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(!st.hasMoreTokens())arr.add(Long.parseLong(st.nextToken()));
        return arr;
    }

    static long comb(int n , int i){
        long res=1;
        for(int j=1;j<=i;j++){
            res=(res*(long)(n-i+j))/j;
        }
        return res;
    }

    //https://e--maxx-ru.translate.goog/algo/mular_factorial?_x_tr_sch=http&_x_tr_sl=auto&_x_tr_tl=en&_x_tr_hl=en-GB
    long factm (long n) {
        int res = 1;
        while (n > 1) {
            res = (res * (((n/m) % 2==0) ? p-1 : 1)) % p;
            for (int i=2; i<=n%p; ++i)
                res = (res * i) % p;
            n /= p;
        }
        return res % p;
    }
    // we did this because we want our a to be the number which divides b with 0 remainder
    // so we store raminder on b side and the number which divides on a side
    // the order of number is irrespective beause reaminder will exchange on next turn when dividing by larger number
    // 4%6 == 6,2 , 6%4 == 4,2, 13%41 = 41,13-> 41%13 = 13,2 , 41%13 = 13,2
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int[] getFactorial(int num) {
        int[] factorial = new int[num + 1];
        factorial[0] = 1;
        for (int i = 1; i <= num; i++) {
            factorial[i] = (int) ((1L * factorial[i - 1] * i) % m);
        }
        return factorial;
    }
    private int[] getInverseFactorial(int num, int[] factorial) {
        int[] invFactorial = new int[num + 1];
        for (int i = 1; i <= num; i++) {
//            invFactorial[i] = (int) powm(factorial[i], m - 2) % m;
        }
        return invFactorial;
    }
    private long powm(long num, int pow) {
        long result = 1;
        while (pow >= 1) {
            if (pow % 2 == 1) {
                result = (result * num) % m;
            }
            pow /= 2;
            num = (num * num) % m;
        }
        return result;
    }

    public int twoCitySchedCost(int[][] costs) {
        int[][] a = new int[costs.length/2][2], b = new int[costs.length/2][2];
        for(int i=0;i<costs.length;i++){
            a[i]  = new int[]{costs[i][0],i};
            b[i]  = new int[]{costs[i][1],i};
        }
        Arrays.sort(a,((x,y)->Integer.compare(x[0],y[0])));
        Arrays.sort(b,((x,y)->Integer.compare(x[0],y[0])));
        int ans=0;
        int i=0,j=0;
        int[] pick  = new int[costs.length];
        for(;i<costs.length/2 || j<costs.length/2;){
            if(a[i][0]<=b[j][0] ){
                if(pick[a[i][1]]==0) ans+=a[i][0];
                pick[a[i][1]]=1;
                i++;
            }
            else if(a[i][0]>b[j][0]  ){
                if(pick[b[j][1]]==0)ans+=b[j][0];
                pick[b[j][1]]=1;
                j++;
            }
        }
        return ans;
    }


}





//class TreeNode{
//    int l ;
//    int r;
//    int v;
//    public TreeNode(int v,int l , int r){
//        this.l=l;
//        this.r=r;
//        this.v=v;
//    }
//}



//class Solution {
//    int[][] dp;
//    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
//        dp = new int [nums1.length][3];
//        int ans=0;
//        ans=f(a,b,0,0,2);
//        for(int[] r: dp)Arrays.fill(r,0);
//        ans=Math.max(ans,f(a,b,0,1,2));
//        return ans;
//    }
//    public int f(int [] a , int [] b , int i , int j , int sw ){
//        if(i>=a.length)return 0;
//        if(dp[i][j]!=0)return dp[i][j];
//        HashMap<Integer,Integer> map=new HashMap<>();
//        map.keySet();
//        int max=0;
//        if(j==0){
//            max=a[i]+f(a,b,i+1,j,sw);
//            if(sw+j>0){
//                dp[i][2]=b[i]+f(a,b,i+1,1,-2);
//            }
//        }
//        else if(j==1){
//            max=b[i]+f(a,b,i+1,j,sw);
//            if(sw+j>0){
//                dp[i][2]=a[i]+f(a,b,i+1,0,-2);
//            }
//        }
//        dp[i][j]=max;
//        return Math.max(dp[i][j],dp[i][2]);
//    }
//}

