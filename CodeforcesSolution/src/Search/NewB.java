package Search;

import java.util.Scanner;

public class NewB {
    static int n, m, q;
    static int[][] lr;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            lr = new int[m][2];
            for (int i = 0; i < m; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            q = scanner.nextInt();
            x = new int[q];
            for (int i = 0; i < q; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int left = 0;
        int right = q + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int ans = left == q + 1 ? -1 : left;
        return String.valueOf(ans);
    }

    private static boolean checkMid(int mid) {
        //a new empty array created each time for checking through array
        int[] nums = new int[n];
        //x is for query array
        for (int i = 0; i < mid; i++) {
            //here mid is the index in query  array

            nums[x[i] - 1]++;
        }
        int[] preSum = new int[n + 1];
        //we will calculate presum to find out how many 1 are there in array
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int[] p : lr) {
            int l = p[0], r = p[1];
            int ones = preSum[r] - preSum[l - 1];
            int zeros = (r - l + 1) - ones;
            if (ones > zeros) {
                return true;
            }
        }
        return false;
    }

}
