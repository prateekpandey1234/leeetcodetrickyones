package Greedy.medium;
//the approach here is to account every subarray which has sum greater than target
public class MinimumSubarraySum {
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];
            //this code here allows to minimize the size of subarray by reducing those elements which take up extra sum value
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];//here we decrease subarrays sum and size...
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
