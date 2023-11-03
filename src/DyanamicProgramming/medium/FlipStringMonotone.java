package DyanamicProgramming.medium;

public class FlipStringMonotone {
//         prefix[i] as the minimum number of flips (1 to 0) for prefix s[0, i], where 0 <= i <= n - 1.
//     suffix[i] as the minimum number of flips (0 to 1) for suffix s[i, n - 1], where 0 <= i <= n - 1.
//example : s= 00011000
//pre = [0,0,0,1,2,2,2,2]
//suf = [5,4,3,2,2,2,1,0]
//min = 2+0 = 2
 public int minFlipsMonoIncr(String s) {
   int n = s.length();
   // calculate prefix[] and suffix[]
   int[] prefix = new int[n];
   int[] suffix = new int[n];
   prefix[0] = s.charAt(0) == '1' ? 1 : 0;
   suffix[n - 1] = s.charAt(n - 1) == '0' ? 1 : 0;
   for (int i = 1, j = n - 2; i < n; ++i, --j) {
     prefix[i] = prefix[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
     suffix[j] = suffix[j + 1] + (s.charAt(j) == '0' ? 1 : 0);
   }
   // wehave to make our prefix and suffix as
   // pre  = 0,0,0,1,2,3...
   //suf   = 3,2,1,0,0,0... whic mean that there should be no case where for both pre and suf array pre[i]!=0 && suf[i]!=0
   // there fore to make our array like this will comapre each pre[i] to suf[i+1]
   // which here says that pre[i]== how many ones are at and before i and suf[i+1]== how many zeroes are after i
   // doing min(pre[i]+suf[i+1]) will give as  how many 1 and 0 are out of place with respect to ith position
   //therefore our answer would be an=Math.min(ans,pre[i]+suf[i+1]);
   // calculate the count
   int minCount = Integer.MAX_VALUE;
   for (int k = -1; k <= n - 1; ++k) {
     // 0: [0, k], 1: [k+1, n-1]
     int left = (k == -1) ? 0 : prefix[k];
     int right = (k + 1 == n) ? 0 : suffix[k + 1];
     minCount = Math.min(minCount, left + right);
   }
   return minCount;
 }
}
