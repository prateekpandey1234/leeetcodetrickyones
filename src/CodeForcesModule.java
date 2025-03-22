import java.util.*;
import java.io.*;

public class CodeForcesModule {
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

        int t = Integer.parseInt(br.readLine());

//        prime(upperBound);
        while (t-- > 0) {
        // n-sum(k^i)
            solve();
        }


        out.flush();
    }


    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        if(n<5){
            System.out.println(-1);
            return;
        }
        List<Integer> ans= new ArrayList<>();
        ans.add(2);
        ans.add(4);
        ans.add(5);
        ans.add(1);
        ans.add(3);
        int j=ans.size();
        for(int i=6;i<=n;i++){
            ans.add(j,i);
            if(j==0)j=ans.size();
            else j=0;
        }
        for(int i:ans)System.out.print(i+" ");
        System.out.println();
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

    //https://e--maxx-ru.translate.goog/algo/modular_factorial?_x_tr_sch=http&_x_tr_sl=auto&_x_tr_tl=en&_x_tr_hl=en-GB
    long factmod (long n) {
        int res = 1;
        while (n > 1) {
            res = (res * (((n/m) % 2==0) ? p-1 : 1)) % p;
            for (int i=2; i<=n%p; ++i)
                res = (res * i) % p;
            n /= p;
        }
        return res % p;
    }
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}



class Pair implements Comparable<Pair>{

    long v;
    int v2;
    public Pair(long v, int v2  ){
        this.v=v;

        this.v2=v2;
    }

    @Override
    public int compareTo(Pair o) {
        return  Long.compare(this.v,o.v);
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